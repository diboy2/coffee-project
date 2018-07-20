package com.rating;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rating.Rating;

@RepositoryRestResource
public interface RatingRepository extends JpaRepository<Rating, Long> {

}