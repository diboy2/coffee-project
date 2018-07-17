package com.blend;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.*;

import com.ingredient.Ingredient;

import com.ratinggroup.RatingGroup;

@Entity
@Table(name ="blend")
public class Blend {
  @Id
  @SequenceGenerator(name = "blend_local_seq", sequenceName = "blend_blend_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blend_local_seq")
  private long blendId;

  @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "blend")
  @JsonManagedReference
  private Set<Ingredient> ingredients;

  @OneToMany(cascade = CascadeType.ALL, 
            fetch = FetchType.EAGER, 
            mappedBy = "blend")
  @JsonManagedReference
  private Set<RatingGroup> ratingGroups;

  public Blend() {

  }

  public long getBlendId(){
    return this.blendId;
  }

  public void setIngredients(Set<Ingredient> ingredients){
    this.ingredients = ingredients;
  }

  public Set<Ingredient> getIngredients(){
    return this.ingredients;
  }

  public void mapToIngredients(){
    this.ingredients.forEach( ingredient -> ingredient.setBlend(this));
  }
}
