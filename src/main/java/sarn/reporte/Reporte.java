package sarn.reporte;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
//import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import sarn.adminEntidad.AdminVisita;
import sarn.common.ReservaNatural;
import sarn.entidad.*;

public class Reporte {
    private static Reporte clase;
    public DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private Reporte() {
    }

    public static Reporte getInstance() {
        if (clase == null) {
            clase = new Reporte();
            return clase;
        }
        return clase;
    }

    public String nombreDia(LocalDateTime fecha) {
        DayOfWeek dia = fecha.getDayOfWeek();
        String nombreDia = dia.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("es-ES"));
        return nombreDia;
    }

    public void visitantesPorDia(ReservaNatural reserva) {
        AdminVisita admin = AdminVisita.getInstance();
        List<Entidad> visitas = reserva.visitas;
        LocalDateTime fecha = LocalDateTime.now();
        String fechaHoy = fecha.format(formatoFecha); // tengo el dia de hoy
        Integer totalVisitasHoy = 0;
        System.out.println("VISITANTES POR DIA");
        for (int i = 0; i < visitas.size(); i++) {
            Visita v = (Visita) visitas.get(i);
            String fechaVisita = v.fechaHoraInicia.format(formatoFecha);
            if (fechaVisita.equals(fechaHoy)) {
                Integer idVisitante = v.idVisitante;
                Visitante vt = (Visitante) admin.encontrarEntidad(reserva.visitantes, idVisitante);
                if (vt == null) {
                    continue;
                }
                totalVisitasHoy += 1;
                vt.toString();
                System.out.println();
            }
        }
        System.out.println("Hoy " + nombreDia(fecha) + " se registran => " + totalVisitasHoy + " visitas");
    }

    public void visitasPorFecha(ReservaNatural reserva, String fecha) {
        AdminVisita admin = AdminVisita.getInstance();
        List<Entidad> visitas = reserva.visitas;
        Integer totalVisitasFecha = 0;
        Integer totalIncidencias = 0;
        System.out.println("VISITAS POR FECHA: " + fecha);
        for (Entidad entidad : visitas) {
            Visita visita = (Visita) entidad;
            String fechaVisita = visita.fechaHoraInicia.format(formatoFecha);
            if (fechaVisita.equals(fecha)) {
                Integer idVisitante = visita.idVisitante;
                Visitante visitante = (Visitante) admin.encontrarEntidad(reserva.visitantes, idVisitante);
                if (visitante == null) {
                    continue;
                }
                totalVisitasFecha += 1;
                Integer totalIncVisitante = totalIncidenciasVisitante(reserva.incidencias, idVisitante);
                totalIncidencias += totalIncVisitante;
                visitante.toString();
                if (visita.fechaHoraTermina == null) {
                    System.out
                            .println("El visitante " + visitante.nombres + " no ha registrado la salida de la reserva");
                }
                System.out.println(visitante.nombres + " ha registrado " + totalIncVisitante + " incidencias");
                System.out.println();
            }
        }
        System.out.println("En la fecha " + fecha + " se registran:\n"
                + totalVisitasFecha + " visitas" + "\n"
                + totalIncidencias + " incidencias reportadas");
    }

    public Integer totalIncidenciasVisitante(List<Entidad> entidades, Integer id) {
        Integer total = 0;
        for (int i = 0; i < entidades.size(); i++) {
            Incidencia inc = (Incidencia) entidades.get(i);
            if (inc.idVisitante == id) {
                total += 1;
            }
        }
        return total;
    }

    public void incidenciasRangoFecha(List<Entidad> entidades, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        Integer total = 0;
        for (Entidad entidad : entidades) {
            Incidencia inc = (Incidencia) entidad;
            if (inc.fechaHoraTermina == null) {
                continue;
            }
            Boolean q1 = inc.fechaHoraTermina.isAfter(fechaInicio);
            Boolean q2 = inc.fechaHoraTermina.isBefore(fechaFin);
            if (q1 && q2) {
                inc.toString();
                System.out.println();
                total += 1;
            }
        }
        System.out.println("Hay " + total + " incidencias atendidas");
    }
}
