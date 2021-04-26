package com.beardness.securii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.beardness.securii.Codez.Copier;
import com.beardness.securii.Codez.Factories.ContentValuesFactory;
import com.beardness.securii.PasswordGenerator.PG;
import com.beardness.securii.SQLiteTools.PasswordDatabase;
import com.beardness.securii.Codez.Factories.ListenerFactory;

public class AddNewPasswordActivity extends AppCompatActivity {
  
  private EditText name;
  private EditText website;
  
  private SeekBar seek;
  private TextView length;
  private EditText password;
  
  private CheckBox useUppers;
  private CheckBox useDigits;
  private CheckBox useSymbols;
  
  private ContentValues content;
  
  private SQLiteDatabase db;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_new_password);

    name = (EditText) findViewById(R.id.name);
    website = (EditText) findViewById(R.id.website);
    
    seek = (SeekBar) findViewById(R.id.seek_length);
    length = (TextView) findViewById(R.id.seek_length_value);
    
    seek.setOnSeekBarChangeListener(ListenerFactory.getSeekLengthListener(this, length));

    password = (EditText) findViewById(R.id.password);
  
    useUppers = (CheckBox) findViewById(R.id.useUppers);
    useDigits = (CheckBox) findViewById(R.id.useDigits);
    useSymbols = (CheckBox) findViewById(R.id.useSymbols);
  }
  
  public void onClickCopyPassword(View view) {
    
    String passwordText = password.getText().toString();
    
    Copier.tryToCopyPassword(
            this,
            Copier.PASSWORD_TAG,
            passwordText,
            R.string.toast_copied,
            R.string.toast_nothing_to_copy);
  }
  
  public void onClickGeneratePassword(View view) {
    int size = Integer.parseInt(length.getText().toString());
    String psw = PG.generate(size,
                             useUppers.isChecked(),
                             useDigits.isChecked(),
                             useSymbols.isChecked());
    password.setText(psw);
  }
  
  public void onClickSavePassword(View view) {
    String strName = name.getText().toString();
    String strWebsite = website.getText().toString();
    String strPassword = password.getText().toString();
    
    boolean isEmptyName = isStringEmpty(strName);
    boolean isEmptyPassword = isStringEmpty(strPassword);
    
    if (isEmptyName || isEmptyPassword) {
      Toast.makeText(this, R.string.toast_found_empty_fields, Toast.LENGTH_SHORT).show();
    }
    else {
      db = PasswordDatabase.getWritableDB(this);
      content = ContentValuesFactory.getAllCV(strName, strWebsite, strPassword, 0);
      db.insert(PasswordDatabase.DB_NAME, null, content);
      
      onBackPressed();
    }
    
  }
  
  private boolean isStringEmpty(String s) {
    return s.equals("");
  }
  
  @Override
  protected void onDestroy() {
    super.onDestroy();
  
    db.close();
  }
}