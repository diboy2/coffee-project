package coffee;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
  Collection<Coffee> findByNameContaining(String name);
}

