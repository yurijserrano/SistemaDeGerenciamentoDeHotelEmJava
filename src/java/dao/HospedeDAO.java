package dao;

import hotel.Data;
import hotel.Hospede;
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
public class HospedeDAO {
    
    private Connection connection;

    protected static final String CAMPOS = "cliente_id,quarto_id, nome, endereco, email";
    protected static final String INSERT_SQL = "insert into rede.hospedes ("
            + CAMPOS + ") values (?, ?, ?, ?, ?)";
    protected static final String SELECT_SQL = "select hospede_id, " + CAMPOS
            + " from rede.hospedes where nome = ?";
    protected static final String SELECT_ALL_SQL = "select * from rede.hospedes";
    protected static final String UPDATE_SQL = "update rede.hospedes"
            + " set cliente_id = ?, quarto_id = ?, nome = ?, endereco = ?, email = ?"
            + " where hospede_id = ?";
    protected static final String DELETE_SQL
            = "delete from rede.hospedes where hospede_id = ?";

    public HospedeDAO() {

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

    public void create(Hospede hospede)
            throws DAOException {
        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(INSERT_SQL);
            prepStmt.setLong(1, hospede.getClienteId());
            prepStmt.setLong(2, hospede.getQuartoId());
            prepStmt.setString(3, hospede.getNome());
            prepStmt.setString(4, hospede.getEndereco());
            prepStmt.setString(5, hospede.getEmail());
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
    }

    public Hospede read(String nome)
            throws DAOException {
        Hospede hospede = null;

        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(SELECT_SQL);
            prepStmt.setString(1, nome);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                hospede = new Hospede();
                hospede.setHospedeId(rs.getLong(1));
                hospede.setClienteId(rs.getLong(2));
                hospede.setQuartoId(rs.getLong(2));
                hospede.setNome(rs.getString(3));
                hospede.setEndereco(rs.getString(4));
                hospede.setEmail(rs.getString(5));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return hospede;
    }
    
    public Hospede read(long hospedeId)
            throws DAOException {
        Hospede hospede = null;
        try {
            connection = getConnection();
            String query = "select hospede_id, " + CAMPOS +
                            " from rede.hospedes where hospede_id = ?";
            PreparedStatement prepStmt = connection.prepareStatement(SELECT_SQL);
            prepStmt.setLong(1, hospedeId);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                hospede = new Hospede();
                hospede.setHospedeId(rs.getLong(1));
                hospede.setClienteId(rs.getLong(2));
                hospede.setQuartoId(rs.getLong(3));
                hospede.setNome(rs.getString(4));
                hospede.setEndereco(rs.getString(5));
                hospede.setEmail(rs.getString(6));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return hospede;
    }

    public List<Hospede> readAll() throws DAOException {
        ArrayList<Hospede> hospedes = new ArrayList<>();

        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(SELECT_ALL_SQL);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                Hospede hospede = new Hospede();
                hospede.setHospedeId(rs.getLong(1));
                hospede.setClienteId(rs.getLong(2));
                hospede.setQuartoId(rs.getLong(3));
                hospede.setNome(rs.getString(4));
                hospede.setEndereco(rs.getString(5));
                hospede.setEmail(rs.getString(6));
                hospedes.add(hospede);
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return hospedes;
    }

    public void update(Hospede hospede)
            throws DAOException {
        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(UPDATE_SQL);
            prepStmt.setLong(1, hospede.getClienteId());
            prepStmt.setLong(2, hospede.getQuartoId());
            prepStmt.setString(3, hospede.getNome());
            prepStmt.setString(4, hospede.getEndereco());
            prepStmt.setString(5, hospede.getEmail());
            prepStmt.setLong(6, hospede.getHospedeId());
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

    public void delete(long hospedeId)
            throws DAOException {
        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(DELETE_SQL);
            prepStmt.setLong(1, hospedeId);
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
    }
    
    
    
    
}
