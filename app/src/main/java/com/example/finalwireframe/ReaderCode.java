package com.example.finalwireframe;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class ReaderCode extends MenuBar implements View.OnClickListener{

    // Declarar atributos
    private EditText txtKeyTag;
    private Button btnKeyTag, btnScanner;
    private TextView txtBarCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader_code);

        // Asociar atributos
        txtKeyTag = findViewById(R.id.txtKeyTag);
        btnKeyTag = findViewById(R.id.btnKeyTag);
        btnScanner = findViewById(R.id.btnScanner);
        txtBarCode = findViewById(R.id.txtBarCode);

        // Asociar eventos
        btnKeyTag.setOnClickListener(this::onClick);
        btnScanner.setOnClickListener(this::onClick);
    }

    // Eventos
    public void proccessEvents(int key) {
        switch (key) {
            case R.id.btnKeyTag:
                // Obtener datos de la vista
                String keyTag = txtKeyTag.getText().toString();
                // Instanciar clase e invocar métodos
                ValidacionCampos vf = new ValidacionCampos();
                vf.showToastMethod(ReaderCode.this);
                vf.formEtiqueta(keyTag);
                break;
            case R.id.btnScanner:
                // Inicializar cámara
                new IntentIntegrator(this).initiateScan();
                break;
        }
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
        menu.findItem(R.id.itemReaderCode).setVisible(false);
        return true;
    }

    // Asociar eventos por ID
    @Override
    public void onClick(View v) {
        proccessEvents(v.getId());
    }

    // Scanear Barcode - QR
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() != null) {
                txtBarCode.setText(result.getContents());
            }else {
                txtBarCode.setText("Error al escanear el código");
            }
        }
    }
}