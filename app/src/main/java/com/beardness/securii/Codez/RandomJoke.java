package com.beardness.securii.Codez;

import android.content.Context;

import com.beardness.securii.R;

import java.util.Random;

public class RandomJoke {
  
  private static final Random random = new Random();
  private static String[] jokes;
  
  private RandomJoke(){}
  
  public static String getRandomJoke(Context context) {
    if (jokes == null) {
      jokes = context.getResources().getStringArray(R.array.main_jokes);
    }
    
    return jokes[random.nextInt(jokes.length)];
  }
}
