package sarn.entidad;

public class Visitante extends Persona {
    public String ruc;
    public String direccion;
    public String telefono;

    @Override
    public String toString() {
        System.out.println(""
        + "id        => " + this.id + "\n" 
        + "cedula    => " + this.cedula + "\n" 
        + "nombres   => " + this.nombres + "\n" 
        + "apellidos => " + this.apellidos + "\n" 
        + "ruc       => " + this.ruc + "\n"
        + "direccion => " + this.direccion + "\n"
        + "telefono  => " + this.telefono);
        return super.toString();
    }
}
