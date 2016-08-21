/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Yuri Serrano
 */
public class ReservaDAOTest {
    
    private ReservaDAO dao;
    
    @Before
    public void setup() {
        dao = new ReservaDAO();
    }

    @Test
    public void testCreate() throws Exception {
//        LocalDate inicio = LocalDate.of(2014, Month.JUNE, 10);
//        LocalDate fim = LocalDate.of(2014, Month.JUNE, 25);
//        Reserva reserva = new Reserva(6, 3, inicio, fim);
//        dao.create(reserva);
    }

    @Test
    public void testRead() throws Exception {
//        Reserva reserva = dao.read(1);
//        System.out.println("Quarto_Id = " + reserva.getQuartoId());
//        System.out.println("Cliente_Id = " + reserva.getClienteId());
//        System.out.println("Inicio: " + reserva.getInicio());
//        System.out.println("Fim: " + reserva.getFim());
    }

    @Test
    public void testReadAll() throws Exception {
//        List<Reserva> reservas = dao.readAll();
//        for (Reserva reserva : reservas) {
//            System.out.println("Quarto_Id = " + reserva.getQuartoId());
//            System.out.println("Cliente_Id = " + reserva.getClienteId());
//            System.out.println("Inicio: " + reserva.getInicio());
//            System.out.println("Fim: " + reserva.getFim());
//        }
    }

    @Test
    public void testUpdate() throws Exception {
//        Reserva reserva = dao.read(1);
//        reserva.setFim(LocalDate.of(2014, Month.MAY, 30));
//        dao.update(reserva);
    }

    @Test
    public void testDelete() throws Exception {
            dao.delete(17);
    }
    
}
