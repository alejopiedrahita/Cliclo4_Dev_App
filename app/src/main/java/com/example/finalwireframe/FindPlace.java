package com.example.finalwireframe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FindPlace extends AppCompatActivity {

    // Declarar atributos
    private EditText txtKeyWords;
    private Button btnKeyWords;

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
}