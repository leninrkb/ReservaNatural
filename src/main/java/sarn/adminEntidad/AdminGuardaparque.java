package sarn.adminEntidad;
import java.time.LocalDateTime;
import java.util.List;
import sarn.entidad.*;

public class AdminGuardaparque extends AdminPersona {
    private static AdminGuardaparque clase;

    private AdminGuardaparque(){}
    
    @Override
    public Entidad nuevaEntidad() {
        this.registro += 1;
        Entidad entidad = new Guardaparque();
        entidad.id = this.registro;
        return entidad;
    }

    public void llenarEntidad(Entidad e, List<Entidad> entidades){
        System.out.println();
        System.out.println("NUEVO GUARDAPARQUE");
        Guardaparque gd = (Guardaparque) e;
        while(true){
            gd.cedula = this.control.ingresoCedula("ingrese su cedula", false);
            if(cedulaUnica(gd, entidades)){
                break;
            }
        }
        llenarEntidad(e);
    }

    @Override
    public void llenarEntidad(Entidad entidad) {
        Guardaparque g = (Guardaparque) entidad;
        g.nombres = control.ingresoNombres("nombres");
        g.apellidos = control.ingresoNombres("apellidos");
        g.fechaContratacion = LocalDateTime.now();
    }

    @Override
    public void listarEntidades(List<Entidad> entidades) {
        System.out.println();
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
