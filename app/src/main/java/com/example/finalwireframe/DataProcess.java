package com.example.finalwireframe;

public class DataProcess{
    private int prefix = 1000;

    public String generadorEtiqueta(String nombreLugar, String tipoPatrimonio) {
        
        if(nombreLugar.isEmpty() || tipoPatrimonio.isEmpty()) {
            return "Tiene campos vacíos”";
        }else {
            String place = nombreLugar.substring(0, 3);
            String heritage = "";

            if(tipoPatrimonio.equals("Patrimonio Mueble")) {
                heritage = "PM";
                prefix += 1;
            }else {
                heritage = "PI";
                prefix += 1;
            }

            String label = place.toUpperCase() + heritage + prefix;
            System.out.println("Etiqueta: " +label);
            return label;
        }
    }

    public int contadorKeyWord(String keyWords) {
        String [] listKeyWord = keyWords.split(",");
        System.out.println("Cantidad lugares: " + listKeyWord.length);
        return listKeyWord.length;
    }
}
