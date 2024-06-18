package sarn.persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import sarn.common.ReservaNatural;

public class Persistencia {
    private static Persistencia clase;

    private Persistencia() {
    }

    public static Persistencia getInstance() {
        if (clase == null) {
            clase = new Persistencia();
            return clase;
        }
        return clase;
    }

    public Boolean guardarEstado(ReservaNatural reserva) {
        try {
            FileOutputStream fileOut = new FileOutputStream("reservaNatural.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(reserva);
            System.out.println("ReservaNatural guardada en reservaNatural.ser");
            return true;
        } catch (IOException i) {
            i.printStackTrace();
            return false;
        }
    }

    public Boolean cargarEstado(ReservaNatural reserva) {
        try {
            FileInputStream fileIn = new FileInputStream("reservaNatural.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            reserva = (ReservaNatural) in.readObject();
            ReservaNatural.setInstance(reserva);
            return true;
        } catch (IOException i) {
            // i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("No se encontro datos por cargar...");
            // c.printStackTrace();
        }
        return false;
    }
}
