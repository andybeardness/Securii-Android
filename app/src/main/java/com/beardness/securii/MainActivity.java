package com.beardness.securii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.beardness.securii.Codez.Factories.ListenerFactory;
import com.beardness.securii.Codez.RandomJoke;

public class MainActivity extends AppCompatActivity {
  
  private Button favorites;
  private Button passwords;
  private Button about;
  
  private TextView joke;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    favorites = (Button) findViewById(R.id.favorites);
    passwords = (Button) findViewById(R.id.passwords);
    about = (Button) findViewById(R.id.about);
  
    favorites.setOnClickListener(ListenerFactory.getMainButtonFavoriteListener(this));
    passwords.setOnClickListener(ListenerFactory.getMainButtonPasswordListener(this));
    about.setOnClickListener(ListenerFactory.getMainButtonAboutListener(this));
    
    joke = (TextView) findViewById(R.id.joke);
  }
  
  @Override
  protected void onResume() {
    super.onResume();
    joke.setText(RandomJoke.getRandomJoke(this));
  }
}