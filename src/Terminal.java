import java.util.ArrayList;
import java.util.Arrays;

public class Terminal {
    ControlIngreso control = ControlIngreso.getInstance();

    public void inicio() {
        Boolean terminar = false;
        while (!terminar) {
            String comando = control.ingresoTerminal();
            switch (comando) {
                case "visitantes":
                case "v":
                    System.out.println("buscar visitante");
                    System.out.println("registrar visitante");
                    System.out.println("registrar entrada");
                    System.out.println("registrar salida");
                    System.out.println("generar reporte de incidencia");
                    break;

                case "guardaparques":
                case "g":
                    System.out.println("buscar guardaparque");
                    System.out.println("buscar incidencia");
                    System.out.println("registrar guardaparque");
                    System.out.println("comando usuario");
                    System.out.println("atender incidencia");
                    break;

                case "reportes":
                case "r":
                    System.out.println("generar reporte de visitantes");
                    System.out.println("generar reporte de incidencias");
                    break;
                
                case "help":
                case "h":
                    System.out.println("** Comandos disponibles **");
                    System.out.println("visitantes / v");
                    System.out.println("guardaparques / g");
                    System.out.println("reportes / r");
                    System.out.println("help / h");
                    break;
                default:
                    break;
            }
        }
    }
}
