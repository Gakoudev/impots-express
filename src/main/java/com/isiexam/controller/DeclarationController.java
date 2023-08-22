package com.isiexam.controller;

import com.isiexam.dto.Declaration;
import com.isiexam.dto.DeclarationImpayee;
import com.isiexam.entities.DeclarationEntity;
import com.isiexam.service.DeclarationImpayeeService;
import com.isiexam.service.DeclarationService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/declaration")
@AllArgsConstructor
public class DeclarationController {

    private DeclarationService declarationService;
    private DeclarationImpayeeService declarationImpayeeService;
    @GetMapping
    public List<Declaration> getDeclaration() {
        return declarationService.getDeclarations();
    }
    @GetMapping("/nonpayees")
    public List<DeclarationImpayee> getDeclarationsNonPayees() {
        return declarationImpayeeService.getDeclarationsImpayees();
    }
    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public Declaration createDeclaration(@Valid @RequestBody Declaration declaration) {
        return declarationService.createDeclaration(declaration);
    }

}
