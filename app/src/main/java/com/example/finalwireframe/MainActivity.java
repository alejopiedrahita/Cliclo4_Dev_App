package com.example.finalwireframe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    public Button vista_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vista_home = findViewById(R.id.buttonIniciar);

        vista_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviar_home();
            }
        });
    }

    public void enviar_home() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}