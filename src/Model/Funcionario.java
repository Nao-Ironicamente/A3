package Model;

public class Funcionario extends Pessoa {
    
    
    private int pessoa_id;
    private String cargo;
    private double salario;

    public Funcionario() {
    }

    public Funcionario(int pessoa_id, String cargo, double salario) {
        this.pessoa_id = pessoa_id;
        this.cargo = cargo;
        this.salario = salario;
    }

    public Funcionario(int pessoa_id, String cargo, double salario, int id, String nome, String email) {
        super(id, nome, email);
        this.pessoa_id = pessoa_id;
        this.cargo = cargo;
        this.salario = salario;
    }

    public int getPessoa_id() {
        return pessoa_id;
    }

    public void setPessoa_id(int pessoa_id) {
        this.pessoa_id = pessoa_id;
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

    
    //metodos
    public void imprimirDadosFuncionario() {
    System.out.println("ID: " + getId());
    System.out.println("Nome: " + getNome());
    System.out.println("Email: " + getEmail());
    System.out.println("Pessoa ID: " + pessoa_id);
    System.out.println("Cargo: " + cargo);
    System.out.println("Salário: " + salario);
}
    public void alterarCargo(String novoCargo) {
    this.cargo = novoCargo;
    }
    
     public double calcularBonus(double percentual) {
        return this.salario * percentual / 100;
}



    
    
    
    
  
    }
    
    
    
    
    

   

    
    
            



