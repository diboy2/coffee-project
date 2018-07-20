package com.ratinggroup;

import com.ratinggroup.RatingGroup;
import java.util.Collection;

public interface IRatingGroupService {
  public Collection<RatingGroup> findAll();
  public RatingGroup saveRatingGroup(RatingGroup ratingGroup);
}
