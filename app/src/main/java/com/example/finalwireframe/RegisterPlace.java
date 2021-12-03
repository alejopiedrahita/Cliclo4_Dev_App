package com.example.finalwireframe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class RegisterPlace extends MenuBar {

    // Declarar atributos
    private EditText txtPlaceName, txtKeyWordName, txtKeyTagName, txtLocationPlace;
    private Spinner spnHeritageType;
    private Button btnRegisterNewPlace;
    private Intent intent;
    private String heritageType;
    private ValidacionCampos vf;
    private DataProcess dp;
    private Map map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_place);

        // Asociar atributos
        txtPlaceName = findViewById(R.id.txtPlaceName);
        spnHeritageType = findViewById(R.id.spnHeritageType);
        txtKeyWordName = findViewById(R.id.txtKeyWordName);
        txtKeyTagName = findViewById(R.id.txtKeyTagName);
        txtLocationPlace = findViewById(R.id.txtLocationPlace);
        btnRegisterNewPlace = findViewById(R.id.btnRegisterNewPlace);

        // Inicializar clases
        vf = new ValidacionCampos();
        dp  = new DataProcess();
        map = new Map();

        // Inhabilitar campo de etiqueta
        txtKeyTagName.setEnabled(false);
        txtKeyTagName.setText("");

        // Lista desplegable
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.type_heritage, android.R.layout.simple_list_item_1);
        spnHeritageType.setAdapter(adapter);

        // Crear eventos
        spnHeritageType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Capturar item seleccionado de la lista desplegable
                heritageType = (String) spnHeritageType.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnRegisterNewPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener datos de la vista
                String placeName = txtPlaceName.getText().toString();
                String keyWord = txtKeyWordName.getText().toString();
                String keyTag = txtKeyTagName.getText().toString();
                String locationPlace = txtLocationPlace.getText().toString();

                // Validar campos
                vf.showToastMethod(RegisterPlace.this);
                boolean fields = vf.formRegistros(placeName, heritageType, keyWord, keyTag, locationPlace);

                if(fields) {
                    // Validar coordenadas
                    boolean coordiantes = map.coordenadasLimites(locationPlace);
                    if(coordiantes) {
                        // Asignar etiqueta
                        String label = dp.generadorEtiqueta(placeName, heritageType);
                        txtKeyTagName.setText(label);
                        Toast.makeText(RegisterPlace.this, "Registro Éxitoso", Toast.LENGTH_SHORT).show();
                        //map.convertirUbicacion(locationPlace);
                    }else {
                        Toast.makeText(RegisterPlace.this, "Coordenas incorrectas", Toast.LENGTH_SHORT).show();
                    }
                }
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

    // Ocultar opcion menu
    public boolean invalidateOptionsMenu(Menu menu) {
        menu.findItem(R.id.itemRegisterPlace).setVisible(false);
        return true;
    }
}