package com.isiexam.service;

import com.isiexam.dao.IDeclarationRepository;
import com.isiexam.dao.IPaiementRepository;
import com.isiexam.dto.Declaration;
import com.isiexam.dto.Paiement;
import com.isiexam.entities.DeclarantEntity;
import com.isiexam.entities.DeclarationEntity;
import com.isiexam.entities.PaiementEntity;
import com.isiexam.exception.EntityNotFoundException;
import com.isiexam.exception.RequestException;
import com.isiexam.mapping.PaiementMapper;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PaiementService {
    private IPaiementRepository iPaiementRepository;
    private IDeclarationRepository iDeclarationRepository;
    private PaiementMapper paiementMapper;
    MessageSource messageSource;
    public PaiementService(IPaiementRepository iPaiementRepository, IDeclarationRepository iDeclarationRepository, PaiementMapper paiementMapper, MessageSource messageSource) {
        this.iPaiementRepository = iPaiementRepository;
        this.iDeclarationRepository = iDeclarationRepository;
        this.paiementMapper = paiementMapper;
        this.messageSource = messageSource;
    }


    @Transactional(readOnly = true)
    public List<Paiement>  getPaiements() {
        // Transformation des entités PaiementEntity en DTO Paiement.
        return StreamSupport.stream(iPaiementRepository.findAll().spliterator(), false)
                .map(paiementEntity -> {

                    // Conversion de l'entité PaiementEntity en DTO Paiement
                    Paiement paiementDTO = paiementMapper.toPaiement(paiementEntity);

                    // Récupération de l'identifiant de l'entité DeclarationEntity associée au paiement
                    paiementDTO.setDeclarationEntity(paiementEntity.getDeclarationEntity().getId());
                    return paiementDTO;
                })
                .collect(Collectors.toList());

    }


    @Transactional
    public Paiement createPaiement(Paiement paiement) {
        // Récupérer l'entité la déclaration à partir de l'ID inclus dans le paiement
        DeclarationEntity declarationEntity = iDeclarationRepository.findById(paiement.getDeclarationEntity())
                .orElseThrow(() ->
                        new EntityNotFoundException("Déclarant introuvable"));

        // Créer l'entité PaiementEntity à partir du DTO Paiement
        PaiementEntity paiementEntity = paiementMapper.fromPaiement(paiement);

        // Associer l'entité de la déclaration à l'entité du paiement
        paiementEntity.setDeclarationEntity(declarationEntity);

        // Sauvegarder l'entité du paiement dans la base de données
        PaiementEntity savedPaiementEntity = iPaiementRepository.save(paiementEntity);

        // Convertir l'entité sauvegardée en DTO et renvoyer le résultat
        Paiement paiementDTO = paiementMapper.toPaiement(savedPaiementEntity);
        paiementDTO.setDeclarationEntity(paiementEntity.getDeclarationEntity().getId());
        return paiementDTO;
    }

    @Transactional
    public Paiement updatePaiement(Long id, Paiement paiement) {
        return iPaiementRepository.findById(id)
                .map(entity -> {
                    paiement.setId(id);
                    return paiementMapper.toPaiement(
                            iPaiementRepository.save(paiementMapper.fromPaiement(paiement)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("paiement.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deletePaiement(Long id) {
        try {
            iPaiementRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("paiement.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }


}
