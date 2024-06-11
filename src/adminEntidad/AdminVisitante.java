import entidad.Entidad;
import entidad.Visitante;

public class AdminVisitante extends AdminEntidad {

    @Override
    public Entidad nuevaEntidad() {
        this.registro += 1;
        Entidad entidad = new Visitante();
        entidad.id = this.registro;
        return entidad;
    }
}
