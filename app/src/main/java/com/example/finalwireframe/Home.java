package com.example.finalwireframe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity implements View.OnClickListener {

    private Button btnRegisterPlace, btnFindPlace, btnReaderCode, btnFavoritePlaces;

    public void proccessEvents(int key) {
        switch (key) {
            case R.id.btnRegisterPlace:
                Intent intentRegister = new Intent(Home.this, RegisterPlace.class);
                startActivity(intentRegister);
                break;
            case R.id.btnFindPlace:
                Intent intentFind = new Intent(Home.this, FindPlace.class);
                startActivity(intentFind);
                break;
            case R.id.btnReaderCode:
                Intent intentReader = new Intent(Home.this, ReaderCode.class);
                startActivity(intentReader);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Asociar atributos
        btnRegisterPlace = findViewById(R.id.btnRegisterPlace);
        btnFindPlace = findViewById(R.id.btnFindPlace);
        btnReaderCode = findViewById(R.id.btnReaderCode);
        btnFavoritePlaces = findViewById(R.id.btnFavoritePlaces);

        // Asociar eventos
        btnRegisterPlace.setOnClickListener(this::onClick);
        btnFindPlace.setOnClickListener(this::onClick);
        btnReaderCode.setOnClickListener(this::onClick);
        btnFavoritePlaces.setOnClickListener(this::onClick);
    }

    public void registrarLugar(){
        Intent intent = new Intent(this, RegisterPlace.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        proccessEvents(v.getId());
    }
}