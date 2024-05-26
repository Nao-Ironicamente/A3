package Model;

public class Cliente extends Pessoa {
    
    private String telefone;
    private String endereco;

    public Cliente() {
    }

    public Cliente(String telefone, String endereco) {
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Cliente(String telefone, String endereco, int id, String nome, String email) {
        super(id, nome, email);
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    //métodos
    public void alterarEndereco (String novoEndereco){
        this.endereco = novoEndereco;
    }
    
    public void alterarTelefone (String novoTelefone){
        this.telefone = novoTelefone;
    }
}
    
    
    
    
    
    

   

