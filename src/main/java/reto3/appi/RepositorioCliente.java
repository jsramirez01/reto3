package reto3.appi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioCliente {
    @Autowired
    private InterfaceCliente crud2;

    public List<Cliente> getAll(){

        return (List<Cliente>) crud2.findAll();
    }
    public Optional<Cliente> getCliente(int id){

        return crud2.findById(id);
    }
    public Cliente save(Cliente cliente){

        return crud2.save(cliente);
    }
    public void delete(Cliente cliente){
        crud2.delete(cliente);
    }

}
