package com.example.finalwireframe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ReaderCode extends AppCompatActivity {

    // Declarar atributos
    private EditText txtKeyTag;
    private Button btnKeyTag;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader_code);

        // Asociar atributos
        txtKeyTag = findViewById(R.id.txtKeyTag);
        btnKeyTag = findViewById(R.id.btnKeyTag);

        // Crear eventos
        btnKeyTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener datos de la vista
                String keyTag = txtKeyTag.getText().toString();
                // Instanciar clase e invocar métodos
                ValidacionCampos vf = new ValidacionCampos();
                vf.showToastMethod(ReaderCode.this);
                vf.formEtiqueta(keyTag);
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
        menu.findItem(R.id.itemReaderCode).setVisible(false);
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