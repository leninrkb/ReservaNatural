package sarn.adminEntidad;

import java.util.List;
import sarn.common.*;
import sarn.entidad.*;

public abstract class AdminEntidad {
    public Integer registro = 0;
    protected IOControl control = IOControl.getInstance();
    public boolean cargarRegistro = false;

    public abstract Entidad nuevaEntidad();

    public abstract void llenarEntidad(Entidad entidad);

    public abstract void listarEntidades(List<Entidad> entidades);

    public abstract Entidad editarEntidad(Entidad e);

    public Boolean eliminarEntidad(Integer id, List<Entidad> entidades) {
        for (int i = 0; i < entidades.size(); i++) {
            Entidad current = entidades.get(i);
            if (current.id.equals(id)) {
                entidades.remove(i);
                return true;
            }
        }
        return false;
    }

    public Entidad encontrarEntidad(List<Entidad> entidades, Integer id) {
        Entidad valido = null;
        for (int i = 0; i < entidades.size(); i++) {
            Entidad e = entidades.get(i);
            if (e.id.equals(id)) {
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
