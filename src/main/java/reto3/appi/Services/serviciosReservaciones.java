package reto3.appi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto3.appi.Model.Reservaciones;
import reto3.appi.Reportes.ContadorClientes;
import reto3.appi.Reportes.StatusReservas;
import reto3.appi.Repository.RepositirioReservaciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class serviciosReservaciones {
    @Autowired
    private RepositirioReservaciones metodoCrud;

    public List<Reservaciones> getAll(){
        return metodoCrud.getAll();
    }

    public Optional<Reservaciones> getReservation(int reservationId){
        return metodoCrud.getReservation(reservationId);
    }

    public Reservaciones save(Reservaciones resevation){
        if (resevation.getIdReservation()==null){
            return metodoCrud.save(resevation);
        }
        else {
            Optional<Reservaciones> e = metodoCrud.getReservation(resevation.getIdReservation());
            if (e.isEmpty()){
                return metodoCrud.save(resevation);
            }
            else{
                return resevation;
            }
        }
    }

    //pasar una capa de seguridad
    public Reservaciones update(Reservaciones reservation){
        if (reservation.getIdReservation()!=null){
            Optional<Reservaciones> e= metodoCrud.getReservation(reservation.getIdReservation());
            if (!e.isEmpty()){
                if (reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                metodoCrud.save(e.get());
                return e.get();
            }
            else {
                return reservation;
            }
        }else {
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId){
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodoCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;

    }

    //nuevo methodo pasar a pilar completado y cancelado
    public StatusReservas getReporteStatusReservaciones(){
        List<Reservaciones>completed= metodoCrud.ReservacionStatus("completed");
        List<Reservaciones>cancelled= metodoCrud.ReservacionStatus("cancelled");
        return new StatusReservas(completed.size(), cancelled.size());
    }

    public List<Reservaciones> getReportesTiempoReservaciones(String datoA, String datoB){
        SimpleDateFormat parser=new SimpleDateFormat ("yyyy-MM-dd");
        Date datoUno = new Date();
        Date datoDos = new Date();

        try{
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return metodoCrud.ReservacionTiempo(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        }

    }
    public List<ContadorClientes> servicioTopClientes(){
        return metodoCrud.getTopClientes();
    }


}
