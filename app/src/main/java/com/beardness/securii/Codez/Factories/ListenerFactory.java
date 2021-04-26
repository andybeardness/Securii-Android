package com.beardness.securii.Codez.Factories;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.beardness.securii.AboutActivity;
import com.beardness.securii.AddNewPasswordActivity;
import com.beardness.securii.ChoosenPasswordActivity;
import com.beardness.securii.FavoritesActivity;
import com.beardness.securii.PasswordsActivity;

/**
 * Factory for listeners
 */
public class ListenerFactory {
  
  private ListenerFactory() {}
  
  /**
   * Getting main screen button "favorites" listener
   *
   * @param context context
   * @return listener
   */
  public static View.OnClickListener getMainButtonFavoriteListener(Context context) {
    return new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(context, FavoritesActivity.class);
        context.startActivity(intent);
      }
    };
  }
  
  /**
   * Getting main screen button "passwords" listener
   *
   * @param context context
   * @return listener
   */
  public static View.OnClickListener getMainButtonPasswordListener(Context context) {
    return new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(context, PasswordsActivity.class);
        context.startActivity(intent);
      }
    };
  }
  
  /**
   * Getting main screen button "about" listener
   *
   * @param context context
   * @return listener
   */
  public static View.OnClickListener getMainButtonAboutListener(Context context) {
    return new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(context, AboutActivity.class);
        context.startActivity(intent);
      }
    };
  }
  
  /**
   * Getting listener for FAB
   *
   * @param context context
   * @return listener
   */
  public static View.OnClickListener getFabListener(Context context) {
    return new View.OnClickListener() {
      Intent intent;
      
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(context, AddNewPasswordActivity.class);
        context.startActivity(intent);
      }
    };
  }
  
  /**
   * Getting listener for seek bar
   *
   * @param context context
   * @param value target textview to show progress
   * @return listener
   */
  public static SeekBar.OnSeekBarChangeListener getSeekLengthListener(Context context,
                                                                      TextView value) {
    return new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        value.setText(getStringValue(progress));
      }
      
      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {
      
      }
      
      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {
      
      }
    };
  }
  
  /**
   * Getting listener for password visibility button
   *
   * @param context context
   * @param password password
   * @param realPassword real password
   * @param cypherPassword cypher password
   * @param btnVisibility visibility button
   * @param resDrawIdVisibleOn resource drawable id "Visible On"
   * @param resDrawIdVisibleOff resource drawable id "Visible Off"
   * @return listener
   */
  public static View.OnTouchListener getVisibilityListener(Context context,
                                                           TextView password,
                                                           String realPassword,
                                                           String cypherPassword,
                                                           Button btnVisibility,
                                                           int resDrawIdVisibleOn,
                                                           int resDrawIdVisibleOff) {
    return new View.OnTouchListener() {
      @Override
      public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
          case MotionEvent.ACTION_DOWN:
            password.setText(realPassword);
            btnVisibility.setCompoundDrawablesWithIntrinsicBounds(0, resDrawIdVisibleOn, 0, 0);
            break;
          
          case MotionEvent.ACTION_UP:
            password.setText(cypherPassword);
            btnVisibility.setCompoundDrawablesWithIntrinsicBounds(0, resDrawIdVisibleOff, 0, 0);
            break;
          
        }
        
        System.out.println("PASSWORD == " + realPassword);
        
        return true;
      }
    };
  }
  
  /**
   * Getting listener for favorites list
   *
   * @param view view
   * @param cursor cursor
   * @return listener
   */
  public static AdapterView.OnItemClickListener getFavoritesListListener(View view,
                                                                         Cursor cursor) {
    return new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        cursor.moveToPosition(position);
        int passwordID = cursor.getInt(0);
        
        Intent intent = new Intent(view.getContext(), ChoosenPasswordActivity.class);
        intent.putExtra(ChoosenPasswordActivity.EXTRA_PASSWORD_ID, passwordID);
        view.getContext().startActivity(intent);
      }
    };
  }
  
  /**
   * Getting listener for passwords list
   *
   * @param context context
   * @return listener
   */
  public static AdapterView.OnItemClickListener getPasswordsListListener(Context context) {
    return new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(view.getContext(), ChoosenPasswordActivity.class);
        intent.putExtra(ChoosenPasswordActivity.EXTRA_PASSWORD_ID, (int) id);
        context.startActivity(intent);
      }
    };
  }
  
  /**
   * Creating String by format
   *
   * @param progress progress
   * @return formatted string
   */
  private static String getStringValue(int progress) {
    return String.format("%02d", (5 + progress * 5));
  }
  
}
