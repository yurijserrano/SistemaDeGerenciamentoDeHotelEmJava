/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import hotel.Funcionario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Serrano
 */
public class FuncionarioDAO {
    
     private Connection connection;

    protected static final String CAMPOS = "nome,cargo,endereco,email,senha,nivel_acesso";
    protected static final String INSERT_SQL = "insert into rede.funcionarios ("
            + CAMPOS + ") values (?, ?, ?, ?, ?, ?)";
    protected static final String SELECT_SQL = "select funcionario_id, " + CAMPOS
            + " from rede.funcionarios where nome = ?";
        protected static final String SELECT_SQL_1 = "select funcionario_id, " + CAMPOS
            + " from rede.funcionarios where email = ?";
         protected static final String SELECT_SQL_2 = "select funcionario_id, " + CAMPOS
            + " from rede.funcionarios where senha = ?";
    
    protected static final String SELECT_ALL_SQL = "select * from rede.funcionarios";
    protected static final String UPDATE_SQL = "update rede.funcionarios"
            + " set nome = ?, cargo = ?, endereco = ?, email = ?, senha = ?, nivel_acesso =? "
            + " where funcionario_id = ?";
    protected static final String DELETE_SQL
            = "delete from rede.funcionarios where funcionario_id = ?";

    public FuncionarioDAO() {

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

    public void create(Funcionario funcionario)
            throws DAOException {
        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(INSERT_SQL);
            prepStmt.setString(1, funcionario.getNome());
            prepStmt.setString(2, funcionario.getCargo());
            prepStmt.setString(3, funcionario.getEndereco());
            prepStmt.setString(4, funcionario.getEmail());
            prepStmt.setString(5, funcionario.getSenha());
            prepStmt.setInt(6, funcionario.getNivel_acesso());
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
    }

    public Funcionario read(String nome)
            throws DAOException {
        Funcionario funcionario = null;

        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(SELECT_SQL);
            prepStmt.setString(1, nome);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setFuncionarioId(rs.getInt(1));
                funcionario.setNome(rs.getString(2));
                funcionario.setCargo(rs.getString(3));
                funcionario.setEndereco(rs.getString(4));
                funcionario.setEmail(rs.getString(5));
                funcionario.setSenha(rs.getString(6));
                funcionario.setNivel_acesso(rs.getInt(7));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return funcionario;
    }
    
     public Funcionario readEmail(String email)
            throws DAOException {
        Funcionario funcionario = null;

        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(SELECT_SQL_1);
            prepStmt.setString(1, email);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setFuncionarioId(rs.getInt(1));
                funcionario.setNome(rs.getString(2));
                funcionario.setCargo(rs.getString(3));
                funcionario.setEndereco(rs.getString(4));
                funcionario.setEmail(rs.getString(5));
                funcionario.setSenha(rs.getString(6));
                funcionario.setNivel_acesso(rs.getInt(7));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return funcionario;
    }
     
     public Funcionario readSenha(String senha)
            throws DAOException {
        Funcionario funcionario = null;

        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(SELECT_SQL_2);
            prepStmt.setString(1, senha);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setFuncionarioId(rs.getInt(1));
                funcionario.setNome(rs.getString(2));
                funcionario.setCargo(rs.getString(3));
                funcionario.setEndereco(rs.getString(4));
                funcionario.setEmail(rs.getString(5));
                funcionario.setSenha(rs.getString(6));
                funcionario.setNivel_acesso(rs.getInt(7));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return funcionario;
    }
    
    public Funcionario read(long funcionario_id)
            throws DAOException {
        Funcionario funcionario = null;
        try {
            connection = getConnection();
            String query = "select funcionario_id, " + CAMPOS +
                            " from rede.funcionarios where funcionario_id = ?";
            PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt.setLong(1, funcionario_id);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                funcionario= new Funcionario();
                funcionario.setFuncionarioId(rs.getInt(1));
                funcionario.setNome(rs.getString(2));
                funcionario.setCargo(rs.getString(3));
                funcionario.setEndereco(rs.getString(4));
                funcionario.setEmail(rs.getString(5));
                funcionario.setSenha(rs.getString(6));
                funcionario.setNivel_acesso(rs.getInt(7));
                
                
                
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return funcionario;
    }

    public List<Funcionario> readAll() throws DAOException {
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(SELECT_ALL_SQL);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setFuncionarioId(rs.getInt(1));
                funcionario.setNome(rs.getString(2));
                funcionario.setCargo(rs.getString(3));
                funcionario.setEndereco(rs.getString(4));
                funcionario.setEmail(rs.getString(5));
                funcionario.setSenha(rs.getString(6));
                funcionario.setNivel_acesso(rs.getInt(7));
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            closeConnection();
        }
        return funcionarios;
    }

    public void update(Funcionario funcionario)
            throws DAOException {
        try {
            connection = getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(UPDATE_SQL);
            prepStmt.setString(1, funcionario.getNome());
            prepStmt.setString(2, funcionario.getCargo());
            prepStmt.setString(3, funcionario.getEndereco());
            prepStmt.setString(4, funcionario.getEmail());
            prepStmt.setString(5, funcionario.getSenha());
            prepStmt.setInt(6, funcionario.getNivel_acesso());
            prepStmt.setLong(7, funcionario.getFuncionarioId());
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

    

