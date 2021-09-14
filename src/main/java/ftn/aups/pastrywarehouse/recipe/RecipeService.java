package ftn.aups.pastrywarehouse.recipe;

import java.util.List;

import org.springframework.stereotype.Service;

import ftn.aups.pastrywarehouse.CrudService;
import ftn.aups.pastrywarehouse.domain.Recipe;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeService implements CrudService<Recipe> {

  private final RecipeRepository recipeRepository;

  @Override
  public List<Recipe> getAll() {
    return recipeRepository.findAll();
  }

  @Override
  public Recipe getOne(Long id) {
    return recipeRepository.getOne(id);
  }

  @Override
  public Recipe save(Recipe recipe) {
    return recipeRepository.save(recipe);
  }

  @Override
  public void delete(Long id) {
    recipeRepository.deleteById(id);
  }
}
