package reto3.appi.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto3.appi.Repository.Crud.InterfaceReservaciones;
import reto3.appi.Model.Reservaciones;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositirioReservaciones {
    @Autowired
    private InterfaceReservaciones crud4;

    public List<Reservaciones> getAll(){

        return (List<Reservaciones>) crud4.findAll();
    }

    public Optional<Reservaciones> getReservation(int id){

        return crud4.findById(id);
    }

    public Reservaciones save(Reservaciones reservation){

        return crud4.save(reservation);
    }
    public void delete(Reservaciones reservation){

        crud4.delete(reservation);
    }

}
