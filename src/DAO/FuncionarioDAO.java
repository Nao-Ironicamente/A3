package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Funcionario;

public class FuncionarioDAO extends ConnectionDAO{
    
    public static ArrayList<Funcionario> MinhaLista = new ArrayList<Funcionario>();

    public FuncionarioDAO() {
    }

    public int maiorID() throws SQLException {

        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM Funcionario");
            res.next();
            maiorID = res.getInt("id");

            stmt.close();

        } catch (SQLException ex) {
        }

        return maiorID;
    }

    // Retorna a Lista de Funcionarios(objetos)
    public ArrayList getMinhaLista() {
        
        MinhaLista.clear(); // Limpa nosso ArrayList

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM Funcionario");
            while (res.next()) {

                int id = res.getInt("id");
                String nome = res.getString("nome");
                String cargo = res.getString("cargo");
                Double salario = res.getDouble("salario");
                String email = res.getString("email");
                String senha = res.getString("senha");

                Funcionario objeto = new Funcionario(cargo, salario , id, nome, email, senha, true);

                MinhaLista.add(objeto);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return MinhaLista;
    }

    // Cadastra novo funcionário
    public boolean InsertFuncionarioBD(Funcionario objeto) {
        String sql = "INSERT INTO Funcionario(id,nome,cargo,salario,email,senha) VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getCargo());
            stmt.setDouble(4, objeto.getSalario());
            stmt.setString(5, objeto.getEmail());
            stmt.setString(6, objeto.getSenha());
            
            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    // Deleta um funcionário especifico pelo seu campo ID
    public boolean DeleteFuncionarioBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM Funcionario WHERE id = " + id);
            stmt.close();            
            
        } catch (SQLException erro) {
        }
        
        return true;
    }

    // Edita um funcionário especifico pelo seu campo ID
    public boolean UpdateFuncionarioBD(Funcionario objeto) {

        String sql = "UPDATE Funcionario set nome = ? ,cargo = ? ,salario = ? ,email = ? ,senha = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getCargo());
            stmt.setDouble(3, objeto.getSalario());
            stmt.setString(4, objeto.getEmail());
            stmt.setString(5, objeto.getSenha());
            stmt.setInt(6, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    // Carrega funcionário especificado por id
    public Funcionario carregaFuncionario(int id) {
        
        Funcionario objeto = new Funcionario();
        objeto.setId(id);
        
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM Funcionario WHERE id = " + id);
            res.next();

            objeto.setNome(res.getString("nome"));
            objeto.setCargo(res.getString("cargo"));
            objeto.setSalario(res.getDouble("curso"));
            objeto.setEmail(res.getString("email"));
            objeto.setSenhaHash(res.getString("senha"));

            stmt.close();            
            
        } catch (SQLException erro) {
        }
        return objeto;
    }
}
