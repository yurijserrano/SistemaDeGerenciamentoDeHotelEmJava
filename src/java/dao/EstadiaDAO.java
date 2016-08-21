package dao;

import hotel.Data;
import hotel.Estadia;
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
public class EstadiaDAO {
    
    private Connection connection;

    protected static final String CAMPOS = "hospede_id, quarto_id, inicio, fim";
    protected static final String INSERT_SQL = "insert into rede.estadias (" + CAMPOS
            + ") values (?, ?, ?, ?)";
    protected static final String SELECT_SQL = "select estadia_id, " + CAMPOS
            + " from rede.estadias where estadia_id = ?";
    protected static final String SELECT_ALL_SQL = "select * from rede.estadias";
    protected static final String UPDATE_SQL = "update rede.estadias"
            + " set hospede_id = ?, quarto_id = ?, inicio = ?, fim = ?"
            + " where estadia_Id = ?";
    protected static final String DELETE_SQL
            = "delete from rede.estadias where estadia_Id = ?";

    public EstadiaDAO() {

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

    public void create(Estadia estadia)
            throws DAOException {
        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(INSERT_SQL);
            prepStmt.setLong(1, estadia.getHospedeId());
            prepStmt.setLong(2, estadia.getQuartoId());
            prepStmt.setDate(3, Date.valueOf(estadia.getInicio()));
            prepStmt.setDate(4, Date.valueOf(estadia.getFim()));
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
    }

    public Estadia read(long estadiaId)
            throws DAOException {
        Estadia estadia = null;
        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(SELECT_SQL);
            prepStmt.setLong(1, estadiaId);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                estadia = new Estadia();
                estadia.setEstadiaId(rs.getLong(1));
                estadia.setHospedeId(rs.getLong(2));
                estadia.setQuartoId(rs.getLong(3));
                estadia.setInicio(rs.getDate(4).toLocalDate());
                estadia.setFim(rs.getDate(5).toLocalDate());
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return estadia;
    }

    public List<Estadia> readAll()
            throws DAOException {
        ArrayList<Estadia> estadias = new ArrayList<>();
        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(SELECT_ALL_SQL);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                Estadia estadia = new Estadia();
                estadia.setEstadiaId(rs.getLong(1));
                estadia.setHospedeId(rs.getLong(2));
                estadia.setQuartoId(rs.getLong(3));
                estadia.setInicio(rs.getDate(4).toLocalDate());
                estadia.setFim(rs.getDate(5).toLocalDate());
                estadias.add(estadia);
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return estadias;
    }

    public void update(Estadia estadia)
            throws DAOException {
        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(UPDATE_SQL);
            prepStmt.setLong(1, estadia.getHospedeId());
            prepStmt.setLong(2, estadia.getQuartoId());
            prepStmt.setDate(3, Date.valueOf(estadia.getInicio()));
            prepStmt.setDate(4, Date.valueOf(estadia.getFim()));
            prepStmt.setLong(5, estadia.getEstadiaId());
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

    public void delete(long estadiaId)
            throws DAOException {
        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(DELETE_SQL);
            prepStmt.setLong(1, estadiaId);
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
            String query = "SELECT Estadias.estadia_id,Hospedes.nome,Estadias.quarto_id,Estadias.inicio,Estadias.fim " +
                           "FROM Estadias " +
                           "INNER JOIN Hospedes " +
                           "ON Estadias.hospede_id = Hospedes.hospede_id "+
                           "ORDER BY Estadias.estadia_id";
                           
            PreparedStatement prepStmt = connection.prepareStatement(query);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                data = new Data();
                data.setEstadiaId(rs.getInt(1));
                data.setHospede(rs.getString(2));
                data.setQuartoId(rs.getInt(3));
                data.setInicio(rs.getDate(4).toLocalDate());
                data.setFim(rs.getDate(5).toLocalDate());
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
