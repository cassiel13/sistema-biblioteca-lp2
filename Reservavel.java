package src;

public interface Reservavel {
    void reservar();
    void cancelarReserva();

    boolean getReservado();
    void setReservado(boolean newValue);
}
