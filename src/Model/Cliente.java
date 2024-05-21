package Model;

public class Cliente extends Pessoa {
    
    
    private int pessoa_id;
    private String telefone;
    private String endereco;

    public Cliente() {
    }

    public Cliente(int pessoa_id, String telefone, String endereco) {
        this.pessoa_id = pessoa_id;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Cliente(int pessoa_id, String telefone, String endereco, int id, String nome, String email) {
        super(id, nome, email);
        this.pessoa_id = pessoa_id;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public int getPessoa_id() {
        return pessoa_id;
    }

    public void setPessoa_id(int pessoa_id) {
        this.pessoa_id = pessoa_id;
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
    
    
    
    
    
    

   

