package sarn.adminEntidad;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import sarn.common.*;
import sarn.entidad.*;

public class AdminIncidencia extends AdminEntidad {
    private static AdminIncidencia clase;

    private AdminIncidencia() {
    }

    public void atenderIncidencia(ReservaNatural reserva) {
        Integer idIncidencia = control.ingresoNumero("ID de la incidencia");
        Incidencia inc = (Incidencia) encontrarEntidad(reserva.incidencias, idIncidencia);
        if (inc == null) {
            System.out.println("No existe la incidencia " + idIncidencia);
            return;
        }
        Integer idGuardaparque = control.ingresoNumero("ID del guardaparque");
        Guardaparque g = (Guardaparque) encontrarEntidad(reserva.guardaparques, idGuardaparque);
        if (g == null) {
            System.out.println("No existe el guardaparque " + idGuardaparque);
            return;
        }
        inc.idGuardaparque = idGuardaparque;
        inc.fechaHoraTermina = LocalDateTime.now();
        System.out.println("Incidencia atendida con exito!");
    }

    @Override
    public Entidad nuevaEntidad() {
        this.registro += 1;
        Entidad entidad = new Incidencia();
        entidad.id = this.registro;
        return entidad;
    }

    public Boolean llenarEntidad(ReservaNatural reserva, Entidad entidad) {
        System.out.println();
        System.out.println("REPORTE DE NUEVA INCIDENCIA");
        Incidencia inc = (Incidencia) entidad;
        Integer idVisitante = control.ingresoNumero("ID del visitante que reporta");
        Visitante v = (Visitante) encontrarEntidad(reserva.visitantes, idVisitante);
        if (v == null) {
            System.out.println("no se encontro el visitante " + idVisitante);
            return false;
        }
        inc.idVisitante = idVisitante;
        inc.fechaHoraInicia = LocalDateTime.now();
        inc.descripcion = control.ingresoTexto("Describa la incidencia");
        inc.anotaciones = control.ingresoTexto("Anotaciones que se requiera");
        return true;
    }

    @Override
    public void listarEntidades(List<Entidad> entidades) {
        System.out.println();
        System.out.println("INCIDENCIAS REGISTRADAS");
        for (int i = 0; i < entidades.size(); i++) {
            Incidencia e = (Incidencia) entidades.get(i);
            e.toString();
            System.out.println();
        }
    }

    public static AdminIncidencia getInstance() {
        if (clase == null) {
            clase = new AdminIncidencia();
            return clase;
        }
        return clase;
    }

    @Override
    public void llenarEntidad(Entidad entidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'llenarEntidad'");
    }

    @Override
    public Entidad editarEntidad(Entidad e) {
        Incidencia inc = (Incidencia) e;

        System.out.println("Editando incidencia ID: " + inc.id);

        if (control.confirmar("Editar fecha y hora de la atencion? (s/n)")) {
            inc.fechaHoraTermina = control.ingresoFechaHora("Ingrese nueva fecha y hora (formato: yyyy-MM-dd HH:mm)");
        }

        if (control.confirmar("Editar descripción? (s/n)")) {
            inc.descripcion = control.ingresoTexto("Nueva descripción");
        }

        if (control.confirmar("Agregar anotaciones? (s/n)")) {
            inc.anotaciones = control.ingresoTexto("Nuevas anotaciones");
        }

        return inc;
    }

    public boolean exportarDatos(String rutaArchivo, List<Entidad> incidencias, List<Entidad> visitantes,
            List<Entidad> guardaparques) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            // Escribir encabezados CSV
            writer.write("ID,Visitante,Guardaparque,Fecha Inicio, Fecha Fim,Descripcion,Anotaciones\n");

            // Escribir datos de incidencias
            for (Entidad entidad : incidencias) {
                Incidencia i = (Incidencia) entidad;
                String nombreVisitante = obtenerNombreVisitante(i.idVisitante, visitantes);
                String nombreGuardaparque = obtenerNombreGuardaparque(i.idGuardaparque, guardaparques);
                writer.write(String.format("%d,%s,%s,%s,%s,%s,%s\n",
                        i.id, nombreVisitante, nombreGuardaparque, i.fechaHoraInicia, i.fechaHoraTermina, i.descripcion, i.anotaciones));
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error al exportar los datos de incidencias como CSV: " + e.getMessage());
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

    private String obtenerNombreGuardaparque(int guardaparqueId, List<Entidad> guardaparques) {
        for (Entidad entidad : guardaparques) {
            Guardaparque g = (Guardaparque) entidad;
            if (g.id == guardaparqueId) {
                return g.nombres;
            }
        }
        return "Desconocido";
    }

}
