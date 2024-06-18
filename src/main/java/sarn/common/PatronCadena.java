package sarn.common;

import java.util.regex.Pattern;

public class PatronCadena {
    public static String regexSinNumeros = "^[a-zA-Z]*$";
    public static Pattern textoSinNumeros = Pattern.compile(regexSinNumeros);
}
