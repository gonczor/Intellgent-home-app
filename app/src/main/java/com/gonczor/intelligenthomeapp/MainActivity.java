// Efem15 developing branch
package com.gonczor.intelligenthomeapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }

    public void onNextClick(View view) {
        Intent intent = new Intent(this, HomeMenuActivity.class);
        startActivity(intent);
    }
}
