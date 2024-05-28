package Model;

public class Cliente extends Pessoa {
    private String telefone;
    private String endereco;
    private String senha;

    public Cliente() {
    }

    public Cliente(int id, String telefone, String endereco) {
        this.setId(id);
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Cliente(int id, String telefone, String endereco, String nome, String email, String senha) {
        this.setId(id);
        this.setNome(nome);
        this.setEmail(email);
        this.telefone = telefone;
        this.endereco = endereco;
        this.senha = senha;
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
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    //métodos
    public void alterarEndereco(String novoEndereco) {
        this.endereco = novoEndereco;
    }

    public void alterarTelefone(String novoTelefone) {
        this.telefone = novoTelefone;
    }

    public void imprimirDadosCliente() {
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("Telefone: " + telefone);
        System.out.println("Endereço: " + endereco);
        System.out.println("Hash da Senha: "+ "*".repeat(getSenha().length()));
    }

}
    
    
    
    
    
    

   

