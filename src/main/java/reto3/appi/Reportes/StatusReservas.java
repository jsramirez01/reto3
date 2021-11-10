package reto3.appi.Reportes;

//Pasar a pilar se crea la nueva clase con el paquete de reportes
public class StatusReservas {
    private int completed;
    private int cancelled;

    //controlador
    public StatusReservas(int completed, int cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }
    //getter y sether pasa a pilar
    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public int getCancelled() {
        return cancelled;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }
}
