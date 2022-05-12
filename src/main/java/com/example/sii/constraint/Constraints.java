package com.example.sii.constraint;

import java.util.HashMap;
import java.util.Map;

public interface Constraints {

  int LIMIT_OF_PARTICIPATES = 5;
  Map<Integer, String> HOURS = new HashMap<>() {{
    put(1, "10:00 - 11:45");
    put(2, "12:00 - 13:45");
    put(3, "14:00 - 15:45");
  }
  };

}
