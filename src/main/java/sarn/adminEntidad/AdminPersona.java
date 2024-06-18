package sarn.adminEntidad;
import java.util.List;
import sarn.entidad.Entidad;
import sarn.entidad.Persona;

public abstract class AdminPersona extends AdminEntidad{

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
