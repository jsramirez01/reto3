package reto3.appi.Repository.Crud;

import org.springframework.data.repository.CrudRepository;
import reto3.appi.Model.Mensaje;

public interface InterfaceMensaje extends CrudRepository<Mensaje,Integer> {
}
