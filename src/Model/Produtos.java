package Model;

import java.time.LocalDate;
import java.awt.Image;

public class Produto {

    

    private int id;
    private String produto;
    private String descricao;
    private int quantidadeEstoque;
    private double preco;
    private LocalDate dataCadastro;
    private double peso;
    private Image imagem;


    public Produto() {
    }

    public Produto(int id, String produto, String descricao, int quantidadeEstoque, double preco, LocalDate dataCadastro, double peso, Image imagem) {
        this.id = id;
        this.produto = produto;
        this.descricao = descricao;
        this.quantidadeEstoque = quantidadeEstoque;
        this.preco = preco;
        this.dataCadastro = dataCadastro;
        this.peso = peso;
        this.imagem = imagem;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getdescricao() {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getquantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setquantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double getpreco() {
        return preco;
    }

    public void setpreco(double preco) {
        this.preco = preco;
    }

    public LocalDate getdataCadastro() {
        return dataCadastro;
    }

    public void setdataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Image getImagem(){
        return this.imagem;
    }

    public void setImagem(Image imagem){
        this.imagem = imagem;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    //método para verificar o estoque do produto
    public void verificarEstoque () {
        if (quantidadeEstoque == 0){
            System.out.println("O produto está sem estoque no momento");}
        else {
            System.out.println ("O estoque do produto é: " + quantidadeEstoque);
        }
    }

    //método para imprimir informações detalhadas do produto:
    public void imprimirInformacoesDetalhadas() {
        System.out.println("ID do Produto: " + id);
        System.out.println("Nome do Produto: " + produto);
        System.out.println("Descrição do Produto: " + descricao);
        System.out.println("Quantidade em Estoque: " + quantidadeEstoque);
        System.out.println("preco: " + preco);
        System.out.println("Peso: " + peso);
        System.out.println("Data de Cadastro: " + dataCadastro);  
        System.out.println("Imagem Inclusa: "+ String.valueOf(imagem != null));
    }
}
