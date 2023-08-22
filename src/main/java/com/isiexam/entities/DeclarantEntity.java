package com.isiexam.entities;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeclarantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( nullable = false, length = 200)
    private String raisonSociale;
    @Column( nullable = false, length = 100)
    private String adresse;
    @Column(unique = true, nullable = false, length = 50)
    private String email;
    @Column( nullable = false, length = 50)
    private String telephone;
    @OneToMany(mappedBy = "declarantEntity")
    private List <DeclarationEntity> declarationEntities;

    // Constructeurs, getters, setters
}
