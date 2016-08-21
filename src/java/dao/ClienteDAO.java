package dao;

import hotel.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Yuri Serrano
 */

public class ClienteDAO {

    private Connection connection;

    protected static final String CAMPOS = "nome, endereco, email, senha";
    protected static final String INSERT_SQL = "insert into rede.clientes ("
            + CAMPOS + ") values (?, ?, ?, ?)";
    protected static final String SELECT_SQL = "select cliente_id, " + CAMPOS
            + " from rede.clientes where nome = ?";
    protected static final String SELECT_SQL_1 = "select cliente_id, " + CAMPOS
            + " from rede.clientes where email = ?";
       protected static final String SELECT_SQL_2 = "select cliente_id, " + CAMPOS
            + " from rede.clientes where senha = ?";
    protected static final String SELECT_ALL_SQL = "select * from rede.clientes";
    protected static final String UPDATE_SQL = "update rede.clientes"
            + " set nome = ?, endereco = ?, email = ?, senha = ?"
            + " where cliente_id = ?";
    protected static final String DELETE_SQL
            = "delete from rede.clientes where cliente_id = ?";

    public ClienteDAO() {

    }

    public Connection getConnection()
            throws SQLException {
        return DriverManager.getConnection(
                "jdbc:derby://localhost:1527/projetolp2", "rede", "rede");
    }

    public void closeConnection()
            throws DAOException {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                throw new DAOException(ex.getMessage());
            }
        }
    }

    public void create(Cliente cliente)
            throws DAOException {
        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(INSERT_SQL);
            prepStmt.setString(1, cliente.getNome());
            prepStmt.setString(2, cliente.getEndereco());
            prepStmt.setString(3, cliente.getEmail());
            prepStmt.setString(4, cliente.getSenha());
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
    }

    public Cliente read(String nome)
            throws DAOException {
        Cliente cliente = null;

        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(SELECT_SQL);
            prepStmt.setString(1, nome);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setClienteId(rs.getInt(1));
                cliente.setNome(rs.getString(2));
                cliente.setEndereço(rs.getString(3));
                cliente.setEmail(rs.getString(4));
                cliente.setSenha(rs.getString(5));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return cliente;
    }
    
    public Cliente readSenha(String senha)
            throws DAOException {
        Cliente cliente = null;

        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(SELECT_SQL_2);
            prepStmt.setString(1, senha);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setClienteId(rs.getInt(1));
                cliente.setNome(rs.getString(2));
                cliente.setEndereço(rs.getString(3));
                cliente.setEmail(rs.getString(4));
                cliente.setSenha(rs.getString(5));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return cliente;
    }
    
    public Cliente readEmail(String email)
            throws DAOException {
     
            Cliente cliente =null;
        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(SELECT_SQL_1);
            prepStmt.setString(1, email);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setClienteId(rs.getInt(1));
                cliente.setNome(rs.getString(2));
                cliente.setEndereço(rs.getString(3));
                cliente.setEmail(rs.getString(4));
                cliente.setSenha(rs.getString(5));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return cliente;
    }
    
    public Cliente read(long cliente_id)
            throws DAOException {
        Cliente cliente = null;
        try {
            connection = getConnection();
            String query = "select cliente_id, " + CAMPOS +
                            " from rede.clientes where cliente_id = ?";
            PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt.setLong(1, cliente_id);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setClienteId(rs.getInt(1));
                cliente.setNome(rs.getString(2));
                cliente.setEndereço(rs.getString(3));
                cliente.setEmail(rs.getString(4));
                cliente.setSenha(rs.getString(5));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return cliente;
    }

    public List<Cliente> readAll() throws DAOException {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(SELECT_ALL_SQL);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setClienteId(rs.getInt(1));
                cliente.setNome(rs.getString(2));
                cliente.setEndereço(rs.getString(3));
                cliente.setEmail(rs.getString(4));
                cliente.setSenha(rs.getString(5));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return clientes;
    }

    public void update(Cliente cliente)
            throws DAOException {
        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(UPDATE_SQL);
            prepStmt.setString(1, cliente.getNome());
            prepStmt.setString(2, cliente.getEndereco());
            prepStmt.setString(3, cliente.getEmail());
            prepStmt.setString(4, cliente.getSenha());
            prepStmt.setLong(5, cliente.getClienteId());
            int rowCount = prepStmt.executeUpdate();
            prepStmt.close();
            if (rowCount == 0) {
                throw new DAOException("Update não afetou nenhum registro.");
            }
        } catch (SQLException | DAOException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
    }
    
    

    public void delete(long usuarioId) throws DAOException {

        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(DELETE_SQL);
            prepStmt.setLong(1, usuarioId);
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
    }
}
