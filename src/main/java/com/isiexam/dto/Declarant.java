package com.isiexam.dto;


import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Declarant {
    private Long id;
    @NotNull(message = "La raison sociale ne doit pas etre null")
    private String raisonSociale;
    @NotNull(message = "L'adresse ne doit pas etre null")
    private String adresse;
    @NotNull(message = "L'email ne doit pas etre null")
    private String email;
    @NotNull(message = "Le numéro de téléphone ne doit pas etre null")
    private String telephone;

    // Constructeurs, getters, setters
}
