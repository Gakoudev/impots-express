package com.isiexam.mapping;

import com.isiexam.dto.Paiement;
import com.isiexam.entities.PaiementEntity;
import org.mapstruct.Mapper;

@Mapper
public interface PaiementMapper {
    Paiement toPaiement(PaiementEntity paiementEntity);
    PaiementEntity fromPaiement(Paiement paiement);
}
