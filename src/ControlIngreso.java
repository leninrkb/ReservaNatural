import java.util.Scanner;

public class ControlIngreso {
    private Scanner in = new Scanner(System.in);

    public String ingresoTexto(String msg){
        System.out.print("==> " + msg + " = ");
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
}
