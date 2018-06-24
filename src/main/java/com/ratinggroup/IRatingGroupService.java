package com.ratinggroup;

import com.ratinggroup.RatingGroup;
import java.util.Set;

public interface IRatingGroupService {
  public Set<RatingGroup> findAll();
  public RatingGroup saveRatingGroup(RatingGroup ratingGroup);
}
