package sarn.common;
import java.time.LocalDate;
import java.time.LocalDateTime;

import sarn.adminEntidad.*;
import sarn.entidad.*;
import sarn.reporte.Reporte;

public class Terminal {
    IOControl control = IOControl.getInstance();
    ReservaNatural reserva = ReservaNatural.getInstance();
    Reporte reporte = Reporte.getInstance();

    public void incidencias() {
        AdminIncidencia admin = AdminIncidencia.getInstance();
        Boolean salir = false;
        while(!salir) {
            String comando = control.ingresoTerminal("incidencias");
            switch(comando) {
                case "listar":
                case "l":
                    admin.listarEntidades(reserva.incidencias);
                break;

                case "registrar":
                case "r":
                    Incidencia inc = (Incidencia) admin.nuevaEntidad();
                    if (admin.llenarEntidad(reserva, inc)) {
                        admin.registrarEntidad(reserva.incidencias, inc);
                    }
                break;

                case "atender":
                case "a":
                    admin.atenderIncidencia(reserva);
                break;

                case "salir":
                case "x":
                    salir = !salir;
                break;

                case "help":
                case "h":
                    System.out.println("listar / l");
                    System.out.println("registrar / r");
                    System.out.println("atender / a");
                    System.out.println("salir / x");
                    System.out.println("help / h");
                break;
            }
        }
    }

    public void guardaparques() {
        AdminGuardaparque admin = AdminGuardaparque.getInstance();
        Boolean salir = false;
        while(!salir) {
            String comando = control.ingresoTerminal("guardaparques");
            switch(comando) {
                case "listar":
                case "l":
                    admin.listarEntidades(reserva.guardaparques);
                break;

                case "registrar":
                case "r":
                    Guardaparque g = (Guardaparque) admin.nuevaEntidad();
                    admin.llenarEntidad(g);
                    admin.registrarEntidad(reserva.guardaparques, g);
                break;

                case "salir":
                case "x":
                    salir = !salir;
                break;

                case "help":
                case "h":
                    System.out.println("listar / l");
                    System.out.println("registrar / r");
                    System.out.println("salir / x");
                    System.out.println("help / h");
                break;
            }
        }
    }

    public void visitantes() {
        AdminVisitante admin = AdminVisitante.getInstance();
        Boolean salir = false;
        while (!salir) {
            String comando = control.ingresoTerminal("visitantes");
            switch (comando) {
                case "listar":
                case "l":
                    admin.listarEntidades(reserva.visitantes);
                    break;

                case "registrar":
                case "r":
                    Visitante v = (Visitante) admin.nuevaEntidad();
                    admin.llenarEntidad(v);
                    admin.registrarEntidad(reserva.visitantes, v);
                    break;

                case "salir":
                case "x":
                    salir = !salir;
                    break;

                case "help":
                case "h":
                    System.out.println("listar / l");
                    System.out.println("registrar / r");
                    System.out.println("salir / x");
                    System.out.println("help / h");
                    break;
            }

        }
    }

    public void visitas() {
        AdminVisita admin = AdminVisita.getInstance();
        Boolean salir = false;
        while (!salir) {
            String comando = control.ingresoTerminal("visitas");
            switch (comando) {
                case "listar":
                case "l":
                    admin.listarEntidades(reserva.visitas);
                    break;

                case "registrar":
                case "r":
                    Visita v = (Visita) admin.nuevaEntidad();
                    if (admin.llenarEntidad(reserva, v)) {
                        admin.registrarEntidad(reserva.visitas, v);
                        System.out.println("Nueva visita registrada con exito!");
                    }
                    break;

                case "registrar salida":
                case "rs":
                    admin.registrarSalida(reserva);
                break;

                case "salir":
                case "x":
                    salir = !salir;
                    break;

                case "help":
                case "h":
                    System.out.println("listar / l");
                    System.out.println("registrar ingreso / r");
                    System.out.println("registrar salida / rs");
                    System.out.println("salir / x");
                    System.out.println("help / h");
                    break;
            }
        }
    }

    public void reportes() {
        Boolean salir = false;
        while(!salir) {
            String comando = control.ingresoTerminal("reportes");
            switch(comando) {
                case "visitas dia":
                case "vs d":
                    reporte.visitantesPorDia(reserva);
                break;

                case "visitas fecha":
                case "vs f":
                    String fecha = control.ingresoTexto("Fecha (yyyy-MM-dd)");
                    reporte.visitasPorFecha(reserva, fecha);
                break;

                case "visitas rango fecha":
                case "vs rf":
                    LocalDateTime fechaInicio = control.ingresoFechaHora("Fecha inicio (yyyy-MM-dd HH:mm)");
                    LocalDateTime fechaFin = control.ingresoFechaHora("Fecha fin (yyyy-MM-dd HH:mm)");
                    reporte.incidenciasRangoFecha(reserva.incidencias, fechaInicio, fechaFin);
                break;

                case "salir":
                case "x":
                    salir = !salir;
                break;

                case "help":
                case "h":
                    System.out.println("visitas dia / vs d");
                    System.out.println("visitas fecha / vs f");
                    System.out.println("visitas rangofecha / vs rf");
                    System.out.println("salir / x");
                    System.out.println("help / h");
                break;
            }
        }
    }

    public void inicio() {
    Boolean salir = false;
        while (!salir) {
            String comando = control.ingresoTerminal("");
            switch (comando) {
                case "visitantes":
                case "v":
                    visitantes();
                    break;

                case "visitas":
                case "vs":
                    visitas();
                    break;

                case "guardaparques":
                case "g":
                    guardaparques();
                    break;
                
                case "incidencias":
                case "i":
                    incidencias();
                break;

                case "reportes":
                case "r":
                    reportes();
                    break;

                case "salir":
                case "x":
                    salir = !salir;
                    break;

                case "help":
                case "h":
                    System.out.println("visitantes / v");
                    System.out.println("visitas / vs");
                    System.out.println("guardaparques / g");
                    System.out.println("incidencias / i");
                    System.out.println("reportes / r");
                    System.out.println("salir / x");
                    System.out.println("help / h");
                    break;
                default:
                    break;
            }
        }
    }
}
