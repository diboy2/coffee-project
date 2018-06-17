package com.blend;

import javax.inject.Inject;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.blend.Blend;
import com.blend.BlendService;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class BlendRestController{

  @Autowired
  BlendService blendService;

  @Autowired
  public void setBlendService(BlendService blendService) {
    this.blendService = blendService;
  }

  @RequestMapping("/blends/findAll")
  public ResponseEntity<Collection<Blend>>getAllBlends() {
    return new ResponseEntity<>(blendService.findAll(), HttpStatus.OK);
  }
}
