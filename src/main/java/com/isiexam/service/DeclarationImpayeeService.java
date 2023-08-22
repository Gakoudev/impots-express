package com.isiexam.service;

import com.isiexam.dao.IDeclarationRepository;
import com.isiexam.dao.IPaiementRepository;
import com.isiexam.dto.DeclarationImpayee;
import com.isiexam.entities.DeclarationEntity;
import com.isiexam.entities.PaiementEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DeclarationImpayeeService {

    private IDeclarationRepository declarationRepository; // Repository pour les déclarations
    private IPaiementRepository paiementRepository; // Repository pour les paiements

    @Transactional(readOnly = true)
    public List<DeclarationImpayee> getDeclarationsImpayees() {
        List<DeclarationImpayee> declarationsImpayees = new ArrayList<>();

        // Récupère toutes les déclarations depuis le repository
        List<DeclarationEntity> allDeclarations = declarationRepository.findAll();

        // Parcours toutes les déclarations
        for (DeclarationEntity declarationEntity : allDeclarations) {
            double montantDeclaration = declarationEntity.getMontantDeclaration();

            // Récupère tous les paiements associés à cette déclaration depuis le repository
            List<PaiementEntity> paiements = paiementRepository.findByDeclarationEntity(declarationEntity);

            // Calcule le montant total des paiements pour cette déclaration
            double montantPaiements = paiements.stream()
                    .mapToDouble(PaiementEntity::getMontantPaiement)
                    .sum();

            // Vérifie si la déclaration est impayée en comparant les montants
            if (montantPaiements < montantDeclaration) {
                DeclarationImpayee declarationImpayee = new DeclarationImpayee();
                declarationImpayee.setDeclaration(declarationEntity.getId());
                declarationImpayee.setMontantPaiement(montantPaiements);
                declarationImpayee.setResteAPayer(montantDeclaration - montantPaiements);
                declarationsImpayees.add(declarationImpayee);
            }
        }

        return declarationsImpayees; // Retourne la liste des déclarations impayées
    }
}

