package com.isiexam.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeclarationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate dateDeclaration;
    @Column(nullable = false)
    private double montantDeclaration;

    @ManyToOne
    private DeclarantEntity declarantEntity;
    @OneToMany(mappedBy = "declarationEntity")
    private List<PaiementEntity> paiementEntities;

    // Constructeurs, getters, setters
}

