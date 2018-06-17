package com.blend;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blend.Blend;
import com.blend.BlendRepository;
import com.ingredient.Ingredient;

@Service
public class BlendService implements IBlendService {

  @Autowired
  private BlendRepository repository;


  @Override
  public Collection<Blend> findAll(){
   return (Collection<Blend>) repository.findAll();
  }
}
