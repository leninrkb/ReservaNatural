package sarn.entidad;

public class Incidencia extends Visita {
    public Integer idGuardaparque;
    public String descripcion;
    public String anotaciones;

    @Override
    public String toString() {
        System.out.println(""
        + "ID                => " + id + "\n"
        + "ID Guardaparque   => " + idGuardaparque + "\n"
        + "ID Visitante      => " + idVisitante + "\n"
        + "Descripcion       => " + descripcion + "\n"
        + "Fecha del reporte => " + getFechaHoraInicia() + "\n"
        + "Fecha de atencion => " + getFechaHoraTermina() + "\n"
        + "Anotaciones       => " + anotaciones
        );
        return "";
    }
}
