package ftn.aups.pastrywarehouse.ingredient;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.aups.pastrywarehouse.domain.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
