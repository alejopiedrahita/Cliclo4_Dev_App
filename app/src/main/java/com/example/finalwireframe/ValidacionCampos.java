package com.example.finalwireframe;

import android.content.Context;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacionCampos {
    private Context context;

    // Validar registro de lugares
    public boolean formRegistros(String nombreLugar, String tipoPatrimonio, String keyWords, String keyTag, String ubicacion) {
        return true;
    }

    // Validar busqueda de lugares
    public boolean formBusqueda(String keyWords) {
        if(keyWords.length() == 0) {
            Toast.makeText(context, "Campo vacío", Toast.LENGTH_SHORT).show();
            return false;
        }else if (keyWords.length() <2) {
            Toast.makeText(context, "Longitud mínima 2 caracteres", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            String regex = "^[A-Za-z]+(, [A-Za-z]+)?$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(keyWords);
            if(matcher.find()) {
                Toast.makeText(context, "Busqueda correcta", Toast.LENGTH_SHORT).show();
                return true;
            }else {
                Toast.makeText(context, "Carácter inválido", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
    }

    // Validar asignación de etiquetas
    public boolean formEtiqueta(String keyTag) {
        if(keyTag.length() == 0) {
            Toast.makeText(context, "Campo vacío", Toast.LENGTH_SHORT).show();
            return false;
        }else if (keyTag.length() <2) {
            Toast.makeText(context, "Longitud mínima 2 caracteres", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            String regex = "^[a-zA-Z0-9]*$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(keyTag);
            if(matcher.find()) {
                Toast.makeText(context, "Etiqueta correcta", Toast.LENGTH_SHORT).show();
                return true;
            }else {
                Toast.makeText(context, "Carácter inválido", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
    }

    public void showToastMethod(Context context) {
        this.context = context;
    }

}