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

import com.fasterxml.jackson.annotation.*;

import com.blend.Blend;

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

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "blend_id")
  @JsonBackReference
  private Blend blend;

  public Ingredient() {

  }

  public Ingredient (String name, String imageURL, Blend blend){
    this.name = name;
    this.imageURL = imageURL;
    this.blend = blend;
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
}
