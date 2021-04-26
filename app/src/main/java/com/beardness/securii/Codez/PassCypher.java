package com.beardness.securii.Codez;

public class PassCypher {
  
  private static final String cypher = "∎";
  
  private PassCypher(){}
  
  public static String getCypherString(String s) {
    int len = s.length();
    StringBuilder sb = new StringBuilder();
    
    for (int i = 0; i < len; i++) {
      sb.append(cypher);
    }
    
    return sb.toString();
  }
}
