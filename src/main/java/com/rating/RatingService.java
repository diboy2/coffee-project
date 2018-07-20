package com.rating;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.Rating;
import com.rating.RatingRepository;

@Service
public class RatingService implements IRatingService {

    @Autowired
    private RatingRepository repository;

    @Override
    public Set<Rating> findAll() {
        return (Set<Rating>) repository.findAll();
    }
}