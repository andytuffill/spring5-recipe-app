package com.example.spring5recipeapp.repositories;

import com.example.spring5recipeapp.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void findByDescription() {
        Optional<UnitOfMeasure> unitOfMeasureOptionalOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        assertEquals("Teaspoon", unitOfMeasureOptionalOptional.get().getDescription());

    }


    @Test
    public void findByDescriptionCup() {
        Optional<UnitOfMeasure> unitOfMeasureOptionalOptional = unitOfMeasureRepository.findByDescription("Cup");

        assertEquals("Cup", unitOfMeasureOptionalOptional.get().getDescription());

    }
}