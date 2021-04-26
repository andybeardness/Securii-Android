package com.beardness.securii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.beardness.securii.SQLiteTools.PasswordDatabase;
import com.beardness.securii.Codez.Factories.ListenerFactory;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PasswordsActivity extends AppCompatActivity {
  
  private final Fragment noPasswordsFragment = new NoPasswordsFragment();
  private final Fragment passwordsFragment = new PasswordsFragment();
  
  private FragmentManager fManager;
  private FragmentTransaction fTransaction;
  
  private FloatingActionButton fab;
  
  private boolean dbIsEmpty;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_passwords);
    
    fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(ListenerFactory.getFabListener(this));
  }
  
  @Override
  protected void onResume() {
    super.onResume();
  
    fManager = getSupportFragmentManager();
    fTransaction = fManager.beginTransaction();
    
    dbIsEmpty = PasswordDatabase.isEmptyDB(this);
    
    fTransaction = fManager.beginTransaction();
    
    if (dbIsEmpty) {
      fTransaction.replace(R.id.frame_passwords, noPasswordsFragment);
    }
    else {
      fTransaction.replace(R.id.frame_passwords, passwordsFragment);
    }
    
    fTransaction.commit();
  }
  
}