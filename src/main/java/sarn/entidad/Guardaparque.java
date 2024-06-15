package sarn.entidad;
import java.time.LocalDateTime;

public class Guardaparque extends Persona {
    public LocalDateTime fechaContratacion;

    public String getFechaContratacion() {
        if(fechaContratacion != null) {
            return fechaContratacion.format(formatoFechaHora);
        }
        return "";
    }

    @Override
    public String toString() {
        System.out.println(""
        + "ID                    => " + id + "\n"
        + "Cedula                => " + cedula + "\n"
        + "Nombres               => " + nombres + "\n"
        + "Apellidos             => " + apellidos + "\n"
        + "Fecha de contratacion => " + getFechaContratacion()
        );
        return super.toString();
    }

   
}   
