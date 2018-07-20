package com.rating;

import javax.inject.Inject;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rating.Rating;
import com.rating.RatingService;

@RestController
@RequestMapping("/ratings")
@CrossOrigin(origins = "http://localhost:8081")
public class RatingRestController {
  @Autowired
  RatingService ratingService;

  @Autowired
  public void setRatingService(RatingService ratingService) {
    this.ratingService = ratingService;
  }
}
