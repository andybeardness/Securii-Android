package com.beardness.securii.Codez.Factories;

import android.content.Context;
import android.widget.Toast;

public class ToastFactory {
  
  private ToastFactory(){}
  
  public static void showToast(Context context, int resStrIdToastText) {
    Toast.makeText(context, resStrIdToastText, Toast.LENGTH_SHORT).show();
  }
}
