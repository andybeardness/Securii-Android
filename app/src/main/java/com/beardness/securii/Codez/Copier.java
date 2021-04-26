package com.beardness.securii.Codez;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;

/**
 * Makes copy easy
 */
public class Copier {
  
  public static final String PASSWORD_TAG = "password"; // tag
  
  private static ClipboardManager clipboard;
  private static ClipData clip;
  
  private Copier(){}
  
  /**
   * Copy to buffer
   *
   * @param context context
   * @param tag tag
   * @param text text
   * @param resStrIdToastText resStrIdToastText
   */
  public static void copy(Context context, String tag, String text, int resStrIdToastText) {
    clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
    clip = ClipData.newPlainText(tag, text);
    clipboard.setPrimaryClip(clip);
  
    Toast.makeText(context, resStrIdToastText, Toast.LENGTH_SHORT).show();
  }
  
  /**
   * If nothing to copy
   *
   * @param context context
   * @param resStrIdToastText resStrIdToastText
   */
  public static void nothingToCopy(Context context, int resStrIdToastText) {
    Toast.makeText(context, resStrIdToastText, Toast.LENGTH_SHORT).show();
  }
  
  /**
   * Trying to copy password if exist
   *
   * @param context context
   * @param tag tag
   * @param text text
   * @param resStrIdDone resStrIdDone
   * @param resStrIdFalse resStrIdFalse
   */
  public static void tryToCopyPassword(Context context,
                                       String tag,
                                       String text,
                                       int resStrIdDone,
                                       int resStrIdFalse) {
    if (text.equals("")) {
      nothingToCopy(context, resStrIdFalse);
    }
    else {
      copy(context, tag, text, resStrIdDone);
    }
  }
}
