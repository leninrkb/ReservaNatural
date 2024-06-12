import entidad.Entidad;
import entidad.Visitante;

public class AdminVisitante extends AdminEntidad {

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
        System.out.println();
        v.cedula = this.control.ingresoCedula("ingrese su cedula");
        v.nombres = this.control.ingresoTexto("ingrese sus nombres");
        v.apellidos = this.control.ingresoTexto("ingrese sus apellidos");
        v.ruc = String.valueOf(this.control.ingresoNumero("ingrese su ruc"));
        v.direccion = this.control.ingresoTexto("ingrese su direccion");
        v.telefono = String.valueOf(this.control.ingresoNumero("ingrese su telefono"));
    }
}
