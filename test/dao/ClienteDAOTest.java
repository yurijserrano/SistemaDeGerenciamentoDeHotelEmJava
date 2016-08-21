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
public class ClienteDAOTest {
    
    private ClienteDAO dao;
    
    @Before
    public void setup() {
        dao = new ClienteDAO();
    }

    @Test
    public void testCreate() throws Exception {
//        Cliente cliente = new Cliente("Zulmira", "R. Alagoas, 237, Higienopolis",
//                                        "zulala@uol.com.br");
//        dao.create(cliente);
    }

    @Test
    public void testRead() throws Exception {
//        Cliente cliente = dao.read("Jovi");
//        System.out.println(cliente.getClienteId());
//        System.out.println(cliente.getNome());
//        System.out.println(cliente.getEndereço());
//        System.out.println(cliente.getEmail());
    }

    @Test
    public void testReadAll() throws Exception {
//        List<Cliente> clientes = dao.readAll();
//        for (Cliente cliente : clientes) {
//            System.out.println(cliente.getClienteId());
//            System.out.println(cliente.getNome());
//            System.out.println(cliente.getEndereço());
//            System.out.println(cliente.getEmail());
//        }
        
        
    }

    @Test
    public void testUpdate() throws Exception {
//        Cliente cliente = dao.read("Jovi");
//        cliente.setNome("João Vitor");
//        dao.update(cliente);
    }

    @Test
    public void testDelete() throws Exception {
//        dao.delete(6);
//        dao.delete(8);
//        dao.delete(9);
//        dao.delete(6);
        
    }
    
}
