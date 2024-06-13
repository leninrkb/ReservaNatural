package entidad;

import java.time.format.DateTimeFormatter;

public abstract class Entidad {
    public Integer id;
    public DateTimeFormatter patronFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
}
