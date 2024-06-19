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
                System.out.println("1. Listar incidencias                                     (l)");
                System.out.println("2. Registrar nueva incidencia                             (r)");
                System.out.println("3. Atender incidencia                                     (a)");
                System.out.println("4. Salir                                                  (x)");
                System.out.println("5. Mostrar ayuda                                          (h)");
                System.out.println("6. Eliminar incidencia                                    (el)");
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

                case "eliminar":
                case "el":
                case "6":
                    Boolean eliminado = admin.eliminarEntidad(control.ingresoNumero("ID de la incidencia a eliminar"),
                            reserva.incidencias);
                    if (eliminado) {
                        System.out.println("Operacion realizada con exito!");
                    }
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
                    System.out.println("=======================================\n");
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
                System.out.println("1. Listar guardaparques                                    (l)");
                System.out.println("2. Registrar nuevo guardaparque                            (r)");
                System.out.println("3. Salir                                                   (x)");
                System.out.println("4. Mostrar ayuda                                           (h)");
                System.out.println("5. Eliminar Guardaparque                                   (el)");
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
                    admin.llenarEntidad(e, reserva.guardaparques);
                    admin.registrarEntidad(reserva.guardaparques, e);
                    mostrarMenu = false;
                    break;

                case "salir":
                case "x":
                case "3":
                    salir = !salir;
                    break;

                case "eliminar":
                case "el":
                case "5":
                    Boolean eliminado = admin.eliminarEntidad(control.ingresoNumero("ID del guardaparque a eliminar"),
                            reserva.guardaparques);
                    if (eliminado) {
                        System.out.println("Operacion realizada con exito!");
                    }
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
                    System.out.println("======================================\n");
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
                System.out.println("1. Listar visitantes                                      (l)");
                System.out.println("2. Registrar nuevo visitante                              (r)");
                System.out.println("3. Salir                                                  (x)");
                System.out.println("4. Mostrar ayuda                                          (h)");
                System.out.println("5. Eliminar visitante                                     (el)");
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
                    admin.llenarEntidad(e, reserva.visitantes);
                    admin.registrarEntidad(reserva.visitantes, e);
                    mostrarMenu = false;
                    System.out.println();
                    break;

                case "salir":
                case "x":
                case "3":
                    salir = !salir;
                    break;

                case "eliminar":
                case "el":
                case "5":
                    Boolean eliminado = admin.eliminarEntidad(control.ingresoNumero("ID del visitante a eliminar"),
                            reserva.visitantes);
                    if (eliminado) {
                        System.out.println("Operacion realizada con exito!");
                    }
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
                    System.out.println("======================================\n");
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
                System.out.println("1. Listar visitas                                         (l)");
                System.out.println("2. Registrar nueva visita                                 (r)");
                System.out.println("3. Registrar salida de visita                             (rs)");
                System.out.println("4. Salir                                                  (x)");
                System.out.println("5. Mostrar ayuda                                          (h)");
                System.out.println("6. Eliminar visita                                        (el)");
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

                case "eliminar":
                case "el":
                case "6":
                    Boolean eliminado = admin.eliminarEntidad(control.ingresoNumero("ID de la visita a eliminar"),
                            reserva.visitas);
                    if (eliminado) {
                        System.out.println("Operacion realizada con exito!");
                    }
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
                    System.out.println("=============================================\n");
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
                System.out.println("1. Reporte de visitantes por día                          (vs d)");
                System.out.println("2. Reporte de visitas por fecha                           (vs f)");
                System.out.println("3. Reporte de incidencias por rango de fechas             (vs rf)");
                System.out.println("4. Salir                                                  (x)");
                System.out.println("5. Mostrar ayuda                                          (h)");
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
                System.out.println("1. Administrar visitantes                         (v)");
                System.out.println("2. Administrar visitas                            (vs)");
                System.out.println("3. Administrar guardaparques                      (g)");
                System.out.println("4. Administrar incidencias                        (i)");
                System.out.println("5. Generar reportes                               (r)");
                System.out.println("6. Salir                                          (x)");
                System.out.println("7. Mostrar ayuda                                  (h)");
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
                    System.out.println("7. h          - h");
                    System.out.println("=============================\n");
                    mostrarMenu = false;
                    break;
            }
        }
    }
}
