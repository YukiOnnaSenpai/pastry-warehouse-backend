package ftn.aups.pastrywarehouse.recipe;

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

import ftn.aups.pastrywarehouse.domain.Recipe;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RecipeController {
  
  private final RecipeService recipeService;
  private final RecipeMapper recipeMapper;

  @GetMapping("api/recipe")
  public List<RecipeDto> getAll() {
    return recipeService.getAll().stream()
        .map(recipeMapper::toDto)
        .collect(Collectors.toList());
  }

  @PostMapping("api/recipe")
  public ResponseEntity<RecipeDto> insert(@RequestBody RecipeDto recipeDto) {
    Recipe save = recipeService.save(recipeMapper.toEntity(recipeDto));
    return ResponseEntity.ok().body(recipeMapper.toDto(save));
  }

  @PutMapping("api/recipe/{id}")
  public ResponseEntity<RecipeDto> update(@RequestBody RecipeDto recipeDto, @PathVariable("id") Long id) {
    recipeDto.setId(id);
    Recipe save = recipeService.save(recipeMapper.toEntity(recipeDto));
    return ResponseEntity.ok().body(recipeMapper.toDto(save));
  }

  @DeleteMapping("api/recipe/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    recipeService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
