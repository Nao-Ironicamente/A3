package DAO;

import Model.Produto;
import java.util.*;
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

                int id_produto = res.getInt("id");
                String produto = res.getString("nome");
                String descricao_produto = res.getString("descricao");
                int quantidade_estoque = res.getInt("estoque");
                Double preço = res.getDouble("preço");
                LocalDate data_cadastro = res.getDate("cadastro").toLocalDate();

                Produto objeto = new Produto(id_produto, produto, descricao_produto, quantidade_estoque, preço,data_cadastro);

                MinhaLista.add(objeto);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return MinhaLista;
    }

    // Cadastra novo aluno
    public boolean InsertProdutoBD(Produto objeto) {
        String sql = "INSERT INTO Produto(id,nome,descricao,estoque,preço,cadastro) VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId_produto());
            stmt.setString(2, objeto.getProduto());
            stmt.setString(3, objeto.getDescricao_produto());
            stmt.setInt(4, objeto.getQuantidade_estoque());
            stmt.setDouble(5, objeto.getPreço());
            stmt.setDate(6, java.sql.Date.valueOf(objeto.getData_cadastro()));

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }
}