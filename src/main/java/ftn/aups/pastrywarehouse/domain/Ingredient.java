package ftn.aups.pastrywarehouse.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Ingredient {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private IngredientType type;

    private int quantity;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Recipe recipe;
}
