package sarn.adminEntidad;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import sarn.entidad.*;

public class AdminVisitante extends AdminPersona {
    private static AdminVisitante clase;

    private AdminVisitante() {
    }

    public static AdminVisitante getInstance() {
        if (clase == null) {
            clase = new AdminVisitante();
            return clase;
        }
        return clase;
    }

    @Override
    public Entidad nuevaEntidad() {
        this.registro += 1;
        Entidad entidad = new Visitante();
        entidad.id = this.registro;
        return entidad;
    }

    public void llenarEntidad(Entidad e, List<Entidad> visitantes, List<Entidad> guardaparques) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("[NUEVO VISITANTE]");
        Visitante v = (Visitante) e;

        while (true) {
            System.out.print("Tiene cedula? (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();

            if (respuesta.equals("s") || respuesta.equals("n")) {
                if (respuesta.equals("s")) {
                    v.cedula = this.control.ingresoCedula("Ingrese su cedula", false);
                    if (!cedulaUnica(v, visitantes) || !cedulaUnica(v, guardaparques)) {
                        System.out.println("La cédula ingresada ya está en uso. Intente nuevamente.");
                        continue;
                    }
                } else { 
                    v.pasaporte = String.valueOf(this.control.ingresoNumero("Ingrese su pasaporte", false));
                }
                break;
            } else {
                System.out.println("Ingrese solo 's' o 'n'.");
            }
        }

        llenarEntidad(e);
    }

    @Override
    public void llenarEntidad(Entidad e) {
        Visitante v = (Visitante) e;
        v.nombres = this.control.ingresoNombres("ingrese sus nombres");
        v.apellidos = this.control.ingresoNombres("ingrese sus apellidos");
        v.direccion = this.control.ingresoTexto("ingrese su direccion");
        v.telefono = String.valueOf(this.control.ingresoNumero("ingrese su telefono"));
    }

    @Override
    public void listarEntidades(List<Entidad> entidades) {
        System.out.println();
        System.out.println("VISITANTES REGISTRADOS");
        for (int i = 0; i < entidades.size(); i += 1) {
            Visitante v = (Visitante) entidades.get(i);
            v.toString();
            System.out.println();
        }
    }

    @Override
    public Boolean eliminarEntidad(Integer id, List<Entidad> entidades) {
        Visitante vt = (Visitante) encontrarEntidad(entidades, id);
        if (vt == null) {
            System.out.println("No existe nadie con el ID indicado");
            return false;
        }
        if (!vt.enVisita) {
            return super.eliminarEntidad(id, entidades);
        }
        System.out.println("El visitante esta aun dentro de la reserva");
        return false;
    }

    public void editarEntidad(List<Entidad> entidades, Integer id) {
        Visitante vt = (Visitante) encontrarEntidad(entidades, id);
        if (vt == null) {
            System.out.println("no se encontro al visitante");
            return;
        }
        super.editarEntidad(vt);
        if (control.confirmar("editar pasaporte? (s/n)")) {
            vt.pasaporte = control.ingresoTexto("pasaporte");
        }
        if (control.confirmar("editar direccion? (s/n)")) {
            vt.direccion = control.ingresoTexto("Direccion");
        }
        if (control.confirmar("editar telefono? (s/n)")) {
            vt.telefono = control.ingresoTexto("telefono");
        }
    }

    //
    public boolean exportarDatos(String rutaArchivo, List<Entidad> visitantes) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            // Escribir encabezados CSV
            writer.write("ID,Nombres,Apellidos,Cédula,Pasaporte,Dirección,Teléfono\n");

            // Escribir datos de visitantes
            for (Entidad entidad : visitantes) {
                Visitante v = (Visitante) entidad;
                writer.write(String.format("%d,%s,%s,%s,%s,%s,%s\n",
                        v.id, v.nombres, v.apellidos, v.cedula, v.pasaporte, v.direccion, v.telefono));
            }

            return true;
        } catch (IOException e) {
            System.out.println("Error al exportar los datos de visitantes como CSV: " + e.getMessage());
            return false;
        }
    }

}
