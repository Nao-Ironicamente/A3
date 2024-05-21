package Model;

import java.util.*;
import DAO.AlunoDAO;
import java.sql.SQLException;

public class Aluno extends Pessoa {

    // Atributos
    private String curso;
    private int fase;
    private int idade;
    private final AlunoDAO dao; 

    // Método Construtor de Objeto Vazio
    public Aluno() {
        this.dao = new AlunoDAO(); // inicializado não importa em qual construtor
    }

    // Método Construtor de Objeto, inserindo dados
    public Aluno(String curso, int fase) {
        this.curso = curso;
        this.fase = fase;
        this.dao = new AlunoDAO(); // inicializado não importa em qual construtor
    }

    // Método Construtor usando também o construtor da SUPERCLASSE
    public Aluno(String curso, int fase, int id, int idade ,String nome, String email) {
        super(id, nome, email);
        this.idade = idade;
        this.curso = curso;
        this.fase = fase;
        this.dao = new AlunoDAO(); // inicializado não importa em qual construtor
    }

    // Métodos GET e SET
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    // Override necessário para poder retornar os dados de Pessoa no toString para aluno.
    @Override
    public String toString() {
        return "\n ID: " + this.getId()
                + "\n Nome: " + this.getNome()
                + "\n Idade: " + this.getIdade()
                + "\n Curso: " + this.getCurso()
                + "\n Fase:" + this.getFase()
                + "\n -----------";
    }

    /*
    
        ABAIXO OS MÉTODOS PARA USO JUNTO COM O DAO
        SIMULANDO A ESTRUTURA EM CAMADAS PARA USAR COM BANCOS DE DADOS.
    
     */
    // Retorna a Lista de Alunos(objetos)
    public ArrayList getMinhaLista() {
        //return AlunoDAO.MinhaLista;
        return dao.getMinhaLista();
    }

    // Cadastra novo aluno
//    public boolean InsertAlunoBD(String curso, int fase, String nome, int idade) {
    public boolean InsertAlunoBD(String curso, int fase, int idade, String nome) throws SQLException {
        int id = this.maiorID() + 1;
        Aluno objeto = new Aluno(curso, fase, id, idade, nome, null);
//        AlunoDAO.MinhaLista.add(objeto);
        dao.InsertAlunoBD(objeto);
        return true;

    }

    // Deleta um aluno especifico pelo seu campo ID
    public boolean DeleteAlunoBD(int id) {
//        int indice = this.procuraIndice(id);
//        AlunoDAO.MinhaLista.remove(indice);
        dao.DeleteAlunoBD(id);
        return true;
    }

    // Edita um aluno especifico pelo seu campo ID
    public boolean UpdateAlunoBD(String curso, int fase, int id, String nome, int idade) {
        Aluno objeto = new Aluno(curso, fase, id, idade, nome, null);
//        int indice = this.procuraIndice(id);
//        AlunoDAO.MinhaLista.set(indice, objeto);
        dao.UpdateAlunoBD(objeto);
        return true;
    }

    // procura o INDICE de objeto da MinhaLista que contem o ID enviado.
//    private int procuraIndice(int id) {
//        int indice = -1;
//        for (int i = 0; i < AlunoDAO.MinhaLista.size(); i++) {
//            if (AlunoDAO.MinhaLista.get(i).getId() == id) {
//                indice = i;
//            }
//        }
//        return indice;
//    }

    // carrega dados de um aluno especifico pelo seu ID
    public Aluno carregaAluno(int id) {
//        int indice = this.procuraIndice(id);
//        return AlunoDAO.MinhaLista.get(indice);
        dao.carregaAluno(id);
        return null;
    }
    
    // retorna o maior ID da nossa base de dados
        public int maiorID() throws SQLException{
//    public int maiorID(){
//        return AlunoDAO.maiorID();
        return dao.maiorID();
    }   

    public int getIdade(){
        return this.idade;
    }

    public void setIdade(int Idade){
        this.idade = Idade;
    }
}
