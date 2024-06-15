package main.java.sarn.entidad;
import java.time.format.DateTimeFormatter;

public abstract class Entidad {
    public Integer id;
    public DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
}
