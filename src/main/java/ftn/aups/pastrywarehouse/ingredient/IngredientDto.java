package ftn.aups.pastrywarehouse.ingredient;

import ftn.aups.pastrywarehouse.domain.IngredientType;
import ftn.aups.pastrywarehouse.recipe.RecipeDto;
import lombok.Data;

@Data
public class IngredientDto {

  private Long id;

  private String name;

  private IngredientType type;

  private int quantity;

  private String description;

  private RecipeDto recipeDto;
}
