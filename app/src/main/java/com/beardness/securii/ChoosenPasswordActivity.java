package com.beardness.securii;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.beardness.securii.Codez.Copier;
import com.beardness.securii.Codez.Factories.ContentValuesFactory;
import com.beardness.securii.Codez.Factories.CursorFactory;
import com.beardness.securii.Codez.Factories.ListenerFactory;
import com.beardness.securii.Codez.Factories.ToastFactory;
import com.beardness.securii.SQLiteTools.PasswordDatabase;
import com.beardness.securii.Codez.PassCypher;

public class ChoosenPasswordActivity extends AppCompatActivity {
  
  public static final String EXTRA_PASSWORD_ID = "password_id";
  
  private Intent intent;
  
  private int passwordID;
  
  private TextView name;
  private TextView website;
  private TextView password;
  
  private Button makeFavorite;
  private Button changeVisible;
  
  private String strName;
  private String strWebsite;
  private String strPassword;
  private String cypherPassword;
  private int isFavorite;
  
  private SQLiteDatabase db;
  private Cursor cursor;
  private ContentValues content;
  
  @SuppressLint("ClickableViewAccessibility")
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_choosen_password);
    
    intent = getIntent();
    
    passwordID = intent.getIntExtra(EXTRA_PASSWORD_ID, 0);
    
    name = (TextView) findViewById(R.id.name);
    website = (TextView) findViewById(R.id.website);
    password = (TextView) findViewById(R.id.password);
    
    makeFavorite = (Button) findViewById(R.id.do_favorite);
    changeVisible = (Button) findViewById(R.id.change_visible);
  
    db = PasswordDatabase.getReadableDB(this);
  
    cursor = CursorFactory.getRowByIdCursor(db, passwordID);
    cursor.moveToFirst();
  
    strName = cursor.getString(1);
    strWebsite = cursor.getString(2);
    strPassword = cursor.getString(3);
    isFavorite = cursor.getInt(4);
  
    cypherPassword = PassCypher.getCypherString(strPassword);
  
    name.setText(strName);
    website.setText(strWebsite);
    password.setText(cypherPassword);
  
    if (isFavorite == 1) {
      makeFavorite.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.make_favorite_on, 0, 0);
      makeFavorite.setText(R.string.ch_psw_btn_remove_favorite);
    }
    
    changeVisible.setOnTouchListener(
      ListenerFactory.getVisibilityListener(
        this,
        password,
        strPassword,
        cypherPassword,
        changeVisible,
        R.drawable.visible_on,
        R.drawable.visible_off
      )
    );
    
  }
  
  @Override
  protected void onResume() {
    super.onResume();
  }
  
  public void onClickChangePasswordFavorite(View view) {
    if (isFavorite == 1) {
      changePasswordFavorite(
              view,
              R.drawable.make_favorite_off,
              R.string.ch_psw_btn_add_favorite,
              R.string.toast_password_is_not_favorite);
    }
    else {
      changePasswordFavorite(
              view,
              R.drawable.make_favorite_on,
              R.string.ch_psw_btn_remove_favorite,
              R.string.toast_password_is_favorite);
    }
  }
  
  public void onClickDeletePassword(View view) {
    PasswordDatabase.deleteRowById(db, PasswordDatabase.DB_NAME, passwordID);
    ToastFactory.showToast(this, R.string.toast_password_has_deleted);
    onBackPressed();
  }
  
  public void onClickCopyPassword(View view) {
    Copier.copy(this, Copier.PASSWORD_TAG, strPassword, R.string.toast_copied);
  }
  
  private void changePasswordFavorite(View view,
                                      int resDrawIdButtonImage,
                                      int resStrIdButtonText,
                                      int resStrIdToastText) {
    makeFavorite.setCompoundDrawablesWithIntrinsicBounds(0, resDrawIdButtonImage, 0, 0);
    makeFavorite.setText(resStrIdButtonText);
    
    isFavorite = isFavorite == 0 ? 1 : 0;
    
    ToastFactory.showToast(this, resStrIdToastText);
    
    content = ContentValuesFactory.getUpdateFavoriteCV(isFavorite);
    PasswordDatabase.updateRowById(db, PasswordDatabase.DB_NAME, passwordID, content);
  }
  
  @Override
  protected void onDestroy() {
    super.onDestroy();
    
    cursor.close();
    db.close();
  }
  
}