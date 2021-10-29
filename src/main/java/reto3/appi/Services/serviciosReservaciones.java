package reto3.appi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto3.appi.Model.Reservaciones;
import reto3.appi.Repository.RepositirioReservaciones;

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
        if (resevation.getIdReservations()==null){
            return metodoCrud.save(resevation);
        }
        else {
            Optional<Reservaciones> e = metodoCrud.getReservation(resevation.getIdReservations());
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
        if (reservation.getIdReservations()!=null){
            Optional<Reservaciones> e= metodoCrud.getReservation(reservation.getIdReservations());
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
}
