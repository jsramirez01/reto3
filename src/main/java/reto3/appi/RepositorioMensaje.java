package reto3.appi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioMensaje {
    @Autowired
    private InterfaceMensaje crud3;

    public List<Mensaje> getAll(){

        return (List<Mensaje>) crud3.findAll();
    }

    public Optional<Mensaje> getMessage(int id){

        return crud3.findById(id);
    }

    public Mensaje save(Mensaje message){
        return crud3.save(message);
    }
    public void delete(Mensaje message){

        crud3.delete(message);
    }

}
