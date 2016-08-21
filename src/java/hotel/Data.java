package hotel;

import java.time.LocalDate;

/**
 *
 * @author Yuri Serrano
 */
public class Data {

    private String hotel;
    private String cliente;
    private String tipo;
    private String hospede;
    private long hotelId;
    private long quartoId;
    private long reservaId;
    private long estadiaId;  
    private long hospedeId;
    private LocalDate inicio;
    private LocalDate fim;
    

    public Data() {

    }
    
    public long getEstadiaId() {
        return estadiaId;
    }

    public void setEstadiaId(long estadiaId) {
        this.estadiaId = estadiaId;
    }
    
      public long getHospedeId() {
        return hospedeId;
    }

    public String getHospede() {
        return hospede;
    }

    public void setHospede(String hospede) {
        this.hospede = hospede;
    }
      
      

    public void setHospedeId(long hospedeId) {
        this.hospedeId = hospedeId;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }
    
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public long getQuartoId() {
        return quartoId;
    }

    public void setQuartoId(long quartoId) {
        this.quartoId = quartoId;
    }

    public long getReservaId() {
        return reservaId;
    }

    public void setReservaId(long reservaId) {
        this.reservaId = reservaId;
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
