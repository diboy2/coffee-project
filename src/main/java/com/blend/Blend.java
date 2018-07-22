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
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.*;

import com.ingredient.Ingredient;

import com.ratinggroup.RatingGroup;

@Entity
@Table(name ="blend")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, 
                  property  = "blendId", 
                  scope     = Long.class)
public class Blend {
  @Id
  @SequenceGenerator(name = "blend_local_seq", sequenceName = "blend_blend_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blend_local_seq")
  private long blendId;

  @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy="blend")
  private Set<Ingredient> ingredients;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name="blendId")
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

  public Set<RatingGroup> getRatingGroups(){
    return this.ratingGroups;
  }

  public void mapToIngredients(){
    this.ingredients.forEach( ingredient -> ingredient.setBlend(this));
  }

}
