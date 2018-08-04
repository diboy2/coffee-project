package com.rating;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

import com.ratinggroup.RatingGroup;

@Entity
@Table(name = "rating")
public class Rating{
  @Id
  @SequenceGenerator(name = "rating_local_seq", sequenceName = "rating_rating_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_local_seq")
  private long ratingId;

  @Column(name = "mean")
  private String mean;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "rating_group_id")
  @JsonBackReference
  private RatingGroup ratingGroup;

  @Column(name = "value")
  private long value;

  public Rating() {

  }

  public long getRatingId(){
    return this.ratingId;
  }

  public String getMean(){
    return this.mean;
  }

  public RatingGroup getRatingGroup(){
    return this.ratingGroup;
  }

  public long getValue(){
    return this.value;
  }

  public void setRatingGroup(RatingGroup ratingGroup) {
    this.ratingGroup = ratingGroup;
  }

}
