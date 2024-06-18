package sarn.common;

import java.util.regex.Pattern;

public class PatronCadena {
    public static String regexSinNumeros = "^[^\\\\d]*$";
    public static Pattern textoSinNumeros = Pattern.compile(regexSinNumeros);
}
