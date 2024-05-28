package DAO;

import Model.Produtos;
import java.util.*;

import javax.imageio.ImageIO;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class ProdutoDAO extends ConnectionDAO {
    
    public static ArrayList<Produtos> MinhaLista = new ArrayList<Produtos>();

    public ProdutoDAO(){
    }

    public ArrayList getMinhaLista() {
        
        MinhaLista.clear(); // Limpa nosso ArrayList

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM Produto");
            while (res.next()) {

                int id = res.getInt("id");
                String nome = res.getString("nome");
                String descricao = res.getString("descricao");
                int quantidadeEstoque = res.getInt("estoque");
                Double preco = res.getDouble("preco");
                LocalDate dataCadastro = res.getDate("cadastro").toLocalDate();
                Double peso = res.getDouble("peso");
                
                byte[] imageByte = null;
                imageByte = res.getBytes("imagem");
                Image imagem = Toolkit.getDefaultToolkit().createImage(imageByte);

                Produtos objeto = new Produtos(id, nome, descricao, quantidadeEstoque, preco, dataCadastro, peso, imagem);

                MinhaLista.add(objeto);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return MinhaLista;
    }

    // Cadastra novo Produto
    public boolean InsertProdutoBD(Produtos objeto) {
        String sql = "INSERT INTO Produto(id,nome,descricao,estoque,preco,cadastro,peso,imagem) VALUES(?,?,?,?,?,?,?,?)";
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try{
            ImageIO.write((BufferedImage)objeto.getImagem(), "png", baos);
        } catch (Exception e){
            System.err.println("Erro! "+e);
        }
        byte[] imagemByte = baos.toByteArray();

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getid());
            stmt.setString(2, objeto.getProduto());
            stmt.setString(3, objeto.getdescricao());
            stmt.setInt(4, objeto.getquantidadeEstoque());
            stmt.setDouble(5, objeto.getpreco());
            stmt.setDate(6, java.sql.Date.valueOf(objeto.getdataCadastro()));
            stmt.setDouble(7, objeto.getPeso());
            stmt.setBytes(8, imagemByte);

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    // Deletar um Produto
    public boolean DeleteProdutoBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM Produto WHERE id = " + id);
            stmt.close();            
            
        } catch (SQLException erro) {
        }
        
        return true;
    }

    // Atualizar as informações em um Produto
    public boolean UpdateProdutoBD(Produtos objeto) {

        String sql = "UPDATE Produto set nome = ? ,descricao = ? ,estoque = ? ,preco = ?, cadastro = ?, peso = ?, imagem = ? WHERE id = ?";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try{
            ImageIO.write((BufferedImage)objeto.getImagem(), "png", baos);
        } catch (Exception e){
            System.err.println("Erro! "+e);
        }
        byte[] imagemByte = baos.toByteArray();

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getProduto());
            stmt.setString(2, objeto.getdescricao());
            stmt.setInt(3, objeto.getquantidadeEstoque());
            stmt.setDouble(4, objeto.getpreco());
            stmt.setDate(5, java.sql.Date.valueOf(objeto.getdataCadastro()));
            stmt.setDouble(6, objeto.getPeso());
            stmt.setBytes(7, imagemByte);
            stmt.setInt(8, objeto.getid());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    // Carregar um Produto especifico
    public Produtos CarregarProduto(int id) {
        
        Produtos objeto = new Produtos();
        objeto.setid(id);
        
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM Produto WHERE id = " + id);
            res.next();

            objeto.setProduto(res.getString("nome"));
            objeto.setdescricao(res.getString("descricao"));
            objeto.setquantidadeEstoque(res.getInt("estoque"));
            objeto.setpreco(res.getDouble("preco"));
            objeto.setdataCadastro(res.getDate("cadastro").toLocalDate());
            objeto.setPeso(res.getDouble("peso"));
            
            byte[] imageByte = null;
            imageByte = res.getBytes("imagem");
            Image imagem = Toolkit.getDefaultToolkit().createImage(imageByte);

            objeto.setImagem(imagem);

            stmt.close();            
            
        } catch (SQLException erro) {
        }
        return objeto;
    }

    //Pesquisar por Produto
    public ArrayList PesquisarProduto(String termoDePesquisa){

        MinhaLista.clear(); // Limpa nosso ArrayList

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("select * from `Produto` where `nome` rlike '"+termoDePesquisa+"' union " + // Executar a pesquisa no BD
                                              "select * from `Produto` where `descricao` rlike '"+termoDePesquisa+"';");
            while (res.next()) {

                int id = res.getInt("id");
                String nome = res.getString("nome");
                String descricao = res.getString("descricao");
                int quantidadeEstoque = res.getInt("estoque");
                Double preco = res.getDouble("preco");
                LocalDate dataCadastro = res.getDate("cadastro").toLocalDate();
                Double peso = res.getDouble("peso");
                
                byte[] imageByte = null;
                imageByte = res.getBytes("imagem");
                Image imagem = Toolkit.getDefaultToolkit().createImage(imageByte);

                Produtos objeto = new Produtos(id, nome, descricao, quantidadeEstoque, preco, dataCadastro, peso, imagem);

                MinhaLista.add(objeto);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return MinhaLista;
    }
}