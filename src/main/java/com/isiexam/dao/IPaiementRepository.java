package com.isiexam.dao;

import com.isiexam.entities.DeclarationEntity;
import com.isiexam.entities.PaiementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPaiementRepository extends JpaRepository<PaiementEntity, Long> {
    List<PaiementEntity> findByDeclarationEntity(DeclarationEntity declarationEntity);

}
