package entidad;
import java.util.Date;

public class Guardaparque extends Persona {
    public Date fechaContratacion;

    @Override
    public String toString() {
        System.out.println(""
        + "ID                    => " + id
        + "Cedula                => " + cedula
        + "Nombres               => " + nombres
        + "Apellidos             => " + apellidos
        + "Fecha de contratacion => " + fechaContratacion
        );
        return super.toString();
    }
}   
