package com.isiexam.dto;

import com.isiexam.dto.Declaration;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeclarationImpayee {
    private Long declaration;
    private double montantPaiement;
    private double resteAPayer;
}

