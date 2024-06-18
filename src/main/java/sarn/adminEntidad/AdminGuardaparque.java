package sarn.adminEntidad;
import java.time.LocalDateTime;
import java.util.List;
import sarn.entidad.*;

public class AdminGuardaparque extends AdminEntidad {
    private static AdminGuardaparque clase;

    private AdminGuardaparque(){}
    
    @Override
    public Entidad nuevaEntidad() {
        this.registro += 1;
        Entidad entidad = new Guardaparque();
        entidad.id = this.registro;
        return entidad;
    }

    @Override
    public void llenarEntidad(Entidad entidad) {
        System.out.println("NUEVO GUARDAPARQUE");
        Guardaparque g = (Guardaparque) entidad;
        g.cedula = control.ingresoCedula("cedula", false);
        g.nombres = control.ingresoTexto("nombres");
        g.apellidos = control.ingresoTexto("apellidos");
        g.fechaContratacion = LocalDateTime.now();
    }

    @Override
    public void listarEntidades(List<Entidad> entidades) {
        System.out.println("LISTA DE GUARDAPARQUES");
        for (int i = 0; i < entidades.size(); i++) {
            Guardaparque g = (Guardaparque) entidades.get(i);
            g.toString();
            System.out.println();
        }
    }

    public static AdminGuardaparque getInstance() {
        if(clase == null) {
            clase = new AdminGuardaparque();
            return clase;
        }
        return clase;
    }
}
