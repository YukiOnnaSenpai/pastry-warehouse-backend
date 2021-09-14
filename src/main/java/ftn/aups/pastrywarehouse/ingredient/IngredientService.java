package ftn.aups.pastrywarehouse.ingredient;

import java.util.List;

import org.springframework.stereotype.Service;

import ftn.aups.pastrywarehouse.CrudService;
import ftn.aups.pastrywarehouse.domain.Ingredient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IngredientService implements CrudService<Ingredient> {

  private final IngredientRepository ingredientRepository;

  @Override
  public List<Ingredient> getAll() {
    return ingredientRepository.findAll();
  }

  @Override
  public Ingredient getOne(Long id) {
    return ingredientRepository.getOne(id);
  }

  @Override
  public Ingredient save(Ingredient ingredient) {
    return ingredientRepository.save(ingredient);
  }

  @Override
  public void delete(Long id) {

  }
}
