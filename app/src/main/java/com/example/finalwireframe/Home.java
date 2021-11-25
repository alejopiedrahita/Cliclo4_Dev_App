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
    private Intent intent;

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

    // Crear Menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        invalidateOptionsMenu(menu);
        return true;
    }

    // Ocultar opcion actual
    public boolean invalidateOptionsMenu(Menu menu) {
        menu.findItem(R.id.itemHome).setVisible(false);
        menu.findItem(R.id.itemRatingPlace).setVisible(false);
        return true;
    }

    // Funcionalidad Menu
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemHome:
                intent = new Intent(this, Home.class);
                startActivity(intent);
                return true;
            case R.id.itemRegisterPlace:
                intent = new Intent(this, RegisterPlace.class);
                startActivity(intent);
                return true;
            case R.id.itemFindPlace:
                intent = new Intent(this, FindPlace.class);
                startActivity(intent);
                return true;
            case R.id.itemReaderCode:
                intent = new Intent(this, ReaderCode.class);
                startActivity(intent);
                return true;
        }
        return true;
    }
}