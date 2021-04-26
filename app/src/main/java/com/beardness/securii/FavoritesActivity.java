package com.beardness.securii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.beardness.securii.SQLiteTools.PasswordDatabase;

/**
 * Page with list of favorites activity
 */
public class FavoritesActivity extends AppCompatActivity {
  
  private final Fragment noPasswordsFragment = new NoPasswordsFragment(); // fragment if no saved passwords
  private final Fragment favoritesFragment = new FavoritesFragment(); // fragment if passwords exist
  
  private FragmentManager fManager;
  private FragmentTransaction fTransaction;
  
  private boolean dbIsEmpty;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_favorites);
  }
  
  @Override
  protected void onResume() {
    super.onResume();
  
    fManager = getSupportFragmentManager();
    fTransaction = fManager.beginTransaction();
    
    dbIsEmpty = PasswordDatabase.isEmptyFavorites(this);
    
    fTransaction = fManager.beginTransaction();
    if (dbIsEmpty) {
      fTransaction.replace(R.id.frame_passwords, noPasswordsFragment);
    }
    else {
      fTransaction.replace(R.id.frame_passwords, favoritesFragment);
    }
    fTransaction.commit();
  }
}