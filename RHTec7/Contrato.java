package com.RHTec7;

public class Contrato extends Funcionario {
    private Funcionario funcionario;
    private Setor setor;
    private int Id;
    private double salario;
    private String cargo;
    private static int idC;

    public Contrato(Funcionario funcionario, Setor setor, double salario, String cargo){
        idC++; //Incremento para formar o Id
        this.funcionario = funcionario;
        this.setor = setor;
        this.Id = idC;
        this.salario = salario;
        this.cargo = cargo;

    }

    public Contrato() {
        idC++;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = this.setor;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
//metodo para retornar com print as todas as informações pessoais do funcionario e do contrato
    public void getAll() {
        System.out.println("Nome: "+funcionario.getNome());
        System.out.println("Sobrenome: "+funcionario.getSobrenome());
        System.out.println("Endereço: Bairro: "+funcionario.getEndereço().getBairro()+"  Cidade: " + funcionario.getEndereço().getCidade() + "  Estado: " + funcionario.getEndereço().getEstado());
        System.out.println("Idade: "+funcionario.getIdade());
        System.out.println("Sexo: "+funcionario.getSexo());
        System.out.println("cpf: "+funcionario.getCpf());
        System.out.println("email: "+funcionario.getEmail());
        System.out.println("telefone: "+funcionario.getTelefone());
        System.out.println("Setor: "+getSetor());
        System.out.println("Id: "+getId());
        System.out.println("Salario: "+getSalario());
        System.out.println("Cargo: "+getCargo());
    }

//metodo para atualizar os todos os valores do contrato e do funcionario
    public void updateAll(String nome, String sobrenome, String bairro, String cidade, String estado, int idade, String sexo, String cpf, String email, String telefone, Setor setor, double salario, String cargo) {

        setNome(nome);
        setSobrenome(sobrenome);
        getEndereço().setBairro(bairro);
        getEndereço().setCidade(cidade);
        getEndereço().setEstado(estado);

        setIdade(idade);
        setSexo(sexo);
        setCpf(cpf);
        setEmail(email);
        setTelefone(telefone);

        setSetor(setor);
        setSalario(salario);
        setCargo(cargo);
    }

}
