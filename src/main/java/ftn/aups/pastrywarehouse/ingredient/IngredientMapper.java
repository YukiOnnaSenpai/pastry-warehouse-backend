package ftn.aups.pastrywarehouse.ingredient;

import org.springframework.stereotype.Component;

import ftn.aups.pastrywarehouse.domain.Ingredient;
import ftn.aups.pastrywarehouse.mapper.Mapper;
import ftn.aups.pastrywarehouse.recipe.RecipeMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class IngredientMapper implements Mapper<IngredientDto, Ingredient> {

  private final RecipeMapper recipeMapper;
  @Override
  public IngredientDto toDto(Ingredient ingredient) {
    IngredientDto ingredientDto = new IngredientDto();
    ingredientDto.setDescription(ingredient.getDescription());
    ingredientDto.setName(ingredient.getName());
    ingredientDto.setQuantity(ingredient.getQuantity());
    ingredientDto.setType(ingredient.getType());
    ingredientDto.setRecipeDto(recipeMapper.toDto(ingredient.getRecipe()));

    return ingredientDto;
  }

  @Override
  public Ingredient toEntity(IngredientDto ingredientDto) {
    Ingredient ingredient = new Ingredient();
    ingredient.setId(ingredientDto.getId());
    ingredient.setDescription(ingredientDto.getDescription());
    ingredient.setQuantity(ingredientDto.getQuantity());
    ingredient.setName(ingredientDto.getName());
    ingredient.setType(ingredientDto.getType());
    ingredient.setRecipe(recipeMapper.toEntity(ingredientDto.getRecipeDto()));

    return ingredient;
  }
}
