package com.blend;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;


import com.ingredient.Ingredient;

@Entity
@Table(name ="blend")
public class Blend {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long blendId;

  @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "blend")
  private Collection<Ingredient> ingredients;

  public Blend() {

  }

  public long getBlendId(){
    return this.blendId;
  }

  public void setIngredients(Collection<Ingredient> ingredients){
    this.ingredients = ingredients;
  }

  public Collection<Ingredient> getIngredients(){
    return this.ingredients;
  }

}
