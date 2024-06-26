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
                + "cedula    => " + (this.cedula == null ? "###" : this.cedula) + "\n"
                + "pasaporte => " + (this.pasaporte == null ? "###" : this.pasaporte) + "\n"
                + "nombres   => " + (this.nombres == null || this.nombres == "" ? "###" : this.nombres) + "\n"
                + "apellidos => " + (this.apellidos == null || apellidos == "" ? "###" : this.apellidos) + "\n"
                + "direccion => " + (this.direccion == null || direccion == "" ? "###" : this.direccion) + "\n"
                + "telefono  => " + (this.telefono == "null" ? "###" : this.telefono) );
        return super.toString();
    }
}
