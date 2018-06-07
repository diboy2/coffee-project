
package coffee;
import java.
util.
concurrent.atomic.AtomicLong;
import org.springframework.
web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeController {
  private static final String template = "%s";
  private final AtomicLong counter = new AtomicLong();

  @RequestMapping("/coffee")
  public Coffee coffee(@RequestParam(value="name", defaultValue="kona coffee") String name) {
    return new Coffee(counter.incrementAndGet(), String.format(template, name));
  }
}
