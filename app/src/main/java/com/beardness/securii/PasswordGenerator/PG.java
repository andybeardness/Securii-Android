package com.beardness.securii.PasswordGenerator;

import java.util.Random;

/**
 * PG == Password Generator
 */
public class PG {
  
  private static final String LETTERS = "qwertyuiopasdfghjklzxcvbnm"; // lowercase letters
  private static final String UPPER_LETTERS = "QWERTYUIOPASDFGHJKLZXCVBNM"; // uppercase letters
  private static final String DIGITS = "1234567890"; // digits
  private static final String SYMBOLS = "!@#$%^&*()-_=+"; // symbols
  
  private static String[] base; // array of Strings
  
  private PG(){}
  
  /**
   * Generating password
   *
   * @param length password length
   * @param useUpperLetters "use upper letters?"
   * @param useDigits "use digits?"
   * @param useSymbols "use symbols?"
   * @return generated password
   */
  public static String generate(int length,
                                boolean useUpperLetters,
                                boolean useDigits,
                                boolean useSymbols) {
  
    Random random = new Random();
    
    String[] base = getBase(useUpperLetters, useDigits, useSymbols);
    StringBuilder result = new StringBuilder();
    
    for (int ib = 0; ib < length; ib++) {
      
      int b = random.nextInt(base.length); // get random char-pack
      int c = random.nextInt(base[b].length()); // get random char from char-pack
  
      result.append(base[b].charAt(c));
      
    }
    
    return result.toString();
  }
  
  /**
   * Returns base with conditions
   *
   * @param useUpperLetters "use upper letters?"
   * @param useDigits "use digits?"
   * @param useSymbols "use symbols?"
   * @return base
   */
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
