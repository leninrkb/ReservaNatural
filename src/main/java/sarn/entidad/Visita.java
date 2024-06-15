package sarn.entidad;
import java.time.LocalDateTime;

public class Visita extends Entidad {
    public Integer idVisitante;
    public LocalDateTime fechaHoraEntrada;
    public LocalDateTime fechaHoraSalida;

    public String getFechaHoraEntrada() {
        if (fechaHoraEntrada != null) {
            return fechaHoraEntrada.format(formatoFechaHora);
        }
        return "";
    }
    public String getFechaHoraSalida() {
        if (fechaHoraSalida != null) {
            return fechaHoraSalida.format(formatoFechaHora);
        }
        return "";
    }

    @Override
    public String toString() {
        System.out.println("" 
        + "ID Visita => " + id + "\n"
        + "ID Visitante => " + idVisitante + "\n"
        + "Fecha de Entrada => " + getFechaHoraEntrada() + "\n"
        + "Fecha de Salida => " + getFechaHoraSalida()
        );
        return super.toString();
    }
}
