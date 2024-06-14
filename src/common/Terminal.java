package common;
import adminEntidad.AdminVisitante;
import adminEntidad.AdminGuardaparque;
import adminEntidad.AdminIncidencia;
import adminEntidad.AdminVisita;
import entidad.Guardaparque;
import entidad.Incidencia;
import entidad.Visita;
import entidad.Visitante;

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
                    admin.llenarEntidad(inc);
                    admin.registrarEntidad(reserva.incidencias, inc);
                break;

                case "atender":
                case "a":
                    // localizo inc por ID
                    // seteo la fecha de atencion
                    admin.atenderIncidencia(reserva.incidencias);
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
                    System.out.println("\nlistar / l");
                    System.out.println("registrar / r");
                    System.out.println("salir / x");
                    System.out.println("help / h\n");
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
                    admin.llenarEntidad(v);
                    admin.registrarEntidad(reserva.visitas, v);
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
                    System.out.println("generar reporte de visitantes");
                    System.out.println("generar reporte de incidencias");
                    break;

                case "salir":
                case "x":
                    salir = !salir;
                    break;

                case "help":
                case "h":
                    System.out.println("\nvisitantes / v");
                    System.out.println("visitas / vs");
                    System.out.println("guardaparques / g");
                    System.out.println("incidencias / i");
                    System.out.println("reportes / r");
                    System.out.println("salir / x");
                    System.out.println("help / h\n");
                    break;
                default:
                    break;
            }
        }
    }
}
