package com.blend;

import com.blend.Blend;
import java.util.Collection;

public interface IBlendService {
  public Collection<Blend> findAll();
  public Blend saveBlend(Blend blend);
}
