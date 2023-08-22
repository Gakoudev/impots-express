package com.isiexam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paiement {
    private Long id;
    @NotNull(message = "La date de paiement ne doit pas etre null")
    private LocalDate datePaiement;
    @NotNull(message = "Le montant du paiement ne doit pas etre null")
    private double montantPaiement;
    @NotNull(message = "La déclaration  ne doit pas etre null")
    private Long declarationEntity;

    // Constructeurs, getters, setters
}
