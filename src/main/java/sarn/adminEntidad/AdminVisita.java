package main.java.sarn.adminEntidad;
import java.time.LocalDateTime;
import java.util.List;
import main.java.sarn.entidad.*;

public class AdminVisita extends AdminEntidad {
    private static AdminVisita clase;
    private AdminVisita() {}

    public static AdminVisita getInstance() {
        if (clase == null) {
            clase = new AdminVisita();
            return clase;
        }
        return clase;
    }

    @Override
    public Entidad nuevaEntidad() {
        this.registro += 1;
        Entidad entidad = new Visita();
        entidad.id = this.registro;
        return entidad;
    }

    @Override
    public void llenarEntidad(Entidad entidad) {
        System.out.println("NUEVA VISITA");
        Visita v = (Visita) entidad;
        v.idVisitante = control.ingresoNumero("ID del visitante");
        v.fechaHoraEntrada = LocalDateTime.now();
    }

    @Override
    public void listarEntidades(List<Entidad> entidades) {
        System.out.println("\nTODAS LAS VISITAS");
        for (int i = 0; i < entidades.size(); i++) {
            Visita v = (Visita) entidades.get(i);
            v.toString();
            System.out.println();
        }
        System.out.println();
    }
    
}
