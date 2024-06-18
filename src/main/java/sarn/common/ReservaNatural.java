package sarn.common;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import sarn.entidad.*;

public class ReservaNatural implements Serializable{
    private static final long serialVersionUID = 1L;
    private static ReservaNatural clase;
    public List<Entidad> visitantes = new ArrayList<>();
    public List<Entidad> guardaparques = new ArrayList<>();
    public List<Entidad> incidencias = new ArrayList<>();
    public List<Entidad> visitas = new ArrayList<>();

    private ReservaNatural() { }

    public static ReservaNatural getInstance() {
        if (clase == null) {
            clase = new ReservaNatural();
            return clase;
        }
        return clase;
    }

    public static void setInstance(ReservaNatural rserva) {
        clase = rserva;
    }
}
