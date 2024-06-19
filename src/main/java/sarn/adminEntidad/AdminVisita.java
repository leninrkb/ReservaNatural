package sarn.adminEntidad;
import java.time.LocalDateTime;
import java.util.List;

import sarn.common.*;
import sarn.entidad.*;

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

    public Boolean llenarEntidad(ReservaNatural reserva, Entidad entidad) {
        System.out.println("NUEVA VISITA");
        Visita v = (Visita) entidad;
        Integer idVisitante = control.ingresoNumero("ID del visitante");
        Visitante vt = (Visitante) encontrarEntidad(reserva.visitantes, idVisitante);
        if (vt == null) {
            System.out.println("no se encontro el visitante con ID " + idVisitante);
            return false;
        }
        if(vt.enVisita){
            System.out.println("El visitante " + vt.nombres + "ya se encuentra dentro de la Reserva");
            return false;
        }
        vt.cambioEstadoVisita();
        v.idVisitante = idVisitante;
        v.fechaHoraInicia = LocalDateTime.now();
        return true;
    }

    @Override
    public void listarEntidades(List<Entidad> entidades) {
        System.out.println("TODAS LAS VISITAS REGISTRADAS");
        for (int i = 0; i < entidades.size(); i++) {
            Visita v = (Visita) entidades.get(i);
            v.toString();
            System.out.println();
        }
    }

    @Override
    public void llenarEntidad(Entidad entidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'llenarEntidad'");
    }

    public void registrarSalida(ReservaNatural reserva) {
        Integer idVisita = control.ingresoNumero("ID de la visita");
        Visita v = (Visita) encontrarEntidad(reserva.visitas, idVisita);
        if (v == null) {
            System.out.println("No se encontro la visita con ID " + idVisita);
            return;
        }
        Visitante vt = (Visitante) encontrarEntidad(reserva.visitantes, v.idVisitante);
        vt.cambioEstadoVisita();
        v.fechaHoraTermina = LocalDateTime.now();
        System.out.println("Salida registrada con exito!");
    }

    @Override
    public Entidad editarEntidad(Entidad e) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
