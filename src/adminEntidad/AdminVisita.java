import entidad.Entidad;
import entidad.Visita;

public class AdminVisita extends AdminEntidad {

    @Override
    public Entidad nuevaEntidad() {
        this.registro += 1;
        Entidad entidad = new Visita();
        entidad.id = this.registro;
        return entidad;
    }
    
}
