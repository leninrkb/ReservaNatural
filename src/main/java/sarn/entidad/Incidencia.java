package sarn.entidad;
import java.time.LocalDateTime;

public class Incidencia extends Entidad {
    public Integer idGuardaparque;
    public Integer idVisitante;
    public String descripcion;
    public LocalDateTime fechaHoraReporte;
    public LocalDateTime fechaHoraAtencion;
    public String anotaciones;

    public String getFechaHoraReporte() {
        if(fechaHoraReporte != null) {
            return fechaHoraReporte.format(formatoFechaHora);
        }
        return "";
    }

    public String getFechaHoraAtencion() {
        if(fechaHoraAtencion != null) {
            return fechaHoraAtencion.format(formatoFechaHora);
        }
        return "";
    }

    @Override
    public String toString() {
        System.out.println(""
        + "ID                => " + id + "\n"
        + "ID Guardaparque   => " + idGuardaparque + "\n"
        + "ID Visitante      => " + idVisitante + "\n"
        + "Descripcion       => " + descripcion + "\n"
        + "Fecha del reporte => " + getFechaHoraReporte() + "\n"
        + "Fecha de atencion => " + getFechaHoraAtencion() + "\n"
        + "Anotaciones       => " + anotaciones
        );
        return super.toString();
    }
}
