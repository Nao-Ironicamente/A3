package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Cliente;

public class ClienteDAO extends ConnectionDAO {

    public static ArrayList<Cliente> MinhaLista = new ArrayList<Cliente>();

    public ClienteDAO() {
    }

    public int maiorID() throws SQLException {

        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM Cliente");
            res.next();
            maiorID = res.getInt("id");

            stmt.close();

        } catch (SQLException ex) {
        }

        return maiorID;
    }

    // Retorna a Lista de Clientes(objetos)
    public ArrayList getMinhaLista() {

        MinhaLista.clear(); // Limpa nosso ArrayList

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM Cliente");
            while (res.next()) {

                int id = res.getInt("id");
                String nome = res.getString("nome");
                String endereco = res.getString("endereco");
                String email = res.getString("email");
                String telefone = res.getString("telefone");

                //Cliente objeto = new Cliente(telefone, endereco, id, nome, email);
                //MinhaLista.add(objeto);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return MinhaLista;
    }

    // Cadastra novo cliente
    public boolean InsertClienteBD(Cliente objeto) {
        String sql = "INSERT INTO Cliente(id,nome,endereco,email,telefone) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getEndereco());
            stmt.setString(4, objeto.getEmail());
            stmt.setString(5, objeto.getTelefone());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    // Deleta um cliente especifico pelo seu campo ID
    public boolean DeleteClienteBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM Cliente WHERE id = " + id);
            stmt.close();

        } catch (SQLException erro) {
        }

        return true;
    }

    // Edita um cliente especifico pelo seu campo ID
    public boolean UpdateClienteBD(Cliente objeto) {

        String sql = "UPDATE Cliente set nome = ? ,endereco = ? ,email = ? ,telefone = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getEndereco());
            stmt.setString(3, objeto.getEmail());
            stmt.setString(4, objeto.getTelefone());
            stmt.setInt(5, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    // Carrega cliente especificado por id
    public Cliente carregaCliente(int id) {

        Cliente objeto = new Cliente();
        objeto.setId(id);

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM Cliente WHERE id = " + id);
            res.next();

            objeto.setNome(res.getString("nome"));
            objeto.setEndereco(res.getString("endereco"));
            objeto.setEmail(res.getString("email"));
            objeto.setTelefone(res.getString("telefone"));

            stmt.close();

        } catch (SQLException erro) {
        }
        return objeto;
    }
}
