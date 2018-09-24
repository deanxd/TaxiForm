package com.deanxd.taxiform.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.deanxd.taxiform.R;

public class MainActivity extends AppCompatActivity {


    public static void startActivity(Context ctx) {
        ctx.startActivity(new Intent(ctx, MainActivity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
