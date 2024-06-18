package sarn.entidad;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;

public abstract class Entidad implements Serializable {
    protected static final long serialVersionUID = 1L;
    public Integer id;
    public DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
}
