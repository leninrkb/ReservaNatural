import java.util.List;

import entidad.Entidad;

public abstract class AdminEntidad {
    protected Integer registro = 0;
    protected ControlIngreso control = new ControlIngreso();

    public abstract Entidad nuevaEntidad();
    public abstract void llenarEntidad(Entidad entidad);

    public void registrarEntidad(List<Entidad> entidades, Entidad entidad) {
        entidades.add(entidad);
    }
}
