package ftn.aups.pastrywarehouse.ingredient;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ftn.aups.pastrywarehouse.domain.Ingredient;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class IngredientController {
  
  private final IngredientService ingredientService;
  private final IngredientMapper ingredientMapper;

  @GetMapping("api/ingredient")
  public List<IngredientDto> getAll() {
    return ingredientService.getAll().stream()
        .map(ingredientMapper::toDto)
        .collect(Collectors.toList());
  }

  @PostMapping("api/ingredient")
  public ResponseEntity<IngredientDto> insert(@RequestBody IngredientDto ingredientDto) {
    Ingredient save = ingredientService.save(ingredientMapper.toEntity(ingredientDto));
    return ResponseEntity.ok().body(ingredientMapper.toDto(save));
  }

  @PutMapping("api/ingredient/{id}")
  public ResponseEntity<IngredientDto> update(@RequestBody IngredientDto ingredientDto, @PathVariable("id") Long id) {
    ingredientDto.setId(id);
    Ingredient save = ingredientService.save(ingredientMapper.toEntity(ingredientDto));
    return ResponseEntity.ok().body(ingredientMapper.toDto(save));
  }

  @DeleteMapping("api/ingredient/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    ingredientService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
