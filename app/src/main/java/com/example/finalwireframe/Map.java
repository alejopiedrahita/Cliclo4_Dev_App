package com.example.finalwireframe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Map {

    // este es un cambio de prueba

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

        //12.4444, -718052

        // convirtiendo latitude: si +, norte / si -, sur
        String[] coordinates = ubicacion.split(",");
        double latitude = Double.parseDouble(coordinates[0]);
        double longitude = Double.parseDouble((coordinates[1]));
        String orientacionLat;
        String orientacionLong;

        //latitud indica norte o sur, si es negative = sur, sino norte
        // longitud este oeste : si positiva = este sino oeste

        if(latitude < 0 ){
            orientacionLat = "S"; // sur
        }
        else{
            orientacionLat = "N";// Norte
        }

        if(longitude < 0 ){
            orientacionLong = "O"; // oeste
        }
        else{
            orientacionLong = "E"; //este
        }


        String[] latitudeInfo = String.valueOf(latitude).split("\\.");
        int gradosLat = Integer.parseInt(latitudeInfo[0]);
        double minutosLat = Double.parseDouble(latitudeInfo[1]) * 0.0060;

        if (gradosLat < 0 ){
            gradosLat = gradosLat * -1;
        }

        String[] minutesInfo = String.valueOf(minutosLat).split("\\.");
        int minutosTMP = Integer.parseInt(minutesInfo[0]);
        int segundosTMP = Integer.parseInt(minutesInfo[1]) * 60 / 1000;

        String latConverted = gradosLat + "°" + minutosTMP +"\'" + segundosTMP + "\"";

        // convirtiendo longitude

        String[] longitudeInfo = String.valueOf(longitude).split("\\.");
        int gradosLong = Integer.parseInt(longitudeInfo[0]);
        double minutosLong = Double.parseDouble(longitudeInfo[1]) * 0.0060;

        if (gradosLong < 0 ){
            gradosLong = gradosLong * -1;
        }

        String[] minuteInfo = String.valueOf(minutosLong).split("\\.");
        int minutoTMP = Integer.parseInt(minuteInfo[0]);
        int segundoTMP = Integer.parseInt(minuteInfo[1]) * 60 / 1000;

        String longConverted = gradosLong +"°"+ minutoTMP +"\'"+ segundoTMP +"\"";

        // concatenando

        String convertedLocation = latConverted + orientacionLat +", "+ longConverted + orientacionLong;


        return convertedLocation;
    }
}
