package com.example.finalwireframe;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;


public class Splash extends AppCompatActivity {

    private ProgressBar progressBarSplash;
    private int progressCounter = 0;
    private TextView viewProgressBarSplash;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        progressBarSplash = findViewById(R.id.progressBarSplash);
        viewProgressBarSplash = findViewById(R.id.viewProgressBarSplash);

        // Start long running operation in a background thread
        new Thread(new Runnable() {
            public void run() {
                while (progressCounter < 100) {
                    progressCounter += 5;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            progressBarSplash.setProgress(progressCounter);
                            viewProgressBarSplash.setText(progressCounter +"/"+ progressBarSplash.getMax());
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Intent intent = new Intent(Splash.this, Home.class);
                startActivity(intent);
            }
        }).start();

    }

}