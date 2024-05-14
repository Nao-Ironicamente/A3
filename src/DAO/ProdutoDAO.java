package DAO;

import Model.Aluno;
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


}
