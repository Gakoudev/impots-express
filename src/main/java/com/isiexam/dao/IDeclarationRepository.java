package com.isiexam.dao;

import com.isiexam.entities.DeclarationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDeclarationRepository extends JpaRepository<DeclarationEntity, Long> {
    @Query("SELECT d FROM DeclarationEntity d WHERE d.paiementEntities IS EMPTY")
    List<DeclarationEntity> findDeclarationsNonPayees();
}
