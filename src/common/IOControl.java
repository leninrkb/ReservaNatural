package common;
import java.util.Scanner;

public class IOControl {
    private Scanner in = new Scanner(System.in);
    private Integer[] coeficientes = {2,1,2,1,2,1,2,1,2};
    private static IOControl control;

    private IOControl() {}

    public static IOControl getInstance() {
        if (control == null) {
            control = new IOControl();
            return control;
        }
        return control;
    }

    public String ingresoTexto(String msg){
        System.out.print("==> " + msg + " = ");
        String s = in.nextLine();
        return s;
    }

    public String ingresoTerminal(String msg){
        System.out.print("[SARN@" + msg + "]# ");
        String s = in.nextLine();
        return s;
    }

    public Integer ingresoNumero(String msg){
        Boolean ok = false;
        Integer n = null;
        while(!ok) {
            try {
                System.out.print("==> " + msg + " = ");
                String s = in.nextLine();
                n = Integer.valueOf(s);
                ok = !ok;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] solo puede ingresar un numero");
            }
        }
        return n;
    }

    public Boolean validarCedula(String cedula) {
        if (cedula.length() == 10) {
            Integer d1_2 = Integer.valueOf(String.valueOf(cedula.charAt(0)) + String.valueOf(cedula.charAt(1)));
            if ( d1_2 > 0 && d1_2 <= 24 ) {
                Integer d3 = Integer.valueOf(String.valueOf(cedula.charAt(2)));
                if ( d3 < 6 ) { 
                    Integer d10 = Integer.valueOf(String.valueOf(cedula.charAt(9)));
                    Integer resultado = 0;
                    Integer validador = 0;
                    for (int i=0; i< this.coeficientes.length; i+=1) {
                        Integer producto = this.coeficientes[i] * Integer.valueOf(String.valueOf(cedula.charAt(i)));
                        if ( producto >= 10 ) {
                            producto -= 9;
                        }
                        resultado += producto;
                    }
                    Integer decenaSuperior = (( (Integer) resultado / 10) + 1) * 10;
                    validador = decenaSuperior - resultado;
                    validador = validador == 10 ? 0 : validador;
                    if (validador == d10) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String ingresoCedula(String msg) {
        String cedula = "";
        Boolean ok = false;
        while (!ok) {
            cedula = String.valueOf(this.ingresoNumero(msg));
            if(this.validarCedula(cedula)) {
                return cedula;
            }
            String respuesta = this.ingresoTexto("cedula invalida, intentar nuevamente? [s/n]");
            if (!respuesta.equalsIgnoreCase("s")) {
                cedula = "0000000000";
                ok = !ok;
            }
        }
        return cedula;
    }
}
