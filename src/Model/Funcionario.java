package Model;

public class Funcionario extends Pessoa {
    
    
    private String cargo;
    private double salario;

    public Funcionario() {
    }

    public Funcionario(String cargo, double salario) {
        this.cargo = cargo;
        this.salario = salario;
    }

    public Funcionario(String cargo, double salario, int id, String nome, String email, String senha) {
        super(id, nome, email, senha);
        this.cargo = cargo;
        this.salario = salario;
    }

    public Funcionario(String cargo, double salario, int id, String nome, String email, String senha, Boolean senhaHash) {
        super(id, nome, email, senha, senhaHash);
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void alterarCargo(String novoCargo) {
        this.cargo = novoCargo;
    }
    
    public double calcularBonus(double percentual) {
        return this.salario * percentual / 100;
    }
    
    //metodos
    public void imprimirDadosFuncionario() {
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("Cargo: " + cargo);
        System.out.println("Salário: " + salario);
        System.out.println("Hash da Senha: "+ "*".repeat(getSenha().length()));
    }

}