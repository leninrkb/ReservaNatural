package sarn.common;

import java.time.format.DateTimeFormatter;

public class FormatoFecha {
    public static DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

}
