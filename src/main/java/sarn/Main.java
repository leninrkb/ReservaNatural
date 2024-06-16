package sarn;
import sarn.common.ReservaNatural;
import sarn.common.Terminal;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World! from docker");
        ReservaNatural reserva = ReservaNatural.getInstance();
        Terminal t = new Terminal();
        Datos datos = Datos.getInstance();
        datos.ingresarVisitantes(reserva);
        datos.ingresarGuardaparques(reserva);
        datos.ingresarIncidencias(reserva);
        datos.ingresarVisitas(reserva);
        t.inicio();
    }
}
