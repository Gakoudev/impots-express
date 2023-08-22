package com.isiexam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Declaration {
    private Long id;
    @NotNull(message = "La date de déclaration ne doit pas etre null")
    private LocalDate dateDeclaration;
    @NotNull(message = "Le montant de la déclaration ne doit pas etre null")
    private double montantDeclaration;
    @NotNull(message = "Le declarant  ne doit pas etre null")
    private Long declarantEntity;

    // Constructeurs, getters, setters
}

