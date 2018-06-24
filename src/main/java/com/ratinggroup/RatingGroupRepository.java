package com.ratinggroup;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ratinggroup.RatingGroup;

@RepositoryRestResource
public interface RatingGroupRepository extends JpaRepository<RatingGroup, Long> {

}
