package com.example.finalwireframe;

import java.util.ArrayList;

public class DataProcess {

    public String generadorEtiqueta(String nombreLugar, String tipoPatrimonio){

       // System.out.println(nombreLugar + tipoPatrimonio);

        String char3 =  nombreLugar.substring(0,3);
        String patri = "";
        int concecutivo = 1002;
        //System.out.println(char3);

        //System.out.println(tipoPatrimonio);
        if (tipoPatrimonio.equals("Patrimonio mueble")){
            patri = "PM";
        }
        else if (tipoPatrimonio.equals("Patrimonio inmueble")){
            patri = "PI";
        }
        //System.out.println(patri);

        String etiqueta = char3 + patri + concecutivo;
       // System.out.println(etiqueta);

        return etiqueta;
    }// ende generador




    public int contadorKeyWord(String keyWords){

        return 1;
    }// end contador


}
