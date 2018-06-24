package com.ratinggroup;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

import com.rating.Rating;

import com.blend.Blend;

@Entity
@Table(name = "rating_group")
public class RatingGroup{
  @Id
  @SequenceGenerator(name = "rating_group_local_seq", sequenceName = "rating_group_rating_group_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_group_local_seq")
  @JsonManagedReference
  private long ratingGroupId;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "ratingGroup")
  @JsonManagedReference
  private Set<Rating> ratings;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "blend_id")
  @JsonBackReference
  private Blend blend;

  @Column(name = "user_id")
  private String user_id;

  public RatingGroup() {

  }

  public void setBlend(Blend blend){
    this.blend = blend;
  }

  public void setRatings(Set<Rating> ratings){
    this.ratings = ratings;
  }

  public void mapToRatings(){
    this.ratings.forEach( rating -> rating.setRatingGroup(this));
  }
}
