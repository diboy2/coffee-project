package blend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name ="blend")
public class Blend {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long blend_id;

  public Blend() {

  }

  public long getBlendId(){
    return this.blend_id;
  }
}
