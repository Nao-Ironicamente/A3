package DAO;

import Model.Produto;
import java.util.*;

import javax.imageio.ImageIO;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class ProdutoDAO extends ConnectionDAO {
    
    public static ArrayList<Produto> MinhaLista = new ArrayList<Produto>();

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

                byte[] imageByte = null;
                imageByte = res.getBytes("imagem");
                Image imagem = Toolkit.getDefaultToolkit().createImage(imageByte);

                Produto objeto = new Produto(id, nome, descricao, quantidadeEstoque, preco, dataCadastro, imagem);

                MinhaLista.add(objeto);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return MinhaLista;
    }

    // Cadastra novo Produto
    public boolean InsertProdutoBD(Produto objeto) {
        String sql = "INSERT INTO Produto(id,nome,descricao,estoque,preco,cadastro) VALUES(?,?,?,?,?,?)";
        
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
            stmt.setBytes(7, imagemByte);

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
    public boolean UpdateProdutoBD(Produto objeto) {

        String sql = "UPDATE Produto set nome = ? ,descricao = ? ,estoque = ? ,preco = ?, cadastro = ? WHERE id = ?";

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
            stmt.setInt(6, objeto.getid());
            stmt.setBytes(7, imagemByte);

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    // Carear um Produto especifico
    public Produto CarregarProduto(int id) {
        
        Produto objeto = new Produto();
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

            byte[] imageByte = null;
            imageByte = res.getBytes("imagem");
            Image imagem = Toolkit.getDefaultToolkit().createImage(imageByte);

            objeto.setImagem(imagem);

            stmt.close();            
            
        } catch (SQLException erro) {
        }
        return objeto;
    }
}