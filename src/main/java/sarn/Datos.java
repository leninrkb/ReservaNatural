package sarn;
import java.time.LocalDateTime;
import java.util.List;

import sarn.adminEntidad.AdminGuardaparque;
import sarn.adminEntidad.AdminIncidencia;
import sarn.adminEntidad.AdminVisita;
import sarn.adminEntidad.AdminVisitante;
import sarn.common.ReservaNatural;
import sarn.entidad.*;

public class Datos {
    private static Datos clase;

    private Datos() {}

    public static Datos getInstance() {
        if (clase == null) {
            clase = new Datos();
            return clase;
        }
        return clase;
    }

    public void ingresarVisitas(ReservaNatural reserva) {
        List<Entidad> visitas = reserva.visitas;
        List<Entidad> visitantes = reserva.visitantes;
        AdminVisita admin =AdminVisita.getInstance();

        Visita v = (Visita) admin.nuevaEntidad();
        Visitante vt = (Visitante) admin.validarEntidad(visitantes, 1);
        vt.cambioEstadoVisita();
        v.idVisitante = 1;
        v.fechaHoraEntrada =LocalDateTime.now();
        admin.registrarEntidad(visitas, v);

        v = (Visita) admin.nuevaEntidad();
        vt = (Visitante) admin.validarEntidad(visitantes, 2);
        vt.cambioEstadoVisita();
        v.idVisitante = 2;
        v.fechaHoraEntrada =LocalDateTime.now();
        admin.registrarEntidad(visitas, v);

        v = (Visita) admin.nuevaEntidad();
        vt = (Visitante) admin.validarEntidad(visitantes, 3);
        v.idVisitante = 3;
        v.fechaHoraEntrada =LocalDateTime.now();
        v.fechaHoraSalida =LocalDateTime.now().plusMinutes(10);
        admin.registrarEntidad(visitas, v);
    }

    public void ingresarIncidencias(ReservaNatural reserva){
        List<Entidad> incidenctes = reserva.incidencias;
        AdminIncidencia admin = AdminIncidencia.getInstance();
        Incidencia inc = (Incidencia) admin.nuevaEntidad();
        inc.anotaciones = "lorem impsun dolor amet";
        inc.descripcion = "lorem impsun dolor amet";
        inc.idVisitante = 1;
        inc.idGuardaparque = 1;
        inc.fechaHoraReporte = LocalDateTime.now();
        inc.fechaHoraAtencion = LocalDateTime.now().plusMinutes(15);
        admin.registrarEntidad(incidenctes, inc);

        inc = (Incidencia) admin.nuevaEntidad();
        inc.anotaciones = "lorem impsun dolor amet";
        inc.descripcion = "lorem impsun dolor amet";
        inc.idVisitante = 2;
        inc.idGuardaparque = 1;
        inc.fechaHoraReporte = LocalDateTime.now().plusMinutes(5);
        inc.fechaHoraAtencion = LocalDateTime.now().plusMinutes(20);
        admin.registrarEntidad(incidenctes, inc);

        inc = (Incidencia) admin.nuevaEntidad();
        inc.anotaciones = "lorem impsun dolor amet";
        inc.descripcion = "lorem impsun dolor amet";
        inc.idVisitante = 1;
        inc.idGuardaparque = 2;
        inc.fechaHoraReporte = LocalDateTime.now().plusMinutes(1);
        inc.fechaHoraAtencion = LocalDateTime.now().plusMinutes(3);
        admin.registrarEntidad(incidenctes, inc);

        inc = (Incidencia) admin.nuevaEntidad();
        inc.anotaciones = "lorem impsun dolor amet";
        inc.descripcion = "lorem impsun dolor amet";
        inc.idVisitante = 1;
        inc.idGuardaparque = 2;
        inc.fechaHoraReporte = LocalDateTime.now();
        inc.fechaHoraAtencion = LocalDateTime.now().plusMinutes(6);
        admin.registrarEntidad(incidenctes, inc);


        inc = (Incidencia) admin.nuevaEntidad();
        inc.anotaciones = "lorem impsun dolor amet";
        inc.descripcion = "lorem impsun dolor amet";
        inc.idVisitante = 2;
        inc.fechaHoraReporte = LocalDateTime.now();
        admin.registrarEntidad(incidenctes, inc);

        inc = (Incidencia) admin.nuevaEntidad();
        inc.anotaciones = "lorem impsun dolor amet";
        inc.descripcion = "lorem impsun dolor amet";
        inc.idVisitante = 3;
        inc.fechaHoraReporte = LocalDateTime.now();
        admin.registrarEntidad(incidenctes, inc);
    }

    public void ingresarGuardaparques(ReservaNatural reserva){
        List<Entidad> guardaparques = reserva.guardaparques;
        AdminGuardaparque admin = AdminGuardaparque.getInstance();
        Guardaparque g = (Guardaparque) admin.nuevaEntidad();
        g.cedula = "1802302102";
        g.nombres = "Lalo";
        g.apellidos = "Mbriz";
        g.fechaContratacion = LocalDateTime.now();
        admin.registrarEntidad(guardaparques, g);

        g = (Guardaparque) admin.nuevaEntidad();
        g.cedula = "0102320120";
        g.nombres = "Elizabeth";
        g.apellidos = "Swarth";
        g.fechaContratacion = LocalDateTime.now();
        admin.registrarEntidad(guardaparques, g);

        g = (Guardaparque) admin.nuevaEntidad();
        g.cedula = "9089089809";
        g.nombres = "Kanth";
        g.apellidos = "Barbaron";
        g.fechaContratacion = LocalDateTime.now();
        admin.registrarEntidad(guardaparques, g);
    }

    public void ingresarVisitantes(ReservaNatural reserva) {
        List<Entidad> visitantes = reserva.visitantes;
        AdminVisitante admin = AdminVisitante.getInstance();
        Visitante vt = (Visitante) admin.nuevaEntidad();
        vt.nombres = "Mayo";
        vt.apellidos = "Nesa";
        vt.cedula = "1231231231";
        vt.direccion = "Ambato";
        vt.ruc = "0019901801";
        vt.telefono = "9089238576";
        admin.registrarEntidad(visitantes, vt);

        vt = (Visitante) admin.nuevaEntidad();
        vt.nombres = "Elisa";
        vt.apellidos = "Moserrat";
        vt.cedula = "7685769485";
        vt.direccion = "Quito";
        vt.ruc = "000978968";
        vt.telefono = "0987987908";
        admin.registrarEntidad(visitantes, vt);

        vt = (Visitante) admin.nuevaEntidad();
        vt.nombres = "Karen";
        vt.apellidos = "Ruiz";
        vt.cedula = "8475837590";
        vt.direccion = "Guayaquil";
        vt.ruc = "0029129212";
        vt.telefono = "6758945675";
        admin.registrarEntidad(visitantes, vt);
    }
}
