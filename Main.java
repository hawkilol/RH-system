import com.RHTec7.Contrato;
import com.RHTec7.Empresa;
import com.RHTec7.Endereço;
import com.RHTec7.Funcionario;
import com.RHTec7.Setor;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){ // abre o scanner para receber os dados da empresa e instancia uma nova empresa
        Scanner scanner = new Scanner(System.in);
        System.out.println("#Criando Empresa...");
        System.out.println("Digite as informações da empresa: ");
        System.out.println("Digite o nome: ");
        String nome = scanner.next();
        System.out.println("Digite o bairro: ");
        String bairro = scanner.next();
        System.out.println("Digite a cidade: ");
        String cidade = scanner.next();
        System.out.println("Digite o estado: ");
        String estado = scanner.next();
        System.out.println("Digite o telefone: ");
        String telefone = scanner.next();
        System.out.println("Digite o cnpj: ");
        String cnpj = scanner.next();
        System.out.println("Digite o email: ");
        String email = scanner.next();
        System.out.println("Digite o nome do dono: ");
        String dono = scanner.next();

        Empresa empresa = new Empresa(nome, new Endereço(bairro, estado, estado), telefone, cnpj, email, dono);
        System.out.println("\nEmpresa Criada: ");
        System.out.println("Nome: "+empresa.getNome());
        System.out.println("Endereço: Bairro: "+empresa.getEndereço().getBairro()+" Cidade: "+empresa.getEndereço().getCidade()+" Estado: "+empresa.getEndereço().getEstado());
        System.out.println("Telefone: "+empresa.getTelefone());
        System.out.println("Cnpj: "+empresa.getCnpj());
        System.out.println("Email: "+empresa.getEmail());
        System.out.println("Dono: "+empresa.getDono());

        boolean quit = false;

        while(quit == false){//Loop do menu que permite o usuario escolher entre os cases para operar a empresa
            System.out.println("\n#Escolha uma das operações(Digitando o nome da operação na forma a qual está escrita) abaixo para administrar a empresa: ");
            System.out.println("Operações:" +
                    "\n'Admitir' - (Admitir um novo funcionário)" +
                    "\n'Consultar' - (Consultar um funcionário por nome ou cpf na lista de contratos da empresa)" +
                    "\n'Atualizar' - (Atualizar os dados contratuais de um funcionário, inclusive os dados pessoais dele)" +
                    "\n'Demitir' - (Demitir, por cpf, um funcionário contratado da empresa)" +
                    "\n'VisualizarAll' - (Visualizar a lista de todos os funcionários da empresa)" +
                    "\n'Visualzar' - (Visualizar os funcionários por: setor, sexo e estado)" +
                    "\n'IdentificarSalario' - (Identificar o funcionário com o maior (e menor) salário, o setor de trabalho e o seu cargo)" +
                    "\n'IdentificarSetor' - (Identificar o setor da empresa com o maior (e menor) número de funcionários)" +
                    "\n'Info' - (Informação Extra dos funcionarios)" +
                    "\n '0' - (Digite 0 para sair)" +
                    ": " );
//test cases da escolha
            String escolha = scanner.next();
            switch(escolha){
                case("Admitir"):
                    empresa.admitir();
                    System.out.println("Funcionario Admitido!");
                    break;
                case("Consultar"):
                    System.out.println("Digite um nome ou cpf: ");
                    String nomeOuCpf = scanner.next();
                    empresa.consultar(nomeOuCpf);
                    break;
                case("Atualizar"):
                    System.out.println("Digite o cpf de um funcionario: ");
                    String cpf = scanner.next();
                    System.out.println("Digite o nome: ");
                    String nomeNew = scanner.next();
                    System.out.println("Digite o sobrenome: ");
                    String sobrenomeNew = scanner.next();
                    System.out.println("Digite o bairro: ");
                    String bairroNew = scanner.next();
                    System.out.println("Digite a cidade: ");
                    String cidadeNew = scanner.next();
                    System.out.println("Digite o estado: ");
                    String estadoNew = scanner.next();
                    System.out.println("Digite a idade: ");
                    int idadeNew = scanner.nextInt();
                    System.out.println("Digite o sexo: ");
                    String sexoNew = scanner.next();
                    System.out.println("Digite o cpf: ");
                    String cpfNew = scanner.next();
                    System.out.println("Digite o email: ");
                    String emailNew = scanner.next();
                    System.out.println("Digite o telefone: ");
                    String telefoneNew = scanner.next();
                    System.out.println("Digite o setor: ");
                    Setor setorNew = Setor.valueOf(scanner.next().toUpperCase());
                    System.out.println("Digite o salario: ");
                    double salarioNew = scanner.nextDouble();
                    System.out.println("Digite o cargo (chefe ou colaborador): ");
                    String cargoNew = scanner.next();

                    empresa.atualizar(cpf, nomeNew, sobrenomeNew, bairroNew, cidadeNew, estadoNew, idadeNew, sexoNew,  cpfNew,  emailNew, telefoneNew, setorNew, salarioNew, cargoNew);
                    break;
                case("Demitir"):
                    System.out.println("Digite o cpf: ");
                    String cpf1 = scanner.next();

                    empresa.demitir(cpf1);
                    break;
                case("VisualizarAll"):
                    empresa.visualizarAll();
                    break;
                case("Visualizar"):
                    System.out.println("Digite um Setor ou Sexo ou Estado: ");
                    String setorOuSexoOuEstado = scanner.next();
                    empresa.visualizar(setorOuSexoOuEstado);
                    break;
                case("IdentificarSalario"):
                    empresa.identificarSalario();
                    break;
                case("IdentificarSetor"):
                    empresa.identificarP();
                    break;
                case("Info"):
                    empresa.info();
                    break;
                case("0"):
                    quit = true;
                    break;

                default:
                    System.out.println("!Digite o nome de uma operação vailda!");

            }
        }
    }
}
