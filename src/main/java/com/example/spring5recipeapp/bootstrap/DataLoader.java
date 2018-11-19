package com.example.spring5recipeapp.bootstrap;

import com.example.spring5recipeapp.domain.*;
import com.example.spring5recipeapp.repositories.CategoryRepository;
import com.example.spring5recipeapp.repositories.RecipeRepository;
import com.example.spring5recipeapp.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
@Slf4j
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public DataLoader(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    private void loadRecipes() {
        Category american = categoryRepository.findByDescription("American").get();
        Category mexican = categoryRepository.findByDescription("Mexican").get();

        UnitOfMeasure each = unitOfMeasureRepository.findByDescription("Each").get();
        UnitOfMeasure tbsp = unitOfMeasureRepository.findByDescription("Tablespoon").get();
        UnitOfMeasure tsp = unitOfMeasureRepository.findByDescription("Teaspoon").get();
        UnitOfMeasure dash = unitOfMeasureRepository.findByDescription("Dash").get();
        UnitOfMeasure pint = unitOfMeasureRepository.findByDescription("Pint").get();
        UnitOfMeasure cup = unitOfMeasureRepository.findByDescription("Cup").get();


        Recipe guacamole = new Recipe();
        guacamole.setDescription("Perfect Guacamole");

        guacamole.setPrepTime(10);
        guacamole.setCookTime(0);
        guacamole.setDifficulty(Difficulty.EASY);
        guacamole.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.");

        Notes guacamoleNotes = new Notes();
        guacamoleNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole).\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.");
        guacamole.setNotes(guacamoleNotes);

        guacamole.addIngredient(new Ingredient("ripe avocados",new BigDecimal(2),each));
        guacamole.addIngredient(new Ingredient("Kosher salt", new BigDecimal(0.5), tsp));
        guacamole.addIngredient(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(1), tbsp));
        guacamole.addIngredient(new Ingredient("minced red onion or thinly sliced green onion",new BigDecimal(2), tbsp));
        guacamole.addIngredient(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), each));
        guacamole.addIngredient(new Ingredient("cilantro (leaves and tender stems), finely chopped",new BigDecimal(2), tbsp));
        guacamole.addIngredient(new Ingredient("freshly grated black pepper", new BigDecimal(1), dash));
        guacamole.addIngredient(new Ingredient("ripe tomato, seeds and pulp removed, chopped",new BigDecimal(0.5 ), each));

        guacamole.getCategories().add(american);
        guacamole.getCategories().add(mexican);

        recipeRepository.save(guacamole);

        log.debug("loaded guacamole");


        Recipe tacos = new Recipe();
        tacos.setDescription("Spicy Grilled Chicken Tacos");
        tacos.setCookTime(9);
        tacos.setPrepTime(20);
        tacos.setDifficulty(Difficulty.MODERATE);

        tacos.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "Spicy Grilled Chicken Tacos\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");

        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!");
        tacos.setNotes(tacoNotes);

        tacos.addIngredient(new Ingredient("ancho chili powder", new BigDecimal(2), tbsp));
        tacos.addIngredient(new Ingredient("dried oregano", new BigDecimal(1), tsp));
        tacos.addIngredient(new Ingredient("dried cumin", new BigDecimal(1), tsp));
        tacos.addIngredient(new Ingredient("sugar", new BigDecimal(1),tsp));
        tacos.addIngredient(new Ingredient("salt", new BigDecimal(0.5),tsp));
        tacos.addIngredient(new Ingredient("clove of garlic, finely chopped", new BigDecimal(1), each));
        tacos.addIngredient(new Ingredient("finely grated orange zest", new BigDecimal(1), tbsp));
        tacos.addIngredient(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), tbsp));
        tacos.addIngredient(new Ingredient("olive oil", new BigDecimal(2), tbsp));
        tacos.addIngredient(new Ingredient("skinless, boneless chicken thighs (1 1/4 pounds)",new BigDecimal(4),each));
        tacos.addIngredient(new Ingredient("small corn tortillas",new BigDecimal(8), each));
        tacos.addIngredient(new Ingredient("packed baby arigula (3 ounces)", new BigDecimal(3), cup));
        tacos.addIngredient(new Ingredient("medium ripe avocados, sliced", new BigDecimal(2), each));
        tacos.addIngredient(new Ingredient("radishes, thinly sliced", new BigDecimal(4), each));
        tacos.addIngredient(new Ingredient("cherry tomatoes, sliced",new BigDecimal(0.25), pint));
        tacos.addIngredient(new Ingredient("red onion, thinly sliced", new BigDecimal(0.25), each));
        tacos.addIngredient(new Ingredient("roughly chopped cilantro", new BigDecimal(1), each));
        tacos.addIngredient(new Ingredient("sour cream", new BigDecimal(0.5), cup));// thinned with 1/4 cup milk
        tacos.addIngredient(new Ingredient("milk", new BigDecimal(0.25), cup));
        tacos.addIngredient(new Ingredient("lime, cut into wedges", new BigDecimal(1), each));

        tacos.getCategories().add(mexican);
        tacos.getCategories().add(american);


        recipeRepository.save(tacos);

        log.debug("loaded tacos");
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (recipeRepository.count()==0){
            loadRecipes();
        }
        log.debug("loading bootstrap data");
    }
}
