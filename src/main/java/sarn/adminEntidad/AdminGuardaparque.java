package sarn.adminEntidad;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import sarn.entidad.*;

public class AdminGuardaparque extends AdminPersona {
    private static AdminGuardaparque clase;

    private AdminGuardaparque() {
    }

    @Override
    public Entidad nuevaEntidad() {
        this.registro += 1;
        Entidad entidad = new Guardaparque();
        entidad.id = this.registro;
        return entidad;
    }

    public void llenarEntidad(Entidad e, List<Entidad> entidades) {
        System.out.println();
        System.out.println("NUEVO GUARDAPARQUE");
        Guardaparque gd = (Guardaparque) e;
        while (true) {
            gd.cedula = this.control.ingresoCedula("ingrese su cedula", false);
            if (cedulaUnica(gd, entidades)) {
                break;
            }
        }
        llenarEntidad(e);
    }

    @Override
    public void llenarEntidad(Entidad entidad) {
        Guardaparque g = (Guardaparque) entidad;
        g.nombres = control.ingresoNombres("nombres");
        g.apellidos = control.ingresoNombres("apellidos");
        g.fechaContratacion = LocalDateTime.now();
    }

    @Override
    public void listarEntidades(List<Entidad> entidades) {
        System.out.println();
        System.out.println("LISTA DE GUARDAPARQUES");
        for (int i = 0; i < entidades.size(); i++) {
            Guardaparque g = (Guardaparque) entidades.get(i);
            g.toString();
            System.out.println();
        }
    }

    public static AdminGuardaparque getInstance() {
        if (clase == null) {
            clase = new AdminGuardaparque();
            return clase;
        }
        return clase;
    }

    public void editarEntidad(List<Entidad> entidades, Integer id) {
        Guardaparque gd = (Guardaparque) encontrarEntidad(entidades, id);
        if (gd == null) {
            System.out.println("No se logro encontrar el guardaparque");
            return;
        }
        editarEntidad(gd);
        if (control.confirmar("actualizar fecha de contratacion? (s/n)")) {
            gd.fechaContratacion = control.ingresoFechaHora("Ingrese nueva fecha y hora (formato: yyyy-MM-dd HH:mm)");
        }
    }

    public boolean exportarDatos(String rutaArchivo, List<Entidad> guardaparques) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            // Escribir encabezados CSV
            writer.write("ID,Nombres,Apellidos,Cédula, Fecha Contratacion\n");

            // Escribir datos de visitantes
            for (Entidad entidad : guardaparques) {
                Guardaparque g = (Guardaparque) entidad;
                writer.write(String.format("%d,%s,%s,%s,%s\n",
                        g.id, g.nombres, g.apellidos, g.cedula, g.fechaContratacion));
            }

            return true;
        } catch (IOException e) {
            System.out.println("Error al exportar los datos de guardaparques como CSV: " + e.getMessage());
            return false;
        }
    }

}
