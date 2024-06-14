package adminEntidad;
import java.time.LocalDateTime;
import java.util.List;
import entidad.Entidad;
import entidad.Incidencia;

public class AdminIncidencia extends AdminEntidad {
    private static AdminIncidencia clase;

    private AdminIncidencia() {}

    public void atenderIncidencia(List<Entidad> entidades) {
        Boolean atendida = false;
        Integer id = control.ingresoNumero("ID de la incidencia");
        for (int i = 0; i < entidades.size(); i++) {
            Incidencia inc = (Incidencia) entidades.get(i);
            if (inc.id == id) {
                inc.fechaHoraAtencion = LocalDateTime.now();
                inc.idGuardaparque = control.ingresoNumero("ID del guardaparque");
                System.out.println("Incidencia atendida");
                inc.toString();
                System.out.println();
                atendida = !atendida;
                break;
            }
        }
        if(!atendida) {
            System.out.println("No se encontro la incidencia");
        }
    }

    @Override
    public Entidad nuevaEntidad() {
        this.registro += 1;
        Entidad entidad = new Incidencia();
        entidad.id = this.registro;
        return entidad;
    }

    @Override
    public void llenarEntidad(Entidad entidad) {
        System.out.println("REPORTE DE NUEVA INCIDENCIA");
        Incidencia inc = (Incidencia) entidad;
        inc.idVisitante = control.ingresoNumero("ID del visitante que reporta");
        inc.fechaHoraReporte = LocalDateTime.now();
        inc.descripcion = control.ingresoTexto("Describa la incidencia");
        inc.anotaciones = control.ingresoTexto("Anotaciones que se requiera");
    }

    @Override
    public void listarEntidades(List<Entidad> entidades) {
        System.out.println("INCIDENCIAS REGISTRADAS");
        for (int i = 0; i < entidades.size(); i++) {
            Incidencia e = (Incidencia) entidades.get(i);
            e.toString();
            System.out.println();
        }
    }

    public static AdminIncidencia getInstance() {
        if(clase == null) {
            clase = new AdminIncidencia();
            return clase;
        }
        return clase;
    }
    
}
