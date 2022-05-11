package com.example.sii.constraint;

import java.util.HashMap;
import java.util.Map;

public interface Constraints {

  Map<Integer, String> hours = new HashMap<>() {{
    put(1, "10:00 - 11:45");
    put(2, "12:00 - 13:45");
    put(3, "14:00 - 15:45");
  }
  };

}
