package coffee;

import coffee.Coffee;
import java.util.Collection;

public interface ICoffeeService {
  public Collection<Coffee> findAll();
  public Collection<Coffee> findByNameContaining(String name);
}
