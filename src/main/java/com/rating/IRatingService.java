package com.rating;

import com.rating.Rating;
import java.util.Set;

public interface IRatingService {
    public Set<Rating> findAll();
}