package hotel;

/**
 *
 * @author Yuri Serrano
 */
public class Hospede {
    
    private long hospedeId;
    private long clienteId;
    private long quartoId;    
    private String nome;
    private String endereco;
    private String email;
    
    public Hospede() {
     
    }
    
    public Hospede (Cliente cliente) {
        this.clienteId = cliente.getClienteId();
        this.nome = cliente.getNome();
        this.endereco = cliente.getEndereco();
        this.email = cliente.getEmail();
    }

    public long getQuartoId() {
        return quartoId;
    }

    public void setQuartoId(long quartoId) {
        this.quartoId = quartoId;
    }
    
    

    public long getHospedeId() {
        return hospedeId;
    }

    public void setHospedeId(long hospedeId) {
        this.hospedeId = hospedeId;
    }

    public long getClienteId() {
        return clienteId;
    }

    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
 
}
