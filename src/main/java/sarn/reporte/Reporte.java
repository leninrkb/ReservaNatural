package sarn.reporte;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import sarn.common.ReservaNatural;
import sarn.entidad.*;

public class Reporte {
    private static Reporte clase;
    public DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    private Reporte() {}

    public static Reporte getInstance() {
        if (clase == null){
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
        List<Entidad> visitas = reserva.visitas;
        LocalDateTime fecha = LocalDateTime.now();
        String fechaHoy = fecha.format(formatoFecha); //tengo el dia de hoy
        Integer totalVisitasHoy = 0;
        System.out.println("VISITANTES POR DIA");
        for (int i = 0; i < visitas.size(); i++) {
            Visita v = (Visita) visitas.get(i);
            String fechaVisita = v.fechaHoraEntrada.format(formatoFecha);
            if (fechaVisita.equals(fechaHoy)) {
                totalVisitasHoy += 1;
                v.toString();
                System.out.println();
            }
        }
        System.out.println("Hoy " + nombreDia(fecha) + " se registran => " + totalVisitasHoy + " visitas");
    }
}



// sabado
// total visitantes = 12
// visitante ID 2
// nombre 