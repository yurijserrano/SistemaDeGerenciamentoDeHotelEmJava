/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hotel.Quarto;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Yuri Serrano
 */
public class QuartoDAOTest {

    private QuartoDAO dao;

    @Before
    public void setup() {
        dao = new QuartoDAO();
    }

    @Test
    public void testCreate() throws Exception {
        for (int i = 3; i <= 5; i++) {
            for (int j = 0; j < 10; j++) {
                Quarto quarto1 = new Quarto(i, "Padrao");
                dao.create(quarto1);
            }
            
            for (int j = 0; j < 6; j++) {
                Quarto quarto2 = new Quarto(i, "Executivo");
                dao.create(quarto2);
            }
            
            for (int j = 0; j < 4; j++) {
                Quarto quarto3 = new Quarto(i, "Luxo");
                dao.create(quarto3);
            }
        }
    }

    @Test
    public void testRead() throws Exception {
//        Quarto quarto = dao.read(2);
//        System.out.println(quarto.getQuartoId());
//        System.out.println(quarto.getHotelId());
//        System.out.println(quarto.getTipo());
    }

    @Test
    public void testReadAll() throws Exception {
//        List<Quarto> quartos = dao.readAll();
//        for (Quarto quarto: quartos) {
//            System.out.println(quarto.getQuartoId());
//            System.out.println(quarto.getHotelId());
//            System.out.println(quarto.getTipo());
//        }
    }

    @Test
    public void testUpdate() throws Exception {
//        Quarto quarto = dao.read(4);
//        quarto.setHotelId(3);
//        dao.update(quarto);
    }

    @Test
    public void testDelete() throws Exception {
//        for (int i = 5; i <= 64; i++)
//            dao.delete(i);

    }

}
