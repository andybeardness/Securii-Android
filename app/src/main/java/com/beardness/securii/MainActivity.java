package com.beardness.securii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.beardness.securii.Codez.Factories.ListenerFactory;
import com.beardness.securii.Codez.RandomJoke;

/**
 * Start screen
 */
public class MainActivity extends AppCompatActivity {
  
  private Button favorites;
  private Button passwords;
  private Button about;
  
  private TextView joke;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    // init views
    favorites = (Button) findViewById(R.id.favorites);
    passwords = (Button) findViewById(R.id.passwords);
    about = (Button) findViewById(R.id.about);
    joke = (TextView) findViewById(R.id.joke);
  
    // setting listeners by factory
    favorites.setOnClickListener(ListenerFactory.getMainButtonFavoriteListener(this));
    passwords.setOnClickListener(ListenerFactory.getMainButtonPasswordListener(this));
    about.setOnClickListener(ListenerFactory.getMainButtonAboutListener(this));
  }
  
  @Override
  protected void onResume() {
    super.onResume();
    // setting random joke
    joke.setText(RandomJoke.getRandomJoke(this));
  }
}