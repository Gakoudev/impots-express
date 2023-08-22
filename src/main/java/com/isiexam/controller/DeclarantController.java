package com.isiexam.controller;

import com.isiexam.dto.Declarant;
import com.isiexam.entities.DeclarantEntity;
import com.isiexam.service.DeclarantService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/declarant")
@AllArgsConstructor
public class DeclarantController {

    private DeclarantService declarantService;
    @GetMapping
    public List<Declarant> getDeclarants() {
        return declarantService.getDeclarants();
    }

      @PostMapping
          @ResponseStatus(code= HttpStatus.CREATED)
          public Declarant createDeclarants(@Valid @RequestBody Declarant declarant) {
             return declarantService.createDeclarant(declarant);
         }

}
