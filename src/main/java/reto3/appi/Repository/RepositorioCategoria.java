package reto3.appi.Repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto3.appi.Repository.Crud.InterfaceCategoria;
import reto3.appi.Model.Categoria;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioCategoria {

    @Autowired
    private InterfaceCategoria crud1;

    public List<Categoria> getAll(){

        return (List<Categoria>) crud1.findAll();
    }

    public Optional<Categoria> getCategoria(int id){

        return crud1.findById(id);
    }
    public Categoria save(Categoria Categoria){

        return crud1.save(Categoria);
    }
    public void delete(Categoria Categoria){

        crud1.delete(Categoria);
    }


}
