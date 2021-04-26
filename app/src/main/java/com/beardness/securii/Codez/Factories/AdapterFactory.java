package com.beardness.securii.Codez.Factories;

import android.database.Cursor;
import android.view.View;
import android.widget.SimpleCursorAdapter;

import com.beardness.securii.SQLiteTools.PasswordDatabase;

public class AdapterFactory {
  
  private AdapterFactory(){}
  
  public static SimpleCursorAdapter getBasicCursorAdapter(View view, Cursor cursor) {
    return new SimpleCursorAdapter(
            view.getContext(),
            android.R.layout.simple_list_item_1,
            cursor,
            new String[]{PasswordDatabase.COL_NAME},
            new int[]{android.R.id.text1},
            0
    );
  }
  
}
