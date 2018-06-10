package coffee;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coffee.Coffee;
import coffee.CoffeeRepository;

@Service
public class CoffeeService implements ICoffeeService {
  @Autowired
  private CoffeeRepository repository;

  @Override
  public Collection<Coffee> findAll() {
    return (Collection<Coffee>) repository.findAll();
  }

  @Override
  public Collection<Coffee> findByNameContaining(String name){
    return (Collection<Coffee>) repository.findByNameContaining(name);
  }
}
