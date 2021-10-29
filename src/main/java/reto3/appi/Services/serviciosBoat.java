package reto3.appi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto3.appi.Model.Boat;
import reto3.appi.Repository.RepositorioBoat;

import java.util.List;
import java.util.Optional;


@Service
public class serviciosBoat {
    @Autowired

    //se crea la variable para el RepositorioBike
    private RepositorioBoat metodoCrud;

    //Se llaman a todos los servicios
    public List<Boat>   getAll(){
        return metodoCrud.getAll();
    }

    //Se llama la informacion especifica de lo que se necesita consultar
    public Optional<Boat> getBoat(int boatId){
        return metodoCrud.getBoat(boatId);
    }

    //Se guarda la información
    public Boat save(Boat boat){
        if (boat.getId()==null){
            return metodoCrud.save(boat);
        }else{
            Optional<Boat> e=metodoCrud.getBoat(boat.getId());
            if (e.isEmpty()){
                return metodoCrud.save(boat);
            }else{
                return boat;
            }
        }
    }

    //Se actualiza la informacion
    public Boat update(Boat boat){
        if (boat.getId()!=null){
            Optional<Boat> e=metodoCrud.getBoat(boat.getId());
            if (!e.isEmpty()){
                if (boat.getName()!=null){
                    e.get().setName(boat.getName());
                }
                if(boat.getBrand()!=null){
                    e.get().setBrand(boat.getBrand());
                }
                if(boat.getYear()!=null){
                    e.get().setYear(boat.getYear());
                }
                if (boat.getDescription()!=null){
                    e.get().setDescription(boat.getDescription());
                }
                if (boat.getCategory()!=null){
                    e.get().setCategory(boat.getCategory());
                }
                metodoCrud.save(e.get());
                return e.get();
            }else{
                return boat;
            }

        }else{
            return boat;
        }
    }

    //eliminar la informacion exacta
    public boolean deleteBoat(int boatId){
        Boolean aBoolean = getBoat(boatId).map(boat -> {
            metodoCrud.delete(boat);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}