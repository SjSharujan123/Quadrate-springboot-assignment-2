package spring_boot_2com.example.Recipe.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring_boot_2com.example.Recipe.modals.Recipe;
import spring_boot_2com.example.Recipe.repositories.RecipesRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final RecipesRepository recipeRepository;

    public BootstrapData(RecipesRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("welcome to recipe Application");

        Recipe recipe = new Recipe();
        recipe.setName("Raspberry Lemon Drop Martini");
        recipe.setIngredients("10 fresh raspberries, or more to taste, lemon wedge");
        recipe.setDirections("Muddle 8 raspberries in the bottom of a cocktail shaker with lemon juice and sugar. " +
                            "Add vodka and ice. Shake for 1 minute, then strain into a chilled martini glass. " +
                            "Garnish with remaining raspberries and a lemon wedge.");

        recipeRepository.save(recipe);

    }
}
