package sarn.adminEntidad;

import java.util.List;
import sarn.entidad.*;

public class AdminVisitante extends AdminPersona {
    private static AdminVisitante clase;

    private AdminVisitante() {
    }

    public static AdminVisitante getInstance() {
        if (clase == null) {
            clase = new AdminVisitante();
            return clase;
        }
        return clase;
    }

    @Override
    public Entidad nuevaEntidad() {
        this.registro += 1;
        Entidad entidad = new Visitante();
        entidad.id = this.registro;
        return entidad;
    }

    public void llenarEntidad(Entidad e, List<Entidad> visitantes){
        System.out.println();
        System.out.println("[NUEVO VISITANTE]");
        Visitante v = (Visitante) e;
        Boolean opcional = true;
        while(true){
            v.cedula = this.control.ingresoCedula("ingrese su cedula", opcional);
            if(v.cedula == null) {
                opcional = !opcional;
                break;
            }
            if(cedulaUnica(v, visitantes)){
                break;
            }
        }
        v.ruc = String.valueOf(this.control.ingresoNumero("ingrese su ruc", opcional));
        llenarEntidad(e);
    }
    
    @Override
    public void llenarEntidad(Entidad e) {
        Visitante v = (Visitante) e;
        v.nombres = this.control.ingresoNombres("ingrese sus nombres");
        v.apellidos = this.control.ingresoNombres("ingrese sus apellidos");
        v.direccion = this.control.ingresoTexto("ingrese su direccion");
        v.telefono = String.valueOf(this.control.ingresoNumero("ingrese su telefono"));
    }

    @Override
    public void listarEntidades(List<Entidad> entidades) {
        System.out.println();
        System.out.println("VISITANTES REGISTRADOS");
        for (int i = 0; i < entidades.size(); i += 1) {
            Visitante v = (Visitante) entidades.get(i);
            v.toString();
            System.out.println();
        }
    }

    @Override
    public Boolean eliminarEntidad(Integer id, List<Entidad> entidades) {
        Visitante vt = (Visitante) encontrarEntidad(entidades, id);
        if(vt == null){
            System.out.println("No existe nadie con el ID indicado");
            return false;
        }
        if(!vt.enVisita){
            return super.eliminarEntidad(id, entidades);
        }
        System.out.println("El visitante esta aun dentro de la reserva");
        return false;
    }

    public void editarEntidad(List<Entidad> entidades, Integer id) {
        Visitante vt = (Visitante) encontrarEntidad(entidades, id);
        if(vt == null){
            System.out.println("no se encontro al visitante");
            return;
        }
        super.editarEntidad(vt);
        if(control.confirmar("editar ruc? (s/n)")){
            vt.ruc = control.ingresoTexto("ruc");
        }
        if(control.confirmar("editar direccion? (s/n)")){
            vt.direccion = control.ingresoTexto("Direccion");
        }
        if(control.confirmar("editar telefono? (s/n)")){
            vt.telefono = control.ingresoTexto("telefono");
        }
    }

}
