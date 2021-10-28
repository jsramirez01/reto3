package reto3.appi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosClientes {

    @Autowired
    private  RepositorioCliente metodoCrud;

    public List<Cliente> getAll(){
        return metodoCrud.getAll();
    }

    public Optional<Cliente> getClient(int clientId){
        return metodoCrud.getCliente(clientId);
    }

    public Cliente save(Cliente client){
        if (client.getIdClient()==null){
            return metodoCrud.save(client);
        }
        else {
            Optional<Cliente> e = metodoCrud.getCliente(client.getIdClient());
            if (e.isEmpty()){
                return metodoCrud.save(client);
            }
            else{
                return client;
            }
        }
    }

    //pasar una capa de seguridad
    public Cliente update(Cliente client){
        if (client.getIdClient()!=null){
            Optional<Cliente> e= metodoCrud.getCliente(client.getIdClient());
            if (!e.isEmpty()){
                if (client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if (client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if (client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                metodoCrud.save(e.get());
                return e.get();
            }
            else {
                return client;
            }
        }else {
            return client;
        }
    }

    public boolean deleteClient(int clientId){
        Boolean aBoolean = getClient(clientId).map(client -> {
         metodoCrud.delete(client);
         return true;
        }).orElse(false);
        return aBoolean;
    }

}
