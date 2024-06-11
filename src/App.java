import entidad.Visitante;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World! from docker");
        ReservaNatural reserva = new ReservaNatural();
        AdminEntidad adminVisitante = new AdminVisitante();
        Visitante e = (Visitante) adminVisitante.nuevaEntidad();
        Visitante e2 = (Visitante) adminVisitante.nuevaEntidad();
        adminVisitante.llenarEntidad(e);
        adminVisitante.llenarEntidad(e2);

        e.toString();
        e2.toString();
    }
}
