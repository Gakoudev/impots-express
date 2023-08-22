package com.isiexam.controller;

import com.isiexam.dto.Paiement;
import com.isiexam.entities.PaiementEntity;
import com.isiexam.service.PaiementService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paiement")
@AllArgsConstructor
public class PaiementController {

    private PaiementService paiementService;
    @GetMapping
    public List<Paiement> getPaiements() {
        return paiementService.getPaiements();
    }
    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public Paiement createPaiement(@Valid @RequestBody Paiement paiement) {
        return paiementService.createPaiement(paiement);
    }
}
