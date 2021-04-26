package com.beardness.securii.SQLiteTools;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.beardness.securii.Codez.Factories.CursorFactory;

public class PasswordDatabase extends SQLiteOpenHelper {
  
  public static final String DB_NAME = "PASSWORDS";
  public static final int DB_VERSION = 1;
  
  public static final String COL_NAME = "NAME";
  public static final String COL_WEBSITE = "WEBSITE";
  public static final String COL_PASSWORD = "PASSWORD";
  public static final String COL_IS_FAVORITE = "IS_FAVORITE";
  
  private static SQLiteOpenHelper db;
  private static SQLiteDatabase data;
  private static Cursor cursor;
  
  private PasswordDatabase(@Nullable Context context,
                           @Nullable String name,
                           @Nullable SQLiteDatabase.CursorFactory factory,
                           int version) {
    super(context, DB_NAME, null, DB_VERSION);
  }
  
  public static synchronized SQLiteDatabase getReadableDB(Context context) {
    if (db == null) {
      db = new PasswordDatabase(context, DB_NAME, null, DB_VERSION);
    }
    return db.getReadableDatabase();
  }
  
  public static synchronized SQLiteDatabase getWritableDB(Context context) {
    if (db == null) {
      db = new PasswordDatabase(context, DB_NAME, null, DB_VERSION);
    }
    return db.getWritableDatabase();
  }
  
  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE " + DB_NAME + "(" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            COL_NAME + " TEXT," +
            COL_WEBSITE + " TEXT," +
            COL_PASSWORD + " TEXT," +
            COL_IS_FAVORITE + " INTEGER" +
            ");");
  }
  
  @Override
  public void onUpgrade(SQLiteDatabase db,
                        int oldVersion,
                        int newVersion) {
  
  }
  
  public static boolean isEmptyDB(Context context) {
    data = getReadableDB(context);
    cursor = CursorFactory.getCountAllCursor(data);
    return checkIsEmptyByCursorDatabaseAndClose(data, cursor);
  }
  
  public static boolean isEmptyFavorites(Context context) {
    data = getReadableDB(context);
    cursor = CursorFactory.getCountFavoritesCursor(data);
    return checkIsEmptyByCursorDatabaseAndClose(data, cursor);
  }
  
  public static void deleteRowById(SQLiteDatabase db, String dbName, int rowID) {
    db.delete(dbName, "_id = ?", new String[]{String.valueOf(rowID)});
  }
  
  public static void updateRowById(SQLiteDatabase db,
                                   String dbName,
                                   int rowID,
                                   ContentValues cv) {
    db.update(dbName, cv, "_id = ?", new String[]{String.valueOf(rowID)});
  }
  
  private static boolean checkIsEmptyByCursorDatabaseAndClose(SQLiteDatabase db, Cursor cursor) {
    cursor.moveToFirst();
    boolean isEmpty = cursor.getInt(0) == 0;
    
    cursor.close();
    data.close();
    
    return isEmpty;
  }
}
