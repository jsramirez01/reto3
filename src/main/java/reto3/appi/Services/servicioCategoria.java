package reto3.appi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto3.appi.Model.Categoria;
import reto3.appi.Repository.RepositorioCategoria;

import java.util.List;
import java.util.Optional;

@Service
public class servicioCategoria {
    @Autowired
    private RepositorioCategoria metodoCrud;

    public List<Categoria> getAll(){
        return metodoCrud.getAll();
    }

    public Optional<Categoria> getCategoria(int CategoriaId){
        return metodoCrud.getCategoria(CategoriaId);
    }

    public Categoria save(Categoria categoria){
        if (categoria.getId()==null){
            return metodoCrud.save(categoria);
        }
        else{
            Optional<Categoria> categoria1 = metodoCrud.getCategoria(categoria.getId());
            if (categoria1.isEmpty()){
                return metodoCrud.save(categoria);
            }
            else{
                return categoria;
            }
        }

    }

    public Categoria update(Categoria categoria){
        if (categoria.getId()!=null){
            Optional<Categoria>g=metodoCrud.getCategoria(categoria.getId());
            if(!g.isEmpty()){
                if (categoria.getDescription()!=null){
                    g.get().setDescription(categoria.getDescription());
                }
                if (categoria.getName()!=null){
                    g.get().setName(categoria.getName());
                }
                return metodoCrud.save(g.get());
            }
        }
        return categoria;
    }

    public boolean deleteCategoria(int categoriaId){
        Boolean d = getCategoria(categoriaId).map(categoria -> {
            metodoCrud.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }
}
