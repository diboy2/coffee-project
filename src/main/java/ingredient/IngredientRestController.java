package ingredient;
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

import ingredient.Ingredient;
import ingredient.IngredientService;

@RestController
@RequestMapping("/ingredients")
@CrossOrigin(origins = "http://localhost:8081")
public class IngredientRestController {
  @Autowired
  IngredientService ingredientService;

  @Autowired
  public void setIngredientService(IngredientService ingredientService) {
    this.ingredientService = ingredientService;
  }

  @RequestMapping("/findAll")
  public ResponseEntity<Collection<Ingredient>>
  getAllIngredients(){
    return new Responseentity<>(ingredientService.findAll(), HttpStatus.OK);
  }

  @RequestMapping(params={"blendId"}, method=RequestMethod.GET)
  public ResponseEntity<Collection<Ingredient>>findIngredientsByBlendId(@RequestParam(value="blendId") long blendId) {
    return new ResponseEntity<>(ingredientService.findIngredientsByBlendId(blendId), HttpStatus.OK);
  }
}
