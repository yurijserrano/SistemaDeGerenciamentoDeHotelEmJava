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
public class HotelDaoTest {
    
    private HotelDAO dao;
    
    @Before
    public void setup() {
        dao = new HotelDAO();
    }

    @Test
    public void testCreate() throws Exception {
//        Hotel hotel1 = new Hotel("Max Hotel", "Av. Naçoes Unidas, 1052");
//        Hotel hotel2 = new Hotel("Novo Hotel", "Av. Paulista, 2374");
//        Hotel hotel3 = new Hotel("Formule Two", "Av. Berrini, 378");
//        dao.create(hotel1);
//        dao.create(hotel2);
//        dao.create(hotel3);
    }

    @Test
    public void testRead() throws Exception {
//        Hotel hotel = dao.read("Sheraton");
//        System.out.println(hotel.getHotelId());
//        System.out.println(hotel.getNome());
//        System.out.println(hotel.getEndereço());
    }

    @Test
    public void testReadAll() throws Exception {
//        List<Hotel> hoteis = dao.readAll();
//        for (Hotel hotel : hoteis) {
//            System.out.println(hotel.getHotelId());
//            System.out.println(hotel.getNome());
//            System.out.println(hotel.getEndereço());
//        }
    }

    @Test
    public void testUpdate() throws Exception {
//        Hotel hotel = dao.read("Sheraton");
//        hotel.setEndereço("Av. Angelica, 1094");
//        dao.update(hotel);
    }

    @Test
    public void testDelete() throws Exception {
//        dao.delete(2);
    }
    
}
