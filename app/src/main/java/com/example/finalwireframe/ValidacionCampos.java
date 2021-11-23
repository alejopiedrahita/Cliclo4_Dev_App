package com.example.finalwireframe;

import android.content.Context;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacionCampos {

    private Context context;

    // Validar registro de lugares
    public boolean formRegistros(String nombreLugar, String tipoPatrimonio, String keyWords, String keyTag, String ubicacion) {
        if(nombreLugar.isEmpty() || tipoPatrimonio.isEmpty() || keyWords.isEmpty() || keyTag.isEmpty() || ubicacion.isEmpty()) {
            Toast.makeText(context, "El campo no puede estar vacio", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            Pattern p = Pattern.compile("[a-zA-Z]{3,}");
            Matcher matcher1 = p.matcher(nombreLugar);
            Matcher matcher2 = p.matcher(tipoPatrimonio);
            Matcher matcher3 = p.matcher(keyWords);
            Matcher matcher4 = p.matcher(keyTag);
            Matcher matcher5 = p.matcher(ubicacion);

            if(matcher1.matches() && matcher2.matches() && matcher3.matches() && matcher4.matches() && matcher5.matches()) {
                Toast.makeText(context, "Registro éxitoso", Toast.LENGTH_SHORT).show();
                return true;
            }else {
                Toast.makeText(context, "El campo debe tener mas de 3 letras  y no puede contener caracteres especiales", Toast.LENGTH_SHORT).show();
                return false;
            }

        }
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