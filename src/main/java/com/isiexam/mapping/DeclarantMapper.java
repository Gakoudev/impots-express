package com.isiexam.mapping;

import org.mapstruct.Mapper;
import com.isiexam.dto.Declarant;
import com.isiexam.entities.DeclarantEntity;

@Mapper
public interface DeclarantMapper {

    Declarant toDeclarant(DeclarantEntity declarantEntity);
    DeclarantEntity fromDeclarant(Declarant declarant);
}
