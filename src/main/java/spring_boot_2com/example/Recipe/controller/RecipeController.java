package spring_boot_2com.example.Recipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring_boot_2com.example.Recipe.modals.Recipe;
import spring_boot_2com.example.Recipe.repositories.RecipesRepository;

@Controller
public class RecipeController {

    private final RecipesRepository recipesRepository;

    public RecipeController(RecipesRepository recipesRepository) {
        this.recipesRepository = recipesRepository;
    }

    @RequestMapping("/recipe")
    public String getRecipes(Model model){
        model.addAttribute("recipes",recipesRepository.findAll() );

        return "recipe/index";
    }

    @RequestMapping("/addRecipe")
    public String AddNewRecipe(Model model) {
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);

        return "recipe/addRec";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveRecipe(@ModelAttribute("recipe") Recipe recipe) {
        recipesRepository.save(recipe);

        return "redirect:/recipe";
    }
}
