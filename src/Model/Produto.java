package Model;

import java.time.LocalDate;

import javax.imageio.ImageIO;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Produto {

    private int id;
    private String produto;
    private String descricao;
    private int quantidadeEstoque;
    private double preco;
    private LocalDate dataCadastro;
    private Image imagem;

    public Produto() {
    }

    public Produto(int id, String produto, String descricao, int quantidadeEstoque, double preco, LocalDate dataCadastro, Image imagem) {
        this.id = id;
        this.produto = produto;
        this.descricao = descricao;
        this.quantidadeEstoque = quantidadeEstoque;
        this.preco = preco;
        this.dataCadastro = dataCadastro;
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

    public Image getImagem() {
        return this.imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public void setImagem(String Link){
        try {
            this.imagem = (Image)ImageIO.read(new URL(Link));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            try{
                this.imagem = (Image)ImageIO.read(new File(Link));
            }catch(Exception er){
                er.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //método para verificar o estoque do produto
    public void verificarEstoque() {
        if (quantidadeEstoque == 0) {
            System.out.println("O produto está sem estoque no momento");
        } else {
            System.out.println("O estoque do produto é: " + quantidadeEstoque);
        }
    }

    //método para imprimir informações detalhadas do produto:
    public void imprimirInformacoesDetalhadas() {
        System.out.println("ID do Produto: " + id);
        System.out.println("Nome do Produto: " + produto);
        System.out.println("Descrição do Produto: " + descricao);
        System.out.println("Quantidade em Estoque: " + quantidadeEstoque);
        System.out.println("preco: " + preco);
        System.out.println("Data de Cadastro: " + dataCadastro);
        System.out.println("Imagem Inclusa: " + String.valueOf(imagem != null));
    }

    public boolean InsertProdutoBD(String nome, String descricao, double peso, int quantidade, double preco) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public Object getMinhaLista() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
