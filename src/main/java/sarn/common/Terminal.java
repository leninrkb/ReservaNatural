package main.java.sarn.common;
import main.java.sarn.adminEntidad.*;
import main.java.sarn.entidad.*;

public class Terminal {
    IOControl control = IOControl.getInstance();
    ReservaNatural reserva = ReservaNatural.getInstance();

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
