package com.beardness.securii.PasswordGenerator;

import java.util.Random;

public class PG {
  
  private static final String LETTERS = "qwertyuiopasdfghjklzxcvbnm";
  private static final String UPPER_LETTERS = "QWERTYUIOPASDFGHJKLZXCVBNM";
  private static final String DIGITS = "1234567890";
  private static final String SYMBOLS = "!@#$%^&*()-_=+";
  
  private static String[] base;
  
  private PG(){}
  
  public static String generate(int length,
                                boolean useUpperLetters,
                                boolean useDigits,
                                boolean useSymbols) {
  
    Random random = new Random();
    
    String[] base = getBase(useUpperLetters, useDigits, useSymbols);
    StringBuilder result = new StringBuilder();
    
    for (int ib = 0; ib < length; ib++) {
      
      int b = random.nextInt(base.length);
      int c = random.nextInt(base[b].length());
  
      result.append(base[b].charAt(c));
      
    }
    
    return result.toString();
  }
  
  private static String[] getBase(boolean useUpperLetters,
                                  boolean useDigits,
                                  boolean useSymbols) {
  
    int baseCount = 1 + (useUpperLetters ? 1 : 0) + (useDigits ? 1 : 0) + (useSymbols ? 1 : 0);
    
    base = new String[baseCount];
    base[0] = LETTERS;
    
    int b = 1;
    if (useUpperLetters) {
      base[b++] = UPPER_LETTERS;
    }
    if (useDigits) {
      base[b++] = DIGITS;
    }
    if (useSymbols) {
      base[b++] = SYMBOLS;
    }
    
    return base;
  }
  
}
