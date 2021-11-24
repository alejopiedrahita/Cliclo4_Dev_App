package com.example.finalwireframe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterPlace extends AppCompatActivity {

    // Declarar atributos
    private EditText txtPlaceName, txtHeritageType, txtKeyWordName, txtKeyTagName, txtLocationPlace;
    private Button btnRegisterNewPlace;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_place);

        // Asociar atributos
        txtPlaceName = findViewById(R.id.txtPlaceName);
        txtHeritageType = findViewById(R.id.txtHeritageType);
        txtKeyWordName = findViewById(R.id.txtKeyWordName);
        txtKeyTagName = findViewById(R.id.txtKeyTagName);
        txtLocationPlace = findViewById(R.id.txtLocationPlace);
        btnRegisterNewPlace = findViewById(R.id.btnRegisterNewPlace);

        // Crear eventos
        btnRegisterNewPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener datos de la vista
                String placeName = txtPlaceName.getText().toString();
                String heritageType = txtHeritageType.getText().toString();
                String keyWord = txtKeyWordName.getText().toString();
                String keyTag = txtKeyTagName.getText().toString();
                String locationPlace = txtLocationPlace.getText().toString();

                // Instanciar clase e invocar métodos
                ValidacionCampos vf = new ValidacionCampos();
                vf.showToastMethod(RegisterPlace.this);
                vf.formRegistros(placeName, heritageType, keyWord, keyTag, locationPlace);
            }
        });
    }

    // Crear Menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        invalidateOptionsMenu(menu);
        return true;
    }

    // Ocultar opcion actual
    public boolean invalidateOptionsMenu(Menu menu) {
        menu.findItem(R.id.itemRegisterPlace).setVisible(false);
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