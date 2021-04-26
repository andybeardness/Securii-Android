package com.beardness.securii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.beardness.securii.StaticValues.Contacts;

public class AboutActivity extends AppCompatActivity {
  
  private Intent intent;
  private Uri uri;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_about);
  }
  
  public void onClickGithub(View view) {
    uri = Uri.parse(Contacts.GITHUB_URL);
    intent = new Intent(Intent.ACTION_VIEW, uri);
    startActivity(intent);
  }
  
  public void onClickInstagram(View view) {
    uri = Uri.parse(Contacts.INSTAGRAM_URL);
    
    try {
      intent = new Intent(Intent.ACTION_VIEW, uri);
      intent.setPackage(Contacts.INSTAGRAM_PACKAGE);
      startActivity(intent);
    } catch (Exception e) {
      intent = new Intent(Intent.ACTION_VIEW, uri);
      startActivity(intent);
    }
  }
  
  public void onClickTelegram(View view) {
    uri = Uri.parse(Contacts.TELEGRAM_URL);
    
    try {
      intent = new Intent(Intent.ACTION_VIEW, uri);
      intent.setPackage(Contacts.TELEGRAM_PACKAGE);
      startActivity(intent);
    } catch (Exception e) {
      intent = new Intent(Intent.ACTION_VIEW, uri);
      startActivity(intent);
    }
  }
  
}