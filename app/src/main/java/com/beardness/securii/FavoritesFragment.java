package com.beardness.securii;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.beardness.securii.Codez.Factories.AdapterFactory;
import com.beardness.securii.Codez.Factories.CursorFactory;
import com.beardness.securii.Codez.Factories.ListenerFactory;
import com.beardness.securii.SQLiteTools.PasswordDatabase;

public class FavoritesFragment extends Fragment {
  
  private ListView listPasswords;
  
  private SQLiteDatabase db;
  private Cursor cursor;
  
  private View view;
  
  @Override
  public View onCreateView(LayoutInflater inflater,
                           ViewGroup container,
                           Bundle savedInstanceState) {
    
    view = inflater.inflate(R.layout.fragment_favorites, container, false);
    listPasswords = view.findViewById(R.id.list_passwords);
    return view;
  }
  
  @Override
  public void onResume() {
    super.onResume();
    
    db = PasswordDatabase.getReadableDB(view.getContext());
    cursor = CursorFactory.getFavoritesCursor(db);
    listPasswords.setAdapter(AdapterFactory.getBasicCursorAdapter(view, cursor));
    listPasswords.setOnItemClickListener(ListenerFactory.getFavoritesListListener(view, cursor));
  }
  
  @Override
  public void onDestroy() {
    super.onDestroy();
    
    cursor.close();
    db.close();
  }
}