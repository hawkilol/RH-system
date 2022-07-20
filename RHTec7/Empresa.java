package com.RHTec7;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Empresa extends Contrato {
    private String nome;
    private Endereço endereço;
    private String telefone;
    private String cnpj;
    private String email;
    private String dono;
    ArrayList<Contrato> contratos; // Declara um Arraylist para os contratos

    public Empresa() { //Estabelece que uma empresa tem varios contratos
        this.contratos = new ArrayList<Contrato>();
    }
    public Empresa(String nome, Endereço endereço, String telefone, String cnpj, String email, String dono){
        this.contratos = new ArrayList<Contrato>();
        this.nome = nome;
        this.endereço = endereço;
        this.telefone = telefone;
        this.cnpj = cnpj;
        this.email = email;
        this.dono = dono;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereço getEndereço() {
        return endereço;
    }
    public void setEndereço(Endereço endereço) {
        this.endereço = endereço;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    //recebe dados do funcionario para admitir
    public void admitir(Funcionario funcionario, Setor setor, double salario, String cargo){
        Contrato contrato = new Contrato(funcionario, setor, salario, cargo);
        contratos.add(contrato);

    }
    //versão do admitir que não recebe os parametros inicialmente mas com o scanner dentro
    public void admitir(){
        System.out.println("\n#admitir");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        String nome = scanner.next();
        System.out.println("Digite o sobrenome: ");
        String sobrenome = scanner.next();
        System.out.println("Digite o bairro: ");
        String bairro = scanner.next();
        System.out.println("Digite a cidade: ");
        String cidade = scanner.next();
        System.out.println("Digite o estado: ");
        String estado = scanner.next();
        System.out.println("Digite a idade: ");
        int idade = scanner.nextInt();
        System.out.println("Digite o sexo: ");
        String sexo = scanner.next();
        System.out.println("Digite o cpf: ");
        String cpf = scanner.next();
        System.out.println("Digite o email: ");
        String email = scanner.next();
        System.out.println("Digite o telefone: ");
        String telefone = scanner.next();
        System.out.println("Digite o setor: ");
        Setor setor = Setor.valueOf(scanner.next().toUpperCase());
        System.out.println("Digite o salario: ");
        double salario = scanner.nextDouble();
        System.out.println("Digite o cargo (chefe ou colaborador): ");
        String cargo = scanner.next();
        for(int i = 0; i < contratos.size(); i++){//Verifica e Evita que um setor tenha mais de um chefe.
            if(Objects.equals(contratos.get(i).getCargo(), "chefe") && Objects.equals(contratos.get(i).getSetor(), setor)){
                System.out.println("Esse setor já possui um chefe(O funcionario vai ser definido como 'colaborador')");
                cargo = "colaborador";
            }
        }
         //instancia um novo contrato com instancias dos atributos necessario como um novo Funcionario e novo Endereço
        Contrato contrato = new Contrato(new Funcionario(nome, sobrenome, new Endereço(bairro, cidade, estado), idade, sexo, cpf, email, telefone), setor, salario, cargo);

        contratos.add(contrato);
    }

    //Consultar um funcionário por nome ou cpf na lista de contratos da empresa.
    public void consultar(String nomeOuCpf){
        System.out.println("\n#consultar");
        for(int i = 0; i < contratos.size(); i++){//gets relacionados aos dados pessoais dos funcionarios usam getFuncionario() primeiro para acessar funcionario.get'Nome'
            if(Objects.equals(contratos.get(i).getFuncionario().getNome(), nomeOuCpf)) { // Consulta por nome
                contratos.get(i).getAll();
            }
            if(Objects.equals(contratos.get(i).getFuncionario().getCpf(), nomeOuCpf)) { // Consulta por cpf
                contratos.get(i).getAll();
                break;
            }
        }
    }


    //Atualizar os dados contratuais de um funcionário, inclusive os dados pessoais dele
    public void atualizar(String cpf, String nome, String sobrenome, String bairro, String cidade, String estado, int idade, String sexo, String cpfNew, String email, String telefone, Setor setor, double salario, String cargo){
        System.out.println("\n#atualizar");
        for(int i = 0; i < contratos.size(); i++){
            if(Objects.equals(contratos.get(i).getFuncionario().getCpf(), cpf)) {
                contratos.get(i).updateAll(nome, sobrenome, bairro, cidade, estado, idade, sexo, cpfNew, email, telefone, setor, salario, cargo);
                break;
            }
        }
    }
//busca o cpf na lista de contratos e remove o mesmo, esses metodos utlizam Objects.equals no lugar de == para evitar problemas
    public void demitir(String cpf){
        for(int i = 0; i < contratos.size(); i++){
            System.out.println("\n#demitir");
            if(Objects.equals(contratos.get(i).getFuncionario().getCpf(), cpf)) {
                System.out.println("removed: " + contratos.get(i).getNome());
                contratos.remove(i);
                break;
            }
        }
    }
//retorna todos os funcionarios com uma previa das informações
    public void visualizarAll(){
        System.out.println("\n#visualizarAll");
        System.out.println("\nLista de Funcionarios: ");
        for(int i = 0; i < contratos.size(); i++){
            System.out.println("Nome: "+contratos.get(i).getFuncionario().getNome());
            System.out.println("Cpf: "+contratos.get(i).getFuncionario().getCpf());
            System.out.println("Id: "+contratos.get(i).getId()+"\n");

        }
    }
//busca funcionario na lista de contratos por setor ou sexo ou estado
    public void visualizar(String setorOuSexoOuEstado){
        System.out.println("\n#visualizar");
        for(int i = 0; i < contratos.size(); i++){
            if(Objects.equals(contratos.get(i).getSetor().getDescricao(), setorOuSexoOuEstado)) { // visualizar por setor
                System.out.println("Visualizando Setor: "+setorOuSexoOuEstado);
                contratos.get(i).getAll();
            }
            if(Objects.equals(contratos.get(i).getFuncionario().getSexo(), setorOuSexoOuEstado)) { // visualizar por sexo
                System.out.println("Visualizando Sexo: "+setorOuSexoOuEstado);
                contratos.get(i).getAll();
            }
            if(Objects.equals(contratos.get(i).getFuncionario().getEndereço().getEstado(), setorOuSexoOuEstado)) { // visualizar por estado
                System.out.println("Visualizando Estado: "+setorOuSexoOuEstado);
                contratos.get(i).getAll();
            }
        }
    }
//verifica qual é o maior e menor salario comparando um por um na lista de contratos e retorna o funcionario referente junto dos valores
    public void identificarSalario(){
        System.out.println("\n#visualizarAll");
        double maior = 0;
        Contrato maiorFuncionario = null;
        double menor = 0;
        Contrato menorFuncionario = null;

        for(int i = 0; i < contratos.size(); i++){
            if( maior < contratos.get(i).getSalario()){
                maior = contratos.get(i).getSalario();
                maiorFuncionario = contratos.get(i);
            }
            if(i == 0){
                menor = contratos.get(i).getSalario();
                menorFuncionario = contratos.get(i);
            }
            if(menor > contratos.get(i).getSalario()){
                menor = contratos.get(i).getSalario();
                menorFuncionario = contratos.get(i);
            }
        }
        System.out.println("\nFuncionario com o Maior Salario: " + maior);
        System.out.println("Nome: "+maiorFuncionario.getFuncionario().getNome());
        System.out.println("Cpf: "+maiorFuncionario.getFuncionario().getCpf());
        System.out.println("Setor: "+maiorFuncionario.getSetor().getDescricao());
        System.out.println("Cargo: "+maiorFuncionario.getCargo());
        System.out.println("\nFuncionario com o Menor Salario: " + menor);
        System.out.println("Nome: "+menorFuncionario.getFuncionario().getNome());
        System.out.println("Cpf: "+menorFuncionario.getFuncionario().getCpf());
        System.out.println("Setor: "+menorFuncionario.getSetor().getDescricao());
        System.out.println("Cargo: "+menorFuncionario.getCargo());
    }
//Similar ao metodo identificarSalario, conta quantas vezes um setor se repete na lista de funcionarios e retona o maior setor
    public void identificarP(){
        System.out.println("\n#identificarP");
        int maior = 0;
        int menor = 0;
        String maiorSetor = null;
        String menorSetor = null;
        ArrayList<Integer> vezesSetor = new ArrayList<Integer>();
        for(int i = 0; i < contratos.size(); i++){
            int vezes = 0;
            for(int k = 0; k < contratos.size(); k++){
                if(Objects.equals(contratos.get(i).getSetor().getDescricao(), contratos.get(k).getSetor().getDescricao())){
                    vezes++;
                }
            }
            vezesSetor.add(i, vezes);

            for(int c = 0; c < vezesSetor.size(); c++){
                if( maior < vezesSetor.get(c)){
                    maior = vezesSetor.get(c);
                    maiorSetor = contratos.get(c).getSetor().getDescricao();
                }
                if(c == 0){
                    menor = vezesSetor.get(c);
                    menorSetor = contratos.get(c).getSetor().getDescricao();
                }
                if(menor > vezesSetor.get(c)){
                    menor = vezesSetor.get(c);
                    menorSetor = contratos.get(c).getSetor().getDescricao();
                }
            }
        }
        System.out.println("\nSetor Com Mais Funcionarios: "+ maiorSetor +": "+ maior);
        System.out.println("Setor Com Menos Funcionarios: "+ menorSetor +": "+ menor);
    }
//Retorna um informação extra ao usuario, a mediaA das idades
    public void info(){
        System.out.println("\n#info");
        int soma = 0;
        int media = 0;
        for(int i = 0; i < contratos.size(); i++){
            soma += contratos.get(i).getFuncionario().getIdade();
        }
        media = soma/contratos.size();
        System.out.println("Idade Media Dos Funcionarios: " + media);
    }


    public static void main(String[] args){
        
    }
}
