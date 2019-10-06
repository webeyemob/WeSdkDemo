package com.wesdk.demo.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class ToastUtil {

    public static void show(Context context, String message) {
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
