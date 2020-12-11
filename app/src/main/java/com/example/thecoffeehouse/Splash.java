package com.example.thecoffeehouse;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thecoffeehouse.Login.Login;
import com.example.thecoffeehouse.Login.SignIn_Activity;

import static android.os.SystemClock.sleep;
public class Splash extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                sleep(5000);
                Intent i = new Intent(Splash.this, SignIn_Activity.class);
                startActivity(i);
            }
        });
        thread.start();
    }
}
