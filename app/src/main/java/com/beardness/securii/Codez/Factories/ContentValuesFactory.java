package com.beardness.securii.Codez.Factories;

import android.content.ContentValues;

import com.beardness.securii.SQLiteTools.PasswordDatabase;

public class ContentValuesFactory {
  
  private ContentValuesFactory(){}
  
  public static ContentValues getAllCV(String name,
                                       String website,
                                       String password,
                                       int isFavorite) {
    ContentValues cv = new ContentValues();
    cv.put(PasswordDatabase.COL_NAME, name);
    cv.put(PasswordDatabase.COL_WEBSITE, website);
    cv.put(PasswordDatabase.COL_PASSWORD, password);
    cv.put(PasswordDatabase.COL_IS_FAVORITE, isFavorite);
    return cv;
  }
  
  public static ContentValues getUpdateFavoriteCV(int newFavoriteValue) {
    ContentValues cv = new ContentValues();
    cv.put(PasswordDatabase.COL_IS_FAVORITE, newFavoriteValue);
    return cv;
  }
}
