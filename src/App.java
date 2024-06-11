import entidad.Entidad;
import entidad.Visitante;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World! from docker");
        ReservaNatural reserva = new ReservaNatural();
        AdminEntidad adminVisitante = new AdminVisitante();
        Visitante e = (Visitante) adminVisitante.nuevaEntidad();
        e.nombres = "Lenin Alexander";
        adminVisitante.registrarEntidad(reserva.visitantes, e);

        System.out.println(reserva.visitantes);
    }
}
