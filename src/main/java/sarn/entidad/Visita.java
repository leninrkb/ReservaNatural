package sarn.entidad;

import java.time.LocalDateTime;
import sarn.common.FormatoFecha;

public class Visita extends Entidad {
    public Integer idVisitante;
    public LocalDateTime fechaHoraInicia;
    public LocalDateTime fechaHoraTermina;

    public String getFechaHoraInicia() {
        if (fechaHoraInicia != null) {
            return fechaHoraInicia.format(FormatoFecha.formatoFechaHora);
        }
        return "";
    }

    public String getFechaHoraTermina() {
        if (fechaHoraTermina != null) {
            return fechaHoraTermina.format(FormatoFecha.formatoFechaHora);
        }
        return "";
    }

    @Override
    public String toString() {
        System.out.println(""
                + "ID Visita => " + id + "\n"
                + "ID Visitante => " + idVisitante + "\n"
                + "Fecha de Entrada => " + getFechaHoraInicia() + "\n"
                + "Fecha de Salida => " + getFechaHoraTermina());
        return "";
    }
}
