package entidad;
import java.time.LocalDateTime;
import java.util.Date;

public class Visita extends Entidad {
    public Integer idVisitante;
    public LocalDateTime fechaHoraEntrada;
    public LocalDateTime fechaHoraSalida;

    public String getFechaHoraEntrada() {
        if (fechaHoraEntrada != null) {
            return fechaHoraEntrada.format(patronFecha);
        }
        return "";
    }
    public String getFechaHoraSalida() {
        if (fechaHoraSalida != null) {
            return fechaHoraSalida.format(patronFecha);
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
