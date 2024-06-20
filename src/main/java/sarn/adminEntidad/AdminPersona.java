package sarn.adminEntidad;

import java.util.List;
import sarn.entidad.Entidad;
//import sarn.entidad.Guardaparque;
import sarn.entidad.Persona;

public abstract class AdminPersona extends AdminEntidad {

    @Override
    public Entidad editarEntidad(Entidad e) {
        Persona ps = (Persona) e;
        if (control.confirmar("Editar cedula? (s/n): ")) {
            ps.cedula = control.ingresoCedula("cedula", false);
        }
        if (control.confirmar("Editar nombres? (s/n): ")) {
            ps.nombres = control.ingresoNombres("nombres");
        }
        if (control.confirmar("Editar apellidos? (s/n): ")) {
            ps.apellidos = control.ingresoNombres("apellidos");
        }
        return ps;
    }

    public Boolean cedulaUnica(Entidad e, List<Entidad> personas) {
        Persona pActual = (Persona) e;
        for (Entidad entidad : personas) {
            Persona v = (Persona) entidad;
            if (pActual.cedula.equals(v.cedula)) {
                System.out.println("Cedula " + pActual.cedula + " ya esta registrada");
                return false;
            }
        }
        return true;
    }
}
