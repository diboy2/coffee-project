package ingredient;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "ingredient")
public class Ingredient {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long ingredientId;

  @Column(name = "name")
  private String name;

  @Column(name = "image_url")
  private String imageURL;

  @Column(blendId = "blend_id")
  private long blendId;

  public Ingredient() {

  }

  public Ingredient (String name, String imageURL, long blendId){
    this.name = name;
    this.imageURL = imageURL;
    this.blendId = blendId;
  }

  public long getIngredientId(){
    return this.ingredientId;
  }

  public String getName(){
    return this.name;
  }

  public String getImageURL(){
    return this.imageURL;
  }

  public long getBlendId(){
    return this.blendId;
  }
}
