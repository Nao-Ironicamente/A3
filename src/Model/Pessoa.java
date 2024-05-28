package Model;

import Hash.MD5;

public class Pessoa {

    private int id;
    private String nome;
    private String email;
    private String senha;

    public Pessoa() {
    }

    public Pessoa(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = MD5.getMd5(senha);
    }

    public Pessoa(int id, String nome, String email, String senha, Boolean senhaHash) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        if (senhaHash){
            this.senha = senha;
        }else{
            this.senha = MD5.getMd5(senha);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void alterarEmail(String novoEmail) {
        this.email = novoEmail;

    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha = MD5.getMd5(senha);
    }

    public void setSenhaHash(String senhaHash){
        this.senha = senhaHash;
    }
    
    public Boolean validarSenha(String senha){
        if(this.senha.equals(MD5.getMd5(senha))){
            return true;
        }else{
            return false;
        }
    }

    //métodos adicionais
    public void imprimirDetalhes() {
    System.out.println("ID: " + id);
    System.out.println("Nome: " + nome);
    System.out.println("Email: " + email);
    System.out.println("Hash da Senha: "+ "*".repeat(senha.length()));
    }
}
