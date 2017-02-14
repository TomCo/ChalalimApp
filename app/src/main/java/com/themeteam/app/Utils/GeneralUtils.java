package com.themeteam.app.utils;

import android.app.ProgressDialog;
import android.content.Context;

import com.themeteam.app.R;

public class GeneralUtils {
    public static int[] iconResources = {R.mipmap.unknown, R.mipmap.ic_right_thumb, R.mipmap.ic_right_index, R.mipmap.ic_right_middle, R.mipmap.ic_right_ring, R.mipmap.ic_right_pinky, R.mipmap.ic_left_thumb, R.mipmap.ic_left_index, R.mipmap.ic_left_middle, R.mipmap.ic_left_ring, R.mipmap.ic_left_pinky};

    public static ProgressDialog getProgressDialog(String message, boolean isCancelable, Context context) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setMessage(message);
        dialog.setCancelable(isCancelable);
        return dialog;
    }
}
