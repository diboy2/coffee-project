package com.ratinggroup;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratinggroup.RatingGroup;
import com.ratinggroup.RatingGroupRepository;

@Service
public class RatingGroupService implements IRatingGroupService {

  @Autowired
  private RatingGroupRepository repository;

  @Override
  public Set<RatingGroup> findAll() {
    return (Set<RatingGroup>) repository.findAll();
  }

  @Override
  public RatingGroup saveRatingGroup(RatingGroup ratingGroup){
    ratingGroup.mapToRatings();
    return (RatingGroup)repository.save(ratingGroup);
  }
}
