package ftn.aups.pastrywarehouse.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class WorkOrder {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Document document;

    private String number;

    @AttributeOverrides({
            @AttributeOverride(name="amount", column= @Column(name="purchasePriceAmount")),
            @AttributeOverride(name="currency", column= @Column(name="purchasePriceCurrency"))
    })
    private Price purchasePrice;

    @AttributeOverrides({
            @AttributeOverride(name="amount", column= @Column(name="sellingPriceAmount")),
            @AttributeOverride(name="currency", column= @Column(name="sellingPriceCurrency"))
    })
    private Price sellingPrice;

    private String planningPeriod;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductEmployee productEmployee;

    @OneToMany(
            mappedBy = "workOrder",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Recipe> recipes;

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
        recipe.setWorkOrder(this);
    }

    public void removeRecipe(Recipe recipe) {
        recipes.remove(recipe);
        recipe.setWorkOrder(null);
    }
}
