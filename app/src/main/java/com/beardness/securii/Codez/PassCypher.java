package com.beardness.securii.Codez;

/**
 * Makes password more security
 */
public class PassCypher {
  
  private static final String cypher = "∎"; // cypher symbol to replace
  
  private PassCypher(){}
  
  /**
   * Replacing password chars to cypher symbols
   *
   * @param s password
   * @return cypher password
   */
  public static String getCypherString(String s) {
    int len = s.length();
    StringBuilder sb = new StringBuilder();
    
    for (int i = 0; i < len; i++) {
      sb.append(cypher);
    }
    
    return sb.toString();
  }
}
