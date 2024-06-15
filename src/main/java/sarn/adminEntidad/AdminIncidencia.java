package main.java.sarn.adminEntidad;
import java.time.LocalDateTime;
import java.util.List;
import main.java.sarn.common.*;
import main.java.sarn.entidad.*;

public class AdminIncidencia extends AdminEntidad {
    private static AdminIncidencia clase;

    private AdminIncidencia() {}

    public void atenderIncidencia(ReservaNatural reserva) {
        Integer idIncidencia = control.ingresoNumero("ID de la incidencia");
        Incidencia inc = (Incidencia) validarEntidad(reserva.incidencias, idIncidencia);
        if (inc == null) {
            System.out.println("No existe la incidencia " + idIncidencia);
            return;
        }
        Integer idGuardaparque = control.ingresoNumero("ID del guardaparque");
        Guardaparque g = (Guardaparque) validarEntidad(reserva.guardaparques, idGuardaparque);
        if (g == null) {
            System.out.println("No existe el guardaparque " + idGuardaparque);
            return;
        }
        inc.idGuardaparque = idGuardaparque;
        inc.fechaHoraAtencion = LocalDateTime.now();
        System.out.println("Incidencia atendida con exito!");
    }

    @Override
    public Entidad nuevaEntidad() {
        this.registro += 1;
        Entidad entidad = new Incidencia();
        entidad.id = this.registro;
        return entidad;
    }

    public void llenarEntidad(ReservaNatural reserva, Entidad entidad) {
        System.out.println("REPORTE DE NUEVA INCIDENCIA");
        Incidencia inc = (Incidencia) entidad;
        Integer idVisitante = control.ingresoNumero("ID del visitante que reporta");
        Visitante v = (Visitante) validarEntidad(reserva.visitantes, idVisitante);
        if(v == null) {
            System.out.println("no se encontro el visitante " + idVisitante);
            return;
        }
        inc.idVisitante = idVisitante;
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

    @Override
    public void llenarEntidad(Entidad entidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'llenarEntidad'");
    }
    
}
