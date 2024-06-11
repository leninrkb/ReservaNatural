import entidad.Entidad;
import entidad.Guardaparque;

public class AdminGuardaparque extends AdminEntidad {

    @Override
    public Entidad nuevaEntidad() {
        this.registro += 1;
        Entidad entidad = new Guardaparque();
        entidad.id = this.registro;
        return entidad;
    }
}
