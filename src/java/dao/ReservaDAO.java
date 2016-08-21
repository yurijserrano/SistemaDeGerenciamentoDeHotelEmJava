package dao;

import hotel.Data;
import hotel.Reserva;
import java.sql.Connection;
import java.sql.Date;
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

public class ReservaDAO {

    private Connection connection;

    protected static final String CAMPOS = "cliente_id, quarto_id, inicio, fim";
    protected static final String INSERT_SQL = "insert into rede.reservas (" + CAMPOS
            + ") values (?, ?, ?, ?)";
    protected static final String SELECT_SQL = "select reserva_id, " + CAMPOS
            + " from rede.reservas where reserva_id = ?";
    protected static final String SELECT_ALL_SQL = "select * from rede.reservas";
    protected static final String UPDATE_SQL = "update rede.reservas"
            + " set cliente_id = ?, quarto_id = ?, inicio = ?, fim = ?"
            + " where reserva_Id = ?";
    protected static final String DELETE_SQL
            = "delete from rede.reservas where reserva_Id = ?";

    public ReservaDAO() {

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

    public int create(Reserva reserva)
            throws DAOException {
        int key = 0;
        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(INSERT_SQL, 
                    new String[] {"reserva_id"});
            prepStmt.setInt(1, reserva.getClienteId());
            prepStmt.setInt(2, reserva.getQuartoId());
            prepStmt.setDate(3, Date.valueOf(reserva.getInicio()));
            prepStmt.setDate(4, Date.valueOf(reserva.getFim()));
            prepStmt.executeUpdate();
            ResultSet rs = prepStmt.getGeneratedKeys();
            if (rs != null && rs.next()) {
                key = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return key;
    }
    
    
    public List<Reserva> readAll(String nome)
            throws DAOException {
        ArrayList<Reserva> reservas = new ArrayList<>();
        Reserva reserva =null;
        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(SELECT_ALL_SQL);
             prepStmt.setString(1, nome);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                reserva = new Reserva();
                reserva.setReservaId(rs.getInt(1));
                reserva.setClienteId(rs.getInt(2));
                reserva.setQuartoId(rs.getInt(3));
                reserva.setInicio(rs.getDate(4).toLocalDate());
                reserva.setFim(rs.getDate(5).toLocalDate());
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return reservas;
    }

    public Reserva read(long reservaId)
            throws DAOException {
        Reserva reserva = null;
        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(SELECT_SQL);
            prepStmt.setLong(1, reservaId);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                reserva = new Reserva();
                reserva.setReservaId(rs.getInt(1));
                reserva.setClienteId(rs.getInt(2));
                reserva.setQuartoId(rs.getInt(3));
                reserva.setInicio(rs.getDate(4).toLocalDate());
                reserva.setFim(rs.getDate(5).toLocalDate());
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return reserva;
    }

    public List<Reserva> readAll()
            throws DAOException {
        ArrayList<Reserva> reservas = new ArrayList<>();
        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(SELECT_ALL_SQL);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setReservaId(rs.getInt(1));
                reserva.setClienteId(rs.getInt(2));
                reserva.setQuartoId(rs.getInt(3));
                reserva.setInicio(rs.getDate(4).toLocalDate());
                reserva.setFim(rs.getDate(5).toLocalDate());
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return reservas;
    }

    public void update(Reserva reserva)
            throws DAOException {
        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(UPDATE_SQL);
            prepStmt.setLong(1, reserva.getClienteId());
            prepStmt.setLong(2, reserva.getQuartoId());
            prepStmt.setDate(3, Date.valueOf(reserva.getInicio()));
            prepStmt.setDate(4, Date.valueOf(reserva.getFim()));
            prepStmt.setLong(5, reserva.getReservaId());
            int rowCount = prepStmt.executeUpdate();
            prepStmt.close();
            if (rowCount == 0) {
                throw new DAOException("Update não afetou nenhum registro.");
            }
        } catch (DAOException | SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
    }

    public void delete(long reserva_Id) throws DAOException {
        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(DELETE_SQL);
            prepStmt.setLong(1, reserva_Id);
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
    }
    
    public List<Data> getData()
            throws DAOException {
        ArrayList<Data> dados = new ArrayList<Data>();
        Data data;
        try {
            connection = getConnection();
            String query = "SELECT Reservas.reserva_id, Reservas.quarto_id, " +
                    "Reservas.inicio, Reservas.fim, Clientes.nome " +
                    "FROM Reservas " +
                    "INNER JOIN Clientes " +
                    "ON Reservas.cliente_id = Clientes.cliente_id " +
                    "ORDER BY reserva_id";
            PreparedStatement prepStmt = connection.prepareStatement(query);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                data = new Data();
                data.setReservaId(rs.getLong(1));
                data.setQuartoId(rs.getLong(2));
                data.setInicio(rs.getDate(3).toLocalDate());
                data.setFim(rs.getDate(4).toLocalDate());
                data.setCliente(rs.getString(5));
                dados.add(data);
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return dados;
    }
    
}
