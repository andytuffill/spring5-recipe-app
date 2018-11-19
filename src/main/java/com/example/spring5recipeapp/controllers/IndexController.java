package com.example.spring5recipeapp.controllers;

import com.example.spring5recipeapp.services.impl.RecipeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class IndexController {

    private RecipeServiceImpl recipeService;

    public IndexController(RecipeServiceImpl recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model){
        log.debug("getting index page");

        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
