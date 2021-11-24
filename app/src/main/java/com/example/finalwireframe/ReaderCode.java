package com.example.finalwireframe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ReaderCode extends AppCompatActivity {

    // Declarar atributos
    private EditText txtKeyTag;
    private Button btnKeyTag;

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
}