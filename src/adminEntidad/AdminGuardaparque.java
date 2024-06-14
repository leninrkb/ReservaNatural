package adminEntidad;
import java.util.List;
import entidad.Entidad;
import entidad.Guardaparque;

public class AdminGuardaparque extends AdminEntidad {
    private static AdminGuardaparque clase;

    private AdminGuardaparque(){}
    
    @Override
    public Entidad nuevaEntidad() {
        this.registro += 1;
        Entidad entidad = new Guardaparque();
        entidad.id = this.registro;
        return entidad;
    }

    @Override
    public void llenarEntidad(Entidad entidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'llenarEntidad'");
    }

    @Override
    public void listarEntidades(List<Entidad> entidades) {
        System.out.println("LISTA DE GUARDAPARQUES");
        for (int i = 0; i < entidades.size(); i++) {
            Guardaparque g = (Guardaparque) entidades.get(i);
            g.toString();
            System.out.println();
        }
    }

    public static AdminGuardaparque getInstance() {
        if(clase == null) {
            clase = new AdminGuardaparque();
            return clase;
        }
        return clase;
    }
}
