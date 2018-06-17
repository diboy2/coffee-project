package com.ingredient;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingredient.Ingredient;
import com.ingredient.IngredientRepository;

@Service
public class IngredientService implements IIngredientService {
  @Autowired
  private IngredientRepository repository;

  @Override
  public Collection<Ingredient> findAll(){
    return (Collection<Ingredient>) repository.findAll();
  }

}
