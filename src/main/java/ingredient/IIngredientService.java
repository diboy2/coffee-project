package ingredient;

import ingredient.Ingredient;
import java.util.Collection;

public interface IIngredientService {
  public Collection<Ingredient> findAll();
  public Collection<Ingredient> findByBlendId(long blendId);
}
