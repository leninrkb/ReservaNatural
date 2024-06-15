package main.java.sarn.adminEntidad;
import java.util.List;
import main.java.sarn.common.*;
import main.java.sarn.entidad.*;

public abstract class AdminEntidad {
    protected Integer registro = 0;
    protected IOControl control = IOControl.getInstance();

    public abstract Entidad nuevaEntidad();
    public abstract void llenarEntidad(Entidad entidad);
    public abstract void listarEntidades(List<Entidad> entidades);

    public Entidad validarEntidad(List<Entidad> entidades, Integer id) {
        Entidad valido = null;
        for (int i = 0; i < entidades.size(); i++) {
            Entidad e = entidades.get(i);
            if(e.id == id) {
                valido = e;
                break;
            }
        }
        return valido;
    }

    public void registrarEntidad(List<Entidad> entidades, Entidad entidad) {
        entidades.add(entidad);
    }
}
