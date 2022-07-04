 package com.example.vitclubapplication;

import android.content.Context;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

 public class message extends AppCompatActivity {
    public static void message(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}