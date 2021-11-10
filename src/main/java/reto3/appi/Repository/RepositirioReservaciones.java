package reto3.appi.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto3.appi.Model.Cliente;
import reto3.appi.Reportes.ContadorClientes;
import reto3.appi.Repository.Crud.InterfaceReservaciones;
import reto3.appi.Model.Reservaciones;

import java.util.ArrayList;
import java.util.Date;
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

    public List<Reservaciones> ReservacionStatus(String status){
        return crud4.findAllByStatus(status);
    }

    public List<Reservaciones> ReservacionTiempo (Date a, Date b) {
        return crud4.findAllByStartDateAfterAndStartDateBefore(a, b);
    }

    public List<ContadorClientes> getTopClientes(){
        List<ContadorClientes> res=new ArrayList<>();
        List<Object[]>report = crud4.countTotalReservationsByClient();
        for(int i=0; i<report.size();i++){
            res.add(new ContadorClientes((Long)report.get(i)[1],(Cliente) report.get(i)[0]));

        }
        return res;
    }

}
