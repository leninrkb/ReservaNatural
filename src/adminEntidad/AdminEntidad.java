import java.util.List;

import entidad.Entidad;

public abstract class AdminEntidad {
    protected Integer registro = 0;
    protected IOControl control = IOControl.getInstance();

    public abstract Entidad nuevaEntidad();
    public abstract void llenarEntidad(Entidad entidad);
    public abstract void listarEntidades(List<Entidad> entidades);

    public void registrarEntidad(List<Entidad> entidades, Entidad entidad) {
        entidades.add(entidad);
    }
}
