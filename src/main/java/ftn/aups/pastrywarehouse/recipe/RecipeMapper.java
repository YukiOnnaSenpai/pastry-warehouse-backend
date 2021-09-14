package ftn.aups.pastrywarehouse.recipe;

import org.springframework.stereotype.Component;

import ftn.aups.pastrywarehouse.domain.Recipe;
import ftn.aups.pastrywarehouse.mapper.Mapper;
import ftn.aups.pastrywarehouse.workOrder.WorkOrderMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RecipeMapper implements Mapper<RecipeDto, Recipe> {

  private final WorkOrderMapper workOrderMapper;

  @Override
  public RecipeDto toDto(Recipe recipe) {
    RecipeDto recipeDto = new RecipeDto();
    recipeDto.setName(recipe.getName());
    recipeDto.setWorkOrderDto(workOrderMapper.toDto(recipe.getWorkOrder()));
    return recipeDto;
  }

  @Override
  public Recipe toEntity(RecipeDto recipeDto) {
    Recipe recipe = new Recipe();
    recipe.setId(recipeDto.getId());
    recipe.setName(recipeDto.getName());
    recipe.setWorkOrder(workOrderMapper.toEntity(recipeDto.getWorkOrderDto()));
    return recipe;
  }
}
