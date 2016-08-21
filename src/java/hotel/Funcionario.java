/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hotel;

/**
 *
 * @author Serrano
 */
public class Funcionario {

   
    
    
    
    
    private int  funcionarioId;
    private String nome;
    private String cargo;    
    private String endereco;
    private String email;
    private String senha;
    private int nivel_acesso;
    
    
    
    
    public Funcionario()
    {
        
    }
    
     public Funcionario(String nome, String cargo, String endereco, String email, String senha,int acesso) {
        this.nome = nome;
        this.cargo = cargo;
        this.endereco = endereco;
        this.email = email;
        this.senha = senha;
        this.nivel_acesso=acesso;
    }
     
     
      public int getNivel_acesso() {
        return nivel_acesso;
    }

    public void setNivel_acesso(int nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }

    public int getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
    
}
