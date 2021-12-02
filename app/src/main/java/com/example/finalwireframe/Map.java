package com.example.finalwireframe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Map {

    public boolean coordenadasLimites(String ubicacion) {
        String regex = "^(-?\\d+(\\.\\d+)?),\\s*(-?\\d+(\\.\\d+)?)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ubicacion);

        if(matcher.find()) {
            String [] coordinates = ubicacion.split(",");
            double latitude = Double.parseDouble(coordinates[0]);
            double longitude = Double.parseDouble((coordinates[1]));

            if(latitude > 12.4466 || latitude < 4.2083 || longitude < -81.8501 || longitude > -66.8483) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public String convertirUbicacion(String ubicacion) {
        return null;
    }

}
