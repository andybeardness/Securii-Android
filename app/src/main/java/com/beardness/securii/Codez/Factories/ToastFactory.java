package com.beardness.securii.Codez.Factories;

import android.content.Context;
import android.widget.Toast;

/**
 * Factory for Toast's
 */
public class ToastFactory {
  
  private ToastFactory(){}
  
  /**
   * Showing Toast
   *
   * @param context context
   * @param resStrIdToastText resource string toast text
   */
  public static void showToast(Context context, int resStrIdToastText) {
    Toast.makeText(context, resStrIdToastText, Toast.LENGTH_SHORT).show();
  }
}
