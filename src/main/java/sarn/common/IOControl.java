package sarn.common;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class IOControl {
    private Scanner in = new Scanner(System.in);
    private Integer[] coeficientes = {2,1,2,1,2,1,2,1,2};
    private static IOControl control;
    public DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

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
        while(true) {
            try {
                System.out.print("==> " + msg + " = ");
                String s = in.nextLine();
                if(s.trim().equals("") || s==null){
                    return null;
                }
                Integer n = Integer.valueOf(s);
                return n;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] solo puede ingresar un numero");
            }
        }
    }

    public Integer ingresoNumero(String msg, Boolean opcional){
        Boolean ok = false;
        while(!ok){
            Integer n = ingresoNumero(msg);
            if(n == null){
                if(opcional){
                    return null;
                }
                System.out.println("Este es un campo obligatorio");
            }else{
                return n;
            }
        }
        return null;
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
        while (true) {
            Integer n = this.ingresoNumero(msg);
            if(n==null){
                return null;
            }
            String cedula = String.valueOf(n);
            if(this.validarCedula(cedula)) {
                return cedula;
            }
            System.out.println("cedula invalida");
        }
    }

    public String ingresoCedula(String msg, Boolean opcional) {
        Boolean ok = false;
        while(!ok){
            String cedula = ingresoCedula(msg);
            if(cedula == null){
                if(opcional){
                    return null;
                }else{
                    System.out.println("Este es un campo obligatorio");
                }
            }else{
                return cedula;
            }
        }
        return null;
    }

    public LocalDateTime ingresoFechaHora(String msg) {
        Boolean ok = false;
        LocalDateTime fecha = null;
        while(!ok) {
            try {
                System.out.print("==> " + msg + " = ");
                String s = in.nextLine();
                fecha = LocalDateTime.parse(s, formatoFechaHora);
                ok = !ok;
            } catch (Exception e) {
                System.out.println("Debe ingresar la fecha en el formato indicado");
            }
        }
        return fecha;
    }

    public boolean confirmacionSalida(String mensaje) {
        String respuesta;
        while (true) {
            System.out.print(mensaje);
            respuesta = in.nextLine().trim().toLowerCase();
            if (respuesta.equals("s") || respuesta.equals("n")) {
                break;
            } else {
                System.out.println("Por favor, responda 's' para sí o 'n' para no.");
            }
        }
        return respuesta.equals("s");
    }
    
}
