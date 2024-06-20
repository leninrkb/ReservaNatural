package sarn.entidad;

public class Visitante extends Persona {
    public String pasaporte;
    public String direccion;
    public String telefono;
    public Boolean enVisita = false;

    public void cambioEstadoVisita() {
        enVisita = !enVisita;
    }

    @Override
    public String toString() {
        System.out.println(""
                + "id        => " + this.id + "\n"
                + "cedula    => " + this.cedula + "\n"
                + "nombres   => " + this.nombres + "\n"
                + "apellidos => " + this.apellidos + "\n"
                + "pasaporte => " + this.pasaporte + "\n"
                + "direccion => " + this.direccion + "\n"
                + "telefono  => " + this.telefono);
        return super.toString();
    }
}
