package sarn.entidad;

import java.time.LocalDateTime;
import sarn.common.FormatoFecha;

public class Guardaparque extends Persona {
    public LocalDateTime fechaContratacion;

    public String getFechaContratacion() {
        if (fechaContratacion != null) {
            return fechaContratacion.format(FormatoFecha.formatoFechaHora);
        }
        return "";
    }

    @Override
    public String toString() {
        System.out.println(""
                + "ID                    => " + id + "\n"
                + "Cedula                => " + (cedula == null ? "###" : cedula) + "\n"
                + "Nombres               => " + (nombres == null ? "###" : nombres) + "\n"
                + "Apellidos             => " + (apellidos == null ? "###" : apellidos) + "\n"
                + "Fecha de contratacion => " + getFechaContratacion());
        return super.toString();
    }

}
