package com.ratinggroup;

import javax.inject.Inject;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ratinggroup.RatingGroup;
import com.ratinggroup.RatingGroupService;

@RestController
@RequestMapping("/ratingGroups")
@CrossOrigin(origins = "http://localhost:8081")
public class RatingGroupRestController {
  @Autowired
  RatingGroupService ratingGroupService;

  @Autowired
  public void setRatingGroupService(RatingGroupService ratingGroupService) {
    this.ratingGroupService = ratingGroupService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Collection<RatingGroup>>getAllRatingGroups(){
    return new ResponseEntity<>(ratingGroupService.findAll(), HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<?> addRatingGroup(@RequestBody RatingGroup ratingGroup) {
    return new ResponseEntity<>(ratingGroupService.saveRatingGroup(ratingGroup), HttpStatus.CREATED);
  }

  
}
