package com.isiexam.mapping;

import com.isiexam.dto.Declaration;
import com.isiexam.entities.DeclarationEntity;
import org.mapstruct.Mapper;

@Mapper
public interface DeclarationMapper {
    Declaration toDeclaration(DeclarationEntity declarationEntity);
    DeclarationEntity fromDeclaration(Declaration declaration);
}
