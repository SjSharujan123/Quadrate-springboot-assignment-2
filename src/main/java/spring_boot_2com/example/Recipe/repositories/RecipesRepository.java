package spring_boot_2com.example.Recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring_boot_2com.example.Recipe.modals.Recipe;

public interface RecipesRepository extends CrudRepository<Recipe, Long> {

}
