package dao;

import hotel.Data;
import hotel.Quarto;
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

public class QuartoDAO {

    private Connection connection;

    protected static final String CAMPOS = "hotel_id, tipo";
    protected static final String INSERT_SQL = "insert into rede.quartos (" + CAMPOS
            + ") values (?, ?)";
    protected static final String SELECT_SQL = "select quarto_id, " + CAMPOS
            + " from rede.quartos where quarto_id = ?";
    protected static final String SELECT_ALL_SQL = "select * from rede.quartos";
    protected static final String UPDATE_SQL = "update rede.quartos"
            + " set hotel_id = ?, tipo = ?"
            + " where quarto_id = ?";
    protected static final String DELETE_SQL
            = "delete from rede.quartos where quarto_id = ?";

    public QuartoDAO() {

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

    public void create(Quarto quarto)
            throws DAOException {
        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(INSERT_SQL);
            prepStmt.setLong(1, quarto.getHotelId());
            prepStmt.setString(2, quarto.getTipo());
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
    }

    public Quarto read(long quarto_Id)
            throws DAOException {
        Quarto quarto = null;
        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(SELECT_SQL);
            prepStmt.setLong(1, quarto_Id);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                quarto = new Quarto();
                quarto.setQuartoId(rs.getLong(1));
                quarto.setHotelId(rs.getLong(2));
                quarto.setTipo(rs.getString(3));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return quarto;
    }

    public List<Quarto> readAll() throws DAOException {
        ArrayList<Quarto> quartos = new ArrayList<>();
        Quarto quarto;

        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(SELECT_ALL_SQL);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                quarto = new Quarto();
                quarto.setQuartoId(rs.getLong(1));
                quarto.setHotelId(rs.getLong(2));
                quarto.setTipo(rs.getString(3));
                quartos.add(quarto);
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return quartos;
    }

    public void update(Quarto quarto)
            throws DAOException {
        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(UPDATE_SQL);
            prepStmt.setLong(1, quarto.getHotelId());
            prepStmt.setString(2, quarto.getTipo());
            prepStmt.setLong(3, quarto.getQuartoId());
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

    public void delete(long quarto_Id)
            throws DAOException {
        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(DELETE_SQL);
            prepStmt.setLong(1, quarto_Id);
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
    }
    
    public List<Data> getData()
            throws DAOException {
        ArrayList<Data> dados = new ArrayList<>();
        Data data;
        try {
            connection = getConnection();
            String query = "SELECT Hoteis.nome, Quartos.quarto_id, Quartos.tipo " +
                           "FROM Quartos " +
                           "INNER JOIN Hoteis " +
                           "ON Quartos.hotel_id = Hoteis.hotel_id";
            PreparedStatement prepStmt = connection.prepareStatement(query);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                data = new Data();
                data.setHotel(rs.getString(1));
                data.setQuartoId(rs.getLong(2));
                data.setTipo(rs.getString(3));
                dados.add(data);
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return dados;
    }
    
    public List<Quarto> getQuartosDisponiveis(Data pedido)
            throws DAOException {
        ArrayList<Quarto> quartos = new ArrayList<Quarto>();
        Quarto quarto;
        try {
            connection = getConnection();
            String query =  
                "SELECT * FROM Quartos WHERE hotel_id = ? AND tipo = ? AND quarto_id NOT IN " +
                "(SELECT quarto_id FROM Reservas WHERE NOT (inicio > ? OR fim < ?))";
            PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt.setLong(1, pedido.getHotelId());
            prepStmt.setString(2, pedido.getTipo());
            prepStmt.setDate(3, Date.valueOf(pedido.getFim()));
            prepStmt.setDate(4, Date.valueOf(pedido.getInicio()));
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                quarto = new Quarto();
                quarto.setQuartoId(rs.getLong(1));
                quarto.setHotelId(rs.getLong(2));
                quarto.setTipo(rs.getString(3));
                quartos.add(quarto);
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return quartos;
    }
    
    public List<Quarto> getQuartosAlternativosHotel(Data pedido)
            throws DAOException {
        ArrayList<Quarto> quartos = new ArrayList<Quarto>();
        Quarto quarto;
        try {
            connection = getConnection();
            String query =  
                "SELECT * FROM Quartos WHERE hotel_id = ? AND quarto_id NOT IN " +
                "(SELECT quarto_id FROM Reservas WHERE NOT (inicio > ? OR fim < ?))";
            PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt.setLong(1, pedido.getHotelId());
            prepStmt.setDate(2, Date.valueOf(pedido.getFim()));
            prepStmt.setDate(3, Date.valueOf(pedido.getInicio()));
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                quarto = new Quarto();
                quarto.setQuartoId(rs.getLong(1));
                quarto.setHotelId(rs.getLong(2));
                quarto.setTipo(rs.getString(3));
                quartos.add(quarto);
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return quartos;
    }
    
    public List<Quarto> getQuartosAlternativosRede(Data pedido)
            throws DAOException {
        ArrayList<Quarto> quartos = new ArrayList<>();
        Quarto quarto;
        try {
            connection = getConnection();
            String query =  
                "SELECT * FROM Quartos WHERE tipo = ? AND quarto_id NOT IN " +
                "(SELECT quarto_id FROM Reservas WHERE NOT (inicio > ? OR fim < ?))";
            PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt.setString(1, pedido.getTipo());
            prepStmt.setDate(2, Date.valueOf(pedido.getFim()));
            prepStmt.setDate(3, Date.valueOf(pedido.getInicio()));
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                quarto = new Quarto();
                quarto.setQuartoId(rs.getLong(1));
                quarto.setHotelId(rs.getLong(2));
                quarto.setTipo(rs.getString(3));
                quartos.add(quarto);
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return quartos;
    }
}
