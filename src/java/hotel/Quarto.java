/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hotel;

/**
 *
 * @author Yuri Serrano
 */
public class Quarto {
    
    private long quartoId;
    private long hotelId;
    private TipoDeQuarto tipo;
    
    public Quarto() {
        
    }
    
    public Quarto (long hotelId, String tipo) {
        this.hotelId = hotelId;
        setTipo(tipo);
    }

    public long getQuartoId() {
        return quartoId;
    }

    public void setQuartoId(long quartoId) {
        this.quartoId = quartoId;
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public String getTipo() {
        return tipo.getCategoria();
    }

    public final void setTipo(String tipoQuarto) {
        tipoQuarto = tipoQuarto.toLowerCase();
        switch(tipoQuarto) {
            case "padrao":
                tipo = new QuartoPadrao();
                break;
            case "executivo":
                tipo = new QuartoExecutivo();
                break;
            case "luxo":
                tipo = new QuartoLuxo();
        }
    }
    
    public double getDiaria() {
        return tipo.getDiaria();
    }

}
