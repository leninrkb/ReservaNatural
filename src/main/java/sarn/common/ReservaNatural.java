package sarn.common;
import java.util.ArrayList;
import java.util.List;
import sarn.entidad.*;

public class ReservaNatural {
    private static ReservaNatural reservaNatural;
    public List<Entidad> visitantes = new ArrayList<>();
    public List<Entidad> guardaparques = new ArrayList<>();
    public List<Entidad> incidencias = new ArrayList<>();
    public List<Entidad> visitas = new ArrayList<>();

    private ReservaNatural() { }

    public static ReservaNatural getInstance() {
        if (reservaNatural == null) {
            reservaNatural = new ReservaNatural();
            return reservaNatural;
        }
        return reservaNatural;
    }
}
