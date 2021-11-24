package com.example.finalwireframe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FindPlace extends AppCompatActivity {

    // Declarar atributos
    private EditText txtKeyWords;
    private Button btnKeyWords;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_place);

        // Asociar atributos
        txtKeyWords = findViewById(R.id.txtKeyWords);
        btnKeyWords = findViewById(R.id.btnKeyWords);

        // Crear eventos
        btnKeyWords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener datos de la vista
                String keyWords = txtKeyWords.getText().toString();
                // Instanciar clase e invocar métodos
                ValidacionCampos vf = new ValidacionCampos();
                vf.showToastMethod(FindPlace.this);
                vf.formBusqueda(keyWords);
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
        menu.findItem(R.id.itemFindPlace).setVisible(false);
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