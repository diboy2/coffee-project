
package coffee;

import javax.persistence.*;

@Entity
public class Coffee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final long id;
  private String name;
  private String imageURL;
  private String description;

  public Coffee(long id, String name, String imageURL, String description){
    this.id = id;
    this.name = name;
    this.imageURL = imageURL;
    this.description = description;
  }

  public long getId(){
    return this.id;
  }

  public String getName(){
    return this.name;
  }

  public String getImageURL(){
    return this.imageURL;
  }

  public String getDescription(){
    return this.description;
  }
}
