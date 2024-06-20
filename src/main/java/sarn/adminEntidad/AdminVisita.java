package sarn.adminEntidad;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import sarn.common.*;
import sarn.entidad.*;

public class AdminVisita extends AdminEntidad {
    private static AdminVisita clase;

    private AdminVisita() {
    }

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
        System.out.println();
        System.out.println("NUEVA VISITA");
        Visita v = (Visita) entidad;
        Integer idVisitante = control.ingresoNumero("ID del visitante");
        Visitante vt = (Visitante) encontrarEntidad(reserva.visitantes, idVisitante);
        if (vt == null) {
            System.out.println("no se encontro el visitante con ID " + idVisitante);
            return false;
        }
        if (vt.enVisita) {
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
        System.out.println();
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
        Visita v = (Visita) e;

        System.out.println("Editando visita ID: " + v.id);

        if (control.confirmar("Editar fecha y hora de salida ? (s/n)")) {
            v.fechaHoraTermina = control.ingresoFechaHora("Ingrese nueva fecha y hora (formato: yyyy-MM-dd HH:mm)");
        }

        return v;
    }
    

    public boolean exportarDatos(String rutaArchivo, List<Entidad> visitas, List<Entidad> visitantes) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            // Escribir encabezados CSV
            writer.write("ID,Visitante,Fecha Ingreso,Fecha Salida\n");

            // Escribir datos de visitas
            for (Entidad entidad : visitas) {
                Visita v = (Visita) entidad;
                String nombreVisitante = obtenerNombreVisitante(v.idVisitante, visitantes);
                writer.write(String.format("%d,%s,%s,%s\n",
                        v.id, nombreVisitante, v.fechaHoraInicia, v.fechaHoraTermina));
            }

            return true;
        } catch (IOException e) {
            System.out.println("Error al exportar los datos de visitas como CSV: " + e.getMessage());
            return false;
        }
    }

    private String obtenerNombreVisitante(int visitanteId, List<Entidad> visitantes) {
        for (Entidad entidad : visitantes) {
            Visitante v = (Visitante) entidad;
            if (v.id == visitanteId) {
                return v.nombres;
            }
        }
        return "Desconocido";
    }

}
