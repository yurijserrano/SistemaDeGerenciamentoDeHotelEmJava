package dao;

import hotel.Hotel;
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

public class HotelDAO {

    private Connection connection;

    protected static final String CAMPOS = "nome, endereco";
    protected static final String INSERT_SQL = "insert into rede.hoteis ("
            + CAMPOS + ") values (?, ?)";
    protected static final String SELECT_SQL = "select hotel_id, " + CAMPOS
            + " from rede.hoteis where nome = ?";
    protected static final String SELECT_ALL_SQL = "select * from rede.hoteis";
    protected static final String UPDATE_SQL = "update rede.hoteis "
            + "set nome = ?, endereco = ? "
            + "where hotel_id = ?";
    protected static final String DELETE_SQL
            = "delete from rede.hoteis where hotel_id = ?";

    public HotelDAO() {

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

    public void create(Hotel hotel) throws DAOException {
        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(INSERT_SQL);
            prepStmt.setString(1, hotel.getNome());
            prepStmt.setString(2, hotel.getEndereço());
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
    }

    public Hotel read(String nome) throws DAOException {
        Hotel hotel = null;

        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(SELECT_SQL);
            prepStmt.setString(1, nome);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                hotel = new Hotel();
                hotel.setHotelId(rs.getLong(1));
                hotel.setNome(rs.getString(2));
                hotel.setEndereço(rs.getString(3));
            }

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return hotel;
    }
    
    public Hotel read(long id) throws DAOException {
        Hotel hotel = null;

        try {
            connection = getConnection();
            String query = "select hotel_id, " + CAMPOS +
                            " from rede.hoteis where hotel_id = ?";
            PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt.setLong(1, id);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                hotel = new Hotel();
                hotel.setHotelId(rs.getLong(1));
                hotel.setNome(rs.getString(2));
                hotel.setEndereço(rs.getString(3));
            }

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return hotel;
    }

    public List<Hotel> readAll() throws DAOException {
        ArrayList<Hotel> rede = new ArrayList<Hotel>();

        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(SELECT_ALL_SQL);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                Hotel hotel = new Hotel();
                hotel.setHotelId(rs.getLong(1));
                hotel.setNome(rs.getString(2));
                hotel.setEndereço(rs.getString(3));
                rede.add(hotel);
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return rede;
    }

    public void update(Hotel hotel) throws DAOException {
        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(UPDATE_SQL);
            prepStmt.setString(1, hotel.getNome());
            prepStmt.setString(2, hotel.getEndereço());
            prepStmt.setLong(3, hotel.getHotelId());
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

    public void delete(long hotelId) throws DAOException {

        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(DELETE_SQL);
            prepStmt.setLong(1, hotelId);
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
    }
}
