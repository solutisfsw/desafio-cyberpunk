package com.example.nero.clones.validador;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Nero on 26/02/2018.
 */

public class Validador {

    public static Boolean validarNome(String nome){
        final String regex = "[A-Z]{3}[0-9]{4}";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(nome);
        boolean validar = matcher.find();
        return validar;
    }

    public static boolean validarIdade(int idade){
        boolean validar = false;
        if(idade >= 10 && idade <= 20){
            validar = true;
        }
        return validar;
    }

}
