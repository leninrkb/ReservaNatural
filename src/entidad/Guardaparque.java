package entidad;
import java.time.LocalDateTime;
import java.util.Date;

public class Guardaparque extends Persona {
    public LocalDateTime fechaContratacion;

    public String getFechaContratacion() {
        if(fechaContratacion != null) {
            return fechaContratacion.format(patronFecha);
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
