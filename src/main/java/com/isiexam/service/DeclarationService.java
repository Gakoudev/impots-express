package com.isiexam.service;

import com.isiexam.dao.IDeclarantRepository;
import com.isiexam.dao.IDeclarationRepository;
import com.isiexam.dto.Declaration;
import com.isiexam.entities.DeclarantEntity;
import com.isiexam.entities.DeclarationEntity;
import com.isiexam.exception.EntityNotFoundException;
import com.isiexam.exception.RequestException;
import com.isiexam.mapping.DeclarationMapper;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DeclarationService {
    private IDeclarationRepository iDeclarationRepository;
    private IDeclarantRepository iDeclarantRepository;


    private DeclarationMapper declarationMapper;
    MessageSource messageSource;


    public DeclarationService(IDeclarationRepository iDeclarationRepository, IDeclarantRepository iDeclarantRepository, DeclarationMapper declarationMapper, MessageSource messageSource) {
        this.iDeclarationRepository = iDeclarationRepository;
        this.iDeclarantRepository = iDeclarantRepository;
        this.declarationMapper = declarationMapper;
        this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    public List<Declaration> getDeclarations() {

        // Transformation des entités DeclarationEntity en DTO Declaration.
        return StreamSupport.stream(iDeclarationRepository.findAll().spliterator(), false)
                .map(declarationEntity -> {
                    // Conversion de l'entité DeclarationEntity en DTO Declaration
                    Declaration declarationDTO = declarationMapper.toDeclaration(declarationEntity);
                    // Récupération de l'entité DeclarantEntity associée à la déclaration
                    // et conversion en DTO Declarant pour l'inclure dans le DTO Declaration.
                    declarationDTO.setDeclarantEntity(declarationEntity.getDeclarantEntity().getId());
                    return declarationDTO;
                })
                .collect(Collectors.toList());
    }


    @Transactional
    public Declaration createDeclaration(Declaration declaration) {
        // Récupérer l'entité du déclarant à partir de l'ID inclus dans la déclaration
        DeclarantEntity declarantEntity = iDeclarantRepository.findById(declaration.getDeclarantEntity())
                .orElseThrow(() ->
                        new EntityNotFoundException("Déclarant introuvable"));

        // Créer l'entité DeclarationEntity à partir du DTO Declaration
        DeclarationEntity declarationEntity = declarationMapper.fromDeclaration(declaration);

        // Associer l'entité du déclarant à l'entité de la déclaration
        declarationEntity.setDeclarantEntity(declarantEntity);

        // Sauvegarder l'entité de la déclaration dans la base de données
        DeclarationEntity savedDeclarationEntity = iDeclarationRepository.save(declarationEntity);

        // Convertir l'entité sauvegardée en DTO et renvoyer le résultat
        Declaration declarationDTO = declarationMapper.toDeclaration(savedDeclarationEntity);
        declarationDTO.setDeclarantEntity(declarationEntity.getDeclarantEntity().getId());
        return declarationDTO;
    }


    @Transactional
    public Declaration updateDeclaration(Long id, Declaration declaration) {
        return iDeclarationRepository.findById(id)
                .map(entity -> {
                    declaration.setId(id);
                    return declarationMapper.toDeclaration(
                            iDeclarationRepository.save(declarationMapper.fromDeclaration(declaration)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("declaration.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteDeclaaration(Long id) {
        try {
            iDeclarationRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("declaration.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }


}
