package com.example.mapout;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class StartScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        TimerTask timer = new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent(StartScreenActivity.this, VenueActivity.class);
                startActivity(i);
            }
        };

        Timer splashScreen = new Timer();
        splashScreen.schedule(timer, 3000);
    }
}
