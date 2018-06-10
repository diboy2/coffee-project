
package coffee;
import javax.inject.Inject;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;

import coffee.Coffee;
import coffee.CoffeeService;

@RestController
@RequestMapping("/coffees")
@CrossOrigin(origins = "http://localhost:8081")
public class CoffeeRestController {

  @Autowired
  CoffeeService coffeeService;

  @Autowired
  public void setCoffeeService(CoffeeService coffeeService) {
    this.coffeeService = coffeeService;
  }

  @RequestMapping("/findAll")
  public ResponseEntity<Collection<Coffee>> getAllCoffees() {
      return new ResponseEntity<>(coffeeService.findAll(), HttpStatus.OK);
  }


}
