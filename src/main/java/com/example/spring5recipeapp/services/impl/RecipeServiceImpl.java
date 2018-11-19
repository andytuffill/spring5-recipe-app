package com.example.spring5recipeapp.services.impl;

import com.example.spring5recipeapp.domain.Recipe;
import com.example.spring5recipeapp.repositories.RecipeRepository;
import com.example.spring5recipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    @Override
    public Set<Recipe> getRecipes() {

        log.debug("I'm in the service");

        Set<Recipe> recipeSet = new HashSet<>();

        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);

        return recipeSet;

    }
}
