package ftn.aups.pastrywarehouse.recipe;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.aups.pastrywarehouse.domain.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
