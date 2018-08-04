package com.ingredient;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.*;

import com.blend.Blend;

@Entity
@Table(name = "ingredient")
public class Ingredient {
  @Id
  @SequenceGenerator(name = "ingredient_local_seq", sequenceName = "ingredient_ingredient_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_local_seq")
  private long ingredientId;

  @Column(name = "name")
  private String name;

  @Column(name = "image_url")
  private String imageURL;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "blend_id")
  @JsonBackReference
  private Blend blend;

  public Ingredient() {

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

  public Blend getBlend(){
    return this.blend;
  }

  public void setBlend(Blend blend){
    this.blend = blend;
  }
}
