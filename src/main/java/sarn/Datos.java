package sarn;

import java.util.List;

import sarn.adminEntidad.AdminEntidad;
import sarn.adminEntidad.AdminVisita;
import sarn.adminEntidad.AdminVisitante;
import sarn.entidad.Entidad;

public class Datos {
    private static Datos clase;

    private Datos() {}

    public static Datos getInstance() {
        if (clase == null) {
            clase = new Datos();
            return clase;
        }
        return clase;
    }

    public void ingresarVisitantes(List<Entidad> entidades) {
        AdminVisitante admin = AdminVisitante.getInstance();
        admin.nuevaEntidad();
    }
}
