package com.beardness.securii.Codez.Factories;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.beardness.securii.SQLiteTools.PasswordDatabase;

public class CursorFactory {
  
  private CursorFactory(){}
  
  public static Cursor getFavoritesCursor(SQLiteDatabase db) {
    return db.query(
            PasswordDatabase.DB_NAME,
            new String[]{"_id", "NAME"},
            PasswordDatabase.COL_IS_FAVORITE + " = ?",
            new String[]{"1"},
            null, null, null
    );
  }
  
  public static Cursor getPasswordsCursor(SQLiteDatabase db) {
    return db.query(
            PasswordDatabase.DB_NAME,
            new String[]{"_id", "NAME"},
            null, null, null, null, null
    );
  }
  
  public static Cursor getRowByIdCursor(SQLiteDatabase db,
                                        int rowID) {
    return db.query(
            PasswordDatabase.DB_NAME,
            new String[]{
                    "_id",
                    PasswordDatabase.COL_NAME,
                    PasswordDatabase.COL_WEBSITE,
                    PasswordDatabase.COL_PASSWORD,
                    PasswordDatabase.COL_IS_FAVORITE},
            "_id = ?",
            new String[]{String.valueOf(rowID)},
            null, null, null);
  }
  
  public static Cursor getCountFavoritesCursor(SQLiteDatabase db) {
    return db.rawQuery(
            "SELECT COUNT(*)" +
                    " FROM " + PasswordDatabase.DB_NAME +
                    " WHERE " + PasswordDatabase.COL_IS_FAVORITE + " = 1",
            null);
  }
  
  public static Cursor getCountAllCursor(SQLiteDatabase db) {
    return db.rawQuery("SELECT COUNT(*) FROM " + PasswordDatabase.DB_NAME, null);
  }
  
  
}
