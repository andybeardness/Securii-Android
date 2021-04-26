package com.beardness.securii.Codez.Factories;

import android.content.ContentValues;

import com.beardness.securii.SQLiteTools.PasswordDatabase;

/**
 * Factory for ContentValues objects
 */
public class ContentValuesFactory {
  
  private ContentValuesFactory(){}
  
  /**
   * Getting all columns
   *
   * @param name name
   * @param website website
   * @param password password
   * @param isFavorite isFavorite
   * @return ContentValues
   */
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
  
  /**
   * Getting CV for update IS_FAORITE column
   *
   * @param newFavoriteValue new favorite value
   * @return CV
   */
  public static ContentValues getUpdateFavoriteCV(int newFavoriteValue) {
    ContentValues cv = new ContentValues();
    cv.put(PasswordDatabase.COL_IS_FAVORITE, newFavoriteValue);
    return cv;
  }
}
