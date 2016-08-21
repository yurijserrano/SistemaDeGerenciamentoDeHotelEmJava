package hotel;

import java.time.LocalDate;

/**
 *
 * @author Yuri Serrano
 */
public class Reserva {
    
    private int reservaId;
    private int clienteId;
    private int quartoId;
    private LocalDate inicio;
    private LocalDate fim;
    
    public Reserva() {
        
    }
    
    public Reserva (int clienteId, int quartoId, LocalDate inicio, LocalDate fim) {
        this.clienteId = clienteId;
        this.quartoId = quartoId;
        this.inicio = inicio;
        this.fim = fim;
    }

    public int getReservaId() {
        return reservaId;
    }

    public void setReservaId(int reservaId) {
        this.reservaId = reservaId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getQuartoId() {
        return quartoId;
    }

    public void setQuartoId(int quartoId) {
        this.quartoId = quartoId;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getFim() {
        return fim;
    }

    public void setFim(LocalDate fim) {
        this.fim = fim;
    }
    
}
