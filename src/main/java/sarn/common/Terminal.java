package sarn.common;

import java.time.LocalDateTime;
import sarn.adminEntidad.*;
import sarn.entidad.*;
import sarn.persistencia.Persistencia;
import sarn.reporte.Reporte;

public class Terminal {
    IOControl control = IOControl.getInstance();
    ReservaNatural reserva = ReservaNatural.getInstance();
    Reporte reporte = Reporte.getInstance();
    Persistencia persistencia = Persistencia.getInstance();

    public void incidencias() {
        AdminIncidencia admin = AdminIncidencia.getInstance();
        control.cargarRegistroAdmin(admin, reserva.incidencias);
        Boolean salir = false;
        boolean mostrarMenu = true;

        while (!salir) {
            if (mostrarMenu) {
                System.out.println("\n======================= GESTIÓN DE INCIDENCIAS ===============");
                System.out.println("1. Listar Incidencias                                     ");
                System.out.println("2. Registrar nueva Incidencia                             ");
                System.out.println("3. Atender Incidencia                                     ");
                System.out.println("4. Salir                                                  ");
                System.out.println("5. Mostrar ayuda                                          ");
                System.out.println("6. Eliminar Incidencia                                    ");
                System.out.println("7. Editar Incidencia                                      ");
                System.out.println("================================================================\n");
            }

            String comando = control.ingresoTerminal("incidencias");
            switch (comando) {
                case "listar":
                case "l":
                case "1":
                    admin.listarEntidades(reserva.incidencias);
                    mostrarMenu = false;
                    break;

                case "registrar":
                case "r":
                case "2":
                    Incidencia inc = (Incidencia) admin.nuevaEntidad();
                    if (admin.llenarEntidad(reserva, inc)) {
                        admin.registrarEntidad(reserva.incidencias, inc);
                    }
                    mostrarMenu = false;
                    break;

                case "atender":
                case "a":
                case "3":
                    admin.atenderIncidencia(reserva);
                    mostrarMenu = false;
                    break;

                case "salir":
                case "x":
                case "4":
                    salir = !salir;
                    break;

                case "help":
                case "h":
                case "5":
                    System.out.println("\n======= AYUDA =======================");
                    System.out.println("1. l       - Listar incidencias");
                    System.out.println("2. r       - Registrar nueva incidencia");
                    System.out.println("3. a       - Atender incidencia");
                    System.out.println("4. x       - Salir");
                    System.out.println("5. h       - Mostrar ayuda");
                    System.out.println("6. el      - Eliminar incidencia");
                    System.out.println("7. ed      - Editar incidencia");
                    System.out.println("=======================================\n");
                    mostrarMenu = false;
                    break;

                case "eliminar":
                case "el":
                case "6":
                    Boolean eliminado = admin.eliminarEntidad(control.ingresoNumero("ID de la incidencia a eliminar"),
                            reserva.incidencias);
                    if (eliminado) {
                        System.out.println("Operacion realizada con exito!");
                    }else{
                        System.out.println("No se realizo la accion!");
                    }
                    mostrarMenu = false;
                    break;

                case "editar":
                case "ed":
                case "7":
                    int idIncidencia = control.ingresoNumero("ID de la incidencia");
                    Entidad entidadEditada = admin
                            .editarEntidad(admin.encontrarEntidad(reserva.incidencias, idIncidencia));
                    if (entidadEditada != null) {
                        System.out.println("Incidencia editada correctamente.");
                    } else {
                        System.out.println("No se pudo editar la incidencia.");
                    }
                    mostrarMenu = false;
                    break;
            }
        }
    }

    public void guardaparques() {
        AdminGuardaparque admin = AdminGuardaparque.getInstance();
        control.cargarRegistroAdmin(admin, reserva.guardaparques);
        Boolean salir = false;
        boolean mostrarMenu = true;

        while (!salir) {
            if (mostrarMenu) {
                System.out.println("\n===================== GESTIÓN DE GUARDAPARQUES ================");
                System.out.println("1. Listar Guardaparques                                    ");
                System.out.println("2. Registrar nuevo Guardaparque                            ");
                System.out.println("3. Salir                                                   ");
                System.out.println("4. Mostrar ayuda                                           ");
                System.out.println("5. Eliminar Guardaparque                                   ");
                System.out.println("6. Editar Guardaparque                                     ");
                System.out.println("=================================================================\n");
            }

            String comando = control.ingresoTerminal("guardaparques");
            switch (comando) {
                case "listar":
                case "l":
                case "1":
                    admin.listarEntidades(reserva.guardaparques);
                    mostrarMenu = false;
                    break;

                case "registrar":
                case "r":
                case "2":
                    Entidad e = admin.nuevaEntidad();
                    admin.llenarEntidad(e, reserva.guardaparques, reserva.visitantes);
                    admin.registrarEntidad(reserva.guardaparques, e);
                    mostrarMenu = false;
                    break;

                case "salir":
                case "x":
                case "3":
                    salir = !salir;
                    break;

                case "help":
                case "h":
                case "4":
                    System.out.println("\n======= AYUDA ========================");
                    System.out.println("1. l       - Listar guardaparques");
                    System.out.println("2. r       - Registrar nuevo guardaparque");
                    System.out.println("3. x       - Salir");
                    System.out.println("4. h       - Mostrar ayuda");
                    System.out.println("5. el      - Eliminar guardaparque");
                    System.out.println("6. ed      - Editar guardaparque");
                    System.out.println("======================================\n");
                    mostrarMenu = false;
                    break;

                case "eliminar":
                case "el":
                case "5":
                    Boolean eliminado = admin.eliminarEntidad(control.ingresoNumero("ID del guardaparque a eliminar"),
                            reserva.guardaparques);
                    if (eliminado) {
                        System.out.println("Operacion realizada con exito!");
                    }
                    mostrarMenu = false;
                    break;

                case "editar":
                case "ed":
                case "6":
                    admin.editarEntidad(reserva.guardaparques, control.ingresoNumero("ID del guardaparque"));
                    mostrarMenu = false;
                    break;

            }
        }
    }

    public void visitantes() {
        AdminVisitante admin = AdminVisitante.getInstance();
        control.cargarRegistroAdmin(admin, reserva.visitantes);
        Boolean salir = false;
        boolean mostrarMenu = true;
        while (!salir) {
            if (mostrarMenu) {
                System.out.println("\n====================== GESTIÓN DE VISITANTES =================");
                System.out.println("1. Listar Visitantes                                      ");
                System.out.println("2. Registrar nuevo Visitante                              ");
                System.out.println("3. Salir                                                  ");
                System.out.println("4. Mostrar ayuda                                          ");
                System.out.println("5. Eliminar Visitante                                     ");
                System.out.println("6. Editar Visitante                                       ");
                System.out.println("================================================================\n");
            }

            String comando = control.ingresoTerminal("visitantes");
            switch (comando) {
                case "listar":
                case "l":
                case "1":
                    admin.listarEntidades(reserva.visitantes);
                    mostrarMenu = false;
                    System.out.println();
                    break;

                case "registrar":
                case "r":
                case "2":
                    Entidad e = admin.nuevaEntidad();
                    admin.llenarEntidad(e, reserva.visitantes, reserva.guardaparques);
                    admin.registrarEntidad(reserva.visitantes, e);
                    mostrarMenu = false;
                    System.out.println();
                    break;

                case "salir":
                case "x":
                case "3":
                    salir = !salir;
                    break;

                case "help":
                case "h":
                case "4":
                    System.out.println("\n======= AYUDA ======================");
                    System.out.println("1. l       - Listar visitantes");
                    System.out.println("2. r       - Registrar nuevo visitante");
                    System.out.println("3. x       - Salir");
                    System.out.println("4. h       - Mostrar ayuda");
                    System.out.println("5. el      - Eliminar visitante");
                    System.out.println("6. ed      - Editar visitante");
                    System.out.println("======================================\n");
                    mostrarMenu = false;
                    break;

                case "eliminar":
                case "el":
                case "5":
                    Boolean eliminado = admin.eliminarEntidad(control.ingresoNumero("ID del visitante a liminar"),
                            reserva.visitantes);
                    if (eliminado) {
                        System.out.println("Operacion realizada con exito!");
                    }
                    mostrarMenu = false;
                    break;

                case "editar":
                case "ed":
                case "6":
                    admin.editarEntidad(reserva.visitantes, control.ingresoNumero("ID del visitante"));
                    mostrarMenu = false;
                    break;

            }

        }
    }

    public void visitas() {
        AdminVisita admin = AdminVisita.getInstance();
        control.cargarRegistroAdmin(admin, reserva.visitas);
        Boolean salir = false;
        boolean mostrarMenu = true;

        while (!salir) {
            if (mostrarMenu) {
                System.out.println("\n========================= GESTIÓN DE VISITAS =================");
                System.out.println("1. Listar Visitas                                         ");
                System.out.println("2. Registrar nueva Visita                                 ");
                System.out.println("3. Registrar salida de Visita                             ");
                System.out.println("4. Salir                                                  ");
                System.out.println("5. Mostrar ayuda                                          ");
                System.out.println("6. Eliminar Visita                                        ");
                System.out.println("7. Editar Visita                                          ");
                System.out.println("================================================================\n");

            }

            String comando = control.ingresoTerminal("visitas");
            switch (comando) {
                case "listar":
                case "l":
                case "1":
                    admin.listarEntidades(reserva.visitas);
                    mostrarMenu = false;
                    System.out.println();
                    break;

                case "registrar":
                case "r":
                case "2":
                    Visita v = (Visita) admin.nuevaEntidad();
                    if (admin.llenarEntidad(reserva, v)) {
                        admin.registrarEntidad(reserva.visitas, v);
                        System.out.println("Nueva visita registrada con éxito!");
                    }
                    mostrarMenu = false;
                    System.out.println();
                    break;

                case "registrar salida":
                case "rs":
                case "3":
                    admin.registrarSalida(reserva);
                    mostrarMenu = false;
                    System.out.println();
                    break;

                case "salir":
                case "x":
                case "4":
                    salir = !salir;
                    break;

                case "help":
                case "h":
                case "5":
                    System.out.println("\n======= AYUDA ============================");
                    System.out.println("1. l            - Listar visitas");
                    System.out.println("2. r            - Registrar nueva visita");
                    System.out.println("3. rs           - Registrar salida de visita");
                    System.out.println("4. x            - Salir");
                    System.out.println("5. h            - Mostrar ayuda");
                    System.out.println("6. el           - Eliminar visita");
                    System.out.println("7. ed           - Editar visita");
                    System.out.println("=============================================\n");
                    mostrarMenu = false;
                    break;

                case "eliminar":
                case "el":
                case "6":
                    Boolean eliminado = admin.eliminarEntidad(control.ingresoNumero("ID de la visita a eliminar"),
                            reserva.visitas);
                    if (eliminado) {
                        System.out.println("Operacion realizada con exito!");
                    }else{
                        System.out.println("No se realizo la operacion");
                    }
                    mostrarMenu = false;
                    break;

                case "editar":
                case "ed":
                case "7":
                    Integer idVisita = control.ingresoNumero("ID de la visita a editar");
                    Visita visita = (Visita) admin.encontrarEntidad(reserva.visitas, idVisita);
                    if (visita != null) {
                        admin.editarEntidad(visita);
                        System.out.println("Visita editada con éxito!");
                    } else {
                        System.out.println("No se encontró la visita con ID " + idVisita);
                    }
                    mostrarMenu = false;
                    break;

            }
        }
    }

    public void reportes() {
        Boolean salir = false;
        boolean mostrarMenu = true;

        while (!salir) {
            if (mostrarMenu) {
                System.out.println("\n======================== GENERACIÓN DE REPORTES ==================");
                System.out.println("1. Reporte de visitantes por día                          ");
                System.out.println("2. Reporte de visitas por fecha                           ");
                System.out.println("3. Reporte de incidencias por rango de fechas             ");
                System.out.println("4. Salir                                                  ");
                System.out.println("5. Mostrar ayuda                                          ");
                System.out.println("====================================================================\n");
            }

            String comando = control.ingresoTerminal("reportes");
            switch (comando) {
                case "visitas dia":
                case "vs d":
                case "1":
                    reporte.visitantesPorDia(reserva);
                    mostrarMenu = false;
                    System.out.println();
                    break;

                case "visitas fecha":
                case "vs f":
                case "2":
                    String fecha = control.ingresoTexto("Fecha (yyyy-MM-dd)");
                    reporte.visitasPorFecha(reserva, fecha);
                    mostrarMenu = false;
                    System.out.println();
                    break;

                case "visitas rango fecha":
                case "vs rf":
                case "3":
                    LocalDateTime fechaInicio = control.ingresoFechaHora("Fecha inicio (yyyy-MM-dd HH:mm)");
                    LocalDateTime fechaFin = control.ingresoFechaHora("Fecha fin (yyyy-MM-dd HH:mm)");
                    reporte.incidenciasRangoFecha(reserva.incidencias, fechaInicio, fechaFin);
                    mostrarMenu = false;
                    System.out.println();
                    break;

                case "salir":
                case "x":
                case "4":
                    salir = !salir;
                    break;

                case "help":
                case "h":
                case "5":
                    System.out.println("\n======= AYUDA ============================================");
                    System.out.println("1. vs d         - Reporte de visitantes por día");
                    System.out.println("2. vs f         - Reporte de visitas por fecha");
                    System.out.println("3. vs rf        - Reporte de incidencias por rango de fechas");
                    System.out.println("4. x            - Salir");
                    System.out.println("5. h            - Mostrar ayuda");
                    System.out.println("==========================================================\n");
                    mostrarMenu = false;
                    break;
            }
        }
    }

    public void inicio() {
        Boolean salir = false;
        Boolean mostrarMenu = true;
        Boolean cargarRegistro = persistencia.cargarEstado(reserva);
        AdminVisita adminVisita = AdminVisita.getInstance();
        adminVisita.cargarRegistro = cargarRegistro;
        AdminVisitante adminVisitante = AdminVisitante.getInstance();
        adminVisitante.cargarRegistro = cargarRegistro;
        AdminGuardaparque adminGuardaparque = AdminGuardaparque.getInstance();
        adminGuardaparque.cargarRegistro = cargarRegistro;
        AdminIncidencia adminIncidencia = AdminIncidencia.getInstance();
        adminIncidencia.cargarRegistro = cargarRegistro;
        reserva = ReservaNatural.getInstance();
        while (!salir) {
            if (mostrarMenu) {
                System.out.println("\n====================== MENÚ PRINCIPAL =================");
                System.out.println("1. Administrar visitantes                         ");
                System.out.println("2. Administrar visitas                            ");
                System.out.println("3. Administrar guardaparques                      ");
                System.out.println("4. Administrar incidencias                        ");
                System.out.println("5. Generar reportes                               ");
                System.out.println("6. Salir                                          ");
                System.out.println("7. Mostrar ayuda                                  ");
                System.out.println("8. Exportar Datos                                 ");
                System.out.println("=======================================================\n");
            }

            String comando = control.ingresoTerminal("");
            switch (comando) {
                case "visitantes":
                case "v":
                case "1":
                    visitantes();
                    break;

                case "visitas":
                case "vs":
                case "2":
                    visitas();
                    break;

                case "guardaparques":
                case "g":
                case "3":
                    guardaparques();
                    break;

                case "incidencias":
                case "i":
                case "4":
                    incidencias();
                    break;

                case "reportes":
                case "r":
                case "5":
                    reportes();
                    break;

                case "salir":
                case "x":
                case "6":
                    salir = control.confirmacionSalida("¿Está seguro que desea salir del programa? (s/n) ");
                    if (salir) {
                        persistencia.guardarEstado(reserva);
                        System.out.println("Saliendo del programa... ¡Hasta luego!");
                    }
                    break;

                case "help":
                case "h":
                case "7":
                    System.out.println("\n======= AYUDA =============");
                    System.out.println("1. v          - visitantes");
                    System.out.println("2. vs         - visitas");
                    System.out.println("3. g          - guardaparques");
                    System.out.println("4. i          - incidencias");
                    System.out.println("5. r          - reportes");
                    System.out.println("6. x          - salir");
                    System.out.println("7. h          - help");
                    System.out.println("8. ex         - exportar");
                    System.out.println("=============================\n");
                    mostrarMenu = false;
                    break;

                case "exportar":
                case "ex":
                case "8":
                    exportarDatos();
                    break;

            }

        }

    }

    public void exportarDatos() {
        Boolean salir = false;
        Boolean mostrarMenu = true;

        while (!salir) {
            if (mostrarMenu) {
                System.out.println("\n=========== EXPORTAR DATOS ===========");
                System.out.println("1. Exportar Visitantes");
                System.out.println("2. Exportar Guardaparques");
                System.out.println("3. Exportar Incidencias");
                System.out.println("4. Exportar Visitas");
                System.out.println("5. Volver al Menú Principal");
                System.out.println("=======================================");
            }

            String opcion = control.ingresoTerminal("exportar datos");
            switch (opcion) {
                case "1":
                    exportarVisitantes();
                    mostrarMenu = false;
                    break;
                case "2":
                    exportarGuardaparques();
                    mostrarMenu = false;
                    break;
                case "3":
                    exportarIncidencias();
                    mostrarMenu = false;
                    break;
                case "4":
                    exportarVisitas();
                    mostrarMenu = false;
                    break;
                case "5":
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    mostrarMenu = false;
                    break;
            }
        }
    }

    private void exportarVisitas() {
        AdminVisita admin = AdminVisita.getInstance();
        String rutaArchivo = control
                .ingresoTexto("Ingrese un nombre para del archivo: ");
        boolean exportado = admin.exportarDatos(rutaArchivo, reserva.visitas, reserva.visitantes);
        if (exportado) {
            System.out.println("Datos de Visitas exportados correctamente.");
        } else {
            System.out.println("No se pudo exportar los datos de visitas como CSV.");
        }
    }

    private void exportarVisitantes() {
        AdminVisitante admin = AdminVisitante.getInstance();
        String rutaArchivo = control
                .ingresoTexto("Ingrese un nombre para del archivo: ");
        boolean exportado = admin.exportarDatos(rutaArchivo, reserva.visitantes);
        if (exportado) {
            System.out.println("Datos de Visitantes exportados correctamente.");
        } else {
            System.out.println("No se pudo exportar los datos de visitantes como CSV.");
        }
    }

    private void exportarGuardaparques() {
        AdminGuardaparque admin = AdminGuardaparque.getInstance();
        String rutaArchivo = control
                .ingresoTexto("Ingrese un nombre para del archivo: ");
        boolean exportado = admin.exportarDatos(rutaArchivo, reserva.guardaparques);
        if (exportado) {
            System.out.println("Datos de Guardaparques exportados correctamente.");
        } else {
            System.out.println("No se pudo exportar los datos de guardaparques como CSV.");
        }
    }

    private void exportarIncidencias() {
        AdminIncidencia admin = AdminIncidencia.getInstance();
        String rutaArchivo = control
                .ingresoTexto("Ingrese un nombre para del archivo: ");
        boolean exportado = admin.exportarDatos(rutaArchivo, reserva.incidencias, reserva.visitantes,
                reserva.guardaparques);
        if (exportado) {
            System.out.println("Datos de Incidencias exportados correctamente.");
        } else {
            System.out.println("No se pudo exportar los datos de incidencias como CSV.");
        }
    }

}
