
package com.coffee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "coffee")
public class Coffee {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "image_url")
  private String imageURL;

  @Column(name = "description")
  private String description;

  public Coffee() {
  }
  public Coffee( String name, String imageURL, String description){
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
