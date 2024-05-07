package Model;

import java.time.LocalDate;

public class Produto {
    private int id_produto;
        private String produto;
        private String descricao_produto;
        private int quantidade_estoque;
        private double preço;
        private LocalDate data_cadastro;

    public Produto() {
    }

    public Produto(int id_produto, String produto, String descricao_produto, int quantidade_estoque, double preço, LocalDate data_cadastro) {
        this.id_produto = id_produto;
        this.produto = produto;
        this.descricao_produto = descricao_produto;
        this.quantidade_estoque = quantidade_estoque;
        this.preço = preço;
        this.data_cadastro = data_cadastro;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getDescricao_produto() {
        return descricao_produto;
    }

    public void setDescricao_produto(String descricao_produto) {
        this.descricao_produto = descricao_produto;
    }

    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(int quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    public LocalDate getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(LocalDate data_cadastro) {
        this.data_cadastro = data_cadastro;
    }
        
          //método para verificar o estoque do protudo
           public void verificarEstoque () {
         if (quantidade_estoque == 0){
         System.out.println("O produto está sem estoque no momento");}
         else {
         System.out.println ("O estoque do produto é: " + quantidade_estoque);}}
         
         //método para imprimir informações detalhadas do produto:
           public void imprimirInformacoesDetalhadas() {
        System.out.println("ID do Produto: " + id_produto);
        System.out.println("Nome do Produto: " + produto);
        System.out.println("Descrição do Produto: " + descricao_produto);
        System.out.println("Quantidade em Estoque: " + quantidade_estoque);
        System.out.println("Preço: " + preço);
        System.out.println("Data de Cadastro: " + data_cadastro);
       

   
       
        

        
    }}
