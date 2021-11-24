package com.example.finalwireframe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterPlace extends AppCompatActivity {

    // Declarar atributos
    private EditText txtPlaceName, txtHeritageType, txtKeyWordName, txtKeyTagName, txtLocationPlace;
    private Button btnRegisterNewPlace;

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
}