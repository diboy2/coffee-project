package com.ingredient;

import com.ingredient.Ingredient;
import java.util.Collection;

public interface IIngredientService {
  public Collection<Ingredient> findAll();
}
