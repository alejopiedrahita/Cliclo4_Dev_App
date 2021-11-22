package com.example.finalwireframe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {

    private Button enviarRegistrarLugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        enviarRegistrarLugar = findViewById(R.id.buttonrRegistrarLugar);

        enviarRegistrarLugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarLugar();
            }
        });

    }

    public void registrarLugar(){
        Intent intent = new Intent(this, RegisterPlace.class);
        startActivity(intent);
    }

}