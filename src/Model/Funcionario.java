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

    public Funcionario(String cargo, double salario, int id, String nome, String email) {
        super(id, nome, email);
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
    }

}