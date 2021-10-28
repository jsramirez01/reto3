package reto3.appi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioMensaje {
    @Autowired
    private  RepositorioMensaje metodoCrud;

    public List<Mensaje> getAll(){
        return metodoCrud.getAll();
    }

    public Optional<Mensaje> getMessage(int messageId){
        return metodoCrud.getMessage(messageId);
    }

    public Mensaje save(Mensaje message){
        if (message.getIdMessage()==null){
            return metodoCrud.save(message);
        }
        else {
            Optional<Mensaje> e = metodoCrud.getMessage(message.getIdMessage());
            if (e.isEmpty()){
                return metodoCrud.save(message);
            }
            else{
                return message;
            }
        }
    }

    //pasar una capa de seguridad
    public Mensaje update(Mensaje messge){
        if (messge.getIdMessage()!=null){
            Optional<Mensaje> e= metodoCrud.getMessage(messge.getIdMessage());
            if (!e.isEmpty()){
                if (messge.getMessageText()!=null){
                    e.get().setMessageText(messge.getMessageText());
                }
                metodoCrud.save(e.get());
                return e.get();
            }
            else {
                return messge;
            }
        }else {
            return messge;
        }
    }

    public boolean deleteMessage(int messageId){
        Boolean aBoolean = getMessage(messageId).map(message -> {
            metodoCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
