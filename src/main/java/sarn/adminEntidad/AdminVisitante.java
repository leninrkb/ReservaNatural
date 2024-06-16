package sarn.adminEntidad;
import java.util.List;
import sarn.entidad.*;

public class AdminVisitante extends AdminEntidad {
    private static AdminVisitante clase;
    private AdminVisitante() {}

    public static AdminVisitante getInstance() {
        if (clase == null) {
            clase = new AdminVisitante();
            return clase;
        }
        return clase;
    }

    @Override
    public Entidad nuevaEntidad() {
        this.registro += 1;
        Entidad entidad = new Visitante();
        entidad.id = this.registro;
        return entidad;
    }

    @Override
    public void llenarEntidad(Entidad e) {
        Visitante v = (Visitante) e;
        System.out.println("[NUEVO VISITANTE]");
        Boolean opcional = true;
        v.cedula = this.control.ingresoCedula("ingrese su cedula", opcional);
        if(v.cedula == null) {
            opcional = !opcional;
        }
        v.ruc = String.valueOf(this.control.ingresoNumero("ingrese su ruc", opcional));
        v.nombres = this.control.ingresoTexto("ingrese sus nombres");
        v.apellidos = this.control.ingresoTexto("ingrese sus apellidos");
        v.direccion = this.control.ingresoTexto("ingrese su direccion");
        v.telefono = String.valueOf(this.control.ingresoNumero("ingrese su telefono"));
    }

    @Override
    public void listarEntidades(List<Entidad> entidades) {
        System.out.println("VISITANTES REGISTRADOS");
        for (int i = 0; i < entidades.size(); i += 1 ) {
            Visitante v = (Visitante) entidades.get(i);
            v.toString();
            System.out.println();
        }
    }


}
