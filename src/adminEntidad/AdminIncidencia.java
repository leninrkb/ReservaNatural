import entidad.Entidad;
import entidad.Incidencia;

public class AdminIncidencia extends AdminEntidad {

    @Override
    public Entidad nuevaEntidad() {
        this.registro += 1;
        Entidad entidad = new Incidencia();
        entidad.id = this.registro;
        return entidad;
    }

    @Override
    public void llenarEntidad(Entidad entidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'llenarEntidad'");
    }
    
}
