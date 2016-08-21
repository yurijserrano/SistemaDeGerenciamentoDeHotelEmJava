/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hotel;

import java.time.LocalDate;

/**
 *
 * @author Yuri Serrano
 */
public class Estadia {
    
    private long estadiaId;
    private long hospedeId;
    private long quartoId;
    private LocalDate inicio;
    private LocalDate fim;
    
    public Estadia() {
        
    }
    
    public Estadia(long hospedeId, long quartoId, LocalDate inicio) {
        this.hospedeId = hospedeId;
        this.quartoId = quartoId;
        this.inicio = inicio;
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

    public void setHospedeId(long hospedeId) {
        this.hospedeId = hospedeId;
    }

    public long getQuartoId() {
        return quartoId;
    }

    public void setQuartoId(long quartoId) {
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
