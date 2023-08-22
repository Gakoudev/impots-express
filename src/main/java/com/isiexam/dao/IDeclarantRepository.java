package com.isiexam.dao;

import com.isiexam.entities.DeclarantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDeclarantRepository extends JpaRepository<DeclarantEntity, Long> {
    DeclarantEntity findByEmail(String email);
}
