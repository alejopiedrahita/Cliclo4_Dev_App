package com.example.finalwireframe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ReaderCode extends MenuBar {

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

    // Barra Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        invalidateOptionsMenu(menu);
        return true;
    }

    public boolean invalidateOptionsMenu(Menu menu) {
        menu.findItem(R.id.itemReaderCode).setVisible(false);
        return true;
    }
}