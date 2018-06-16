package ingredient;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ingredient.Ingredient;
import ingredient.IngredientRepository;

@Service
public class IngredientService implements IIngredientService {
  @Autowired
  private IngredientRepository repository;

  @Override
  public Collection<Ingredient> findAll(){
    return (Collection<Ingredient>) repository.findAll();
  }

  @Override
  public Collection<Ingredient> findByBlendId(long blendId) {
    return (Collection<Ingredient>) repository.findByBlendId(blendId);
  }

}
