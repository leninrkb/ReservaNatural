package sarn.reporte;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import sarn.common.ReservaNatural;
import sarn.entidad.Entidad;
import sarn.entidad.Visita;
import sarn.entidad.Visitante;

public class Reporte {
    private static Reporte clase;
    public DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd ");


    private Reporte() {}

    public static Reporte getInstance() {
        if (clase == null){
            clase = new Reporte();
            return clase;
        }
        return clase;
    }

    public void visitantesPorDia(ReservaNatural reserva) {
        List<Entidad> visitas = reserva.visitas;
        for (int i = 0; i < visitas.size(); i++) {
            Visita v = (Visita) visitas.get(i);
            v.toString();
            LocalDateTime fechaVisita = v.fechaHoraEntrada; 
            String diaDeLaSemana = fechaVisita.format(formatoFecha.withLocale(Locale.forLanguageTag("es")).withZone(ZoneId.systemDefault()));
            System.out.println("el dia de la visitas es el " + diaDeLaSemana);
        }
    }
}
