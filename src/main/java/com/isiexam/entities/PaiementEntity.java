package com.isiexam.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaiementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate datePaiement;
    @Column(nullable = false)
    private double montantPaiement;

    @ManyToOne
    private DeclarationEntity declarationEntity;

    // Constructeurs, getters, setters
}
