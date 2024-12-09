import java.util.Arrays;
import java.util.Scanner;

public class MenuFuncoes2 {
    static Scanner scanner = new Scanner(System.in);
    static String[] cabecalho = {"ID", "Cargo", "Nome", "Matrícula"};
    static String[][] cadastro = {{"",""}};


    public static void main(String[] args) {
        cadastro[0] = cabecalho;

        String menu = """
                _____________________________________________
                |   Escolha uma opção:                      |
                |       1- Exibir Cadastro Completo         |
                |       2- Inserir Novo Usuário             |
                |       3- Buscar Usuário por ID            |
                |       4- Atualizar Cadastro por ID        |
                |       5- Deletar um Cadastro por ID       |
                |       6- Sair                             |
                |___________________________________________|
                """;

        int opcao;
        do {
            System.out.println(menu);
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    exibirUsuario();
                    break;
                case 2:
                    menuCadastrarUsuario();
                    break;
                case 3:
                    buscaUsuario();
                    break;
                case 4:
                    atualizarUsuario();
                    break;
                case 5:
                    deletarUsuario();
                    break;
                case 6:
                    System.out.println("Fim do programa");
                    scanner.close();
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (opcao != 6);
    }

    public static void exibirUsuario(){
        StringBuilder tabela = new StringBuilder();

        for (String[] linhas : cadastro) {
            for (int colunas = 0; colunas < cadastro[0].length; colunas++) {
                int tamanhoColuna = colunas == 0 ? 5 : (colunas == 3 || colunas == 1 ? 12 : 25);
                tabela.append(String.format("%-" + tamanhoColuna + "s|", linhas[colunas]));
            }
            tabela.append("\n"); // Para pular para a próxima linha
        }
        System.out.println(tabela);
    }

    public static void menuCadastrarUsuario(){

        int totalAluno = 10;
        int totalCoordenador = 2;
        int totalAQV = 1;

        System.out.print("Digite a quantidade de usuários que deseja cadastrar: ");
        int qtdUsuarios = scanner.nextInt();

        String menuCadastro = """
                ____________________________________________________
                |   Selecione o cargo do(s) usuário(s):            |
                |       1- Aluno                                   |
                |       2- Coordenador                             |
                |       3- Assistente de Qualidade de Vida (AQV)   |
                |       4- Sair                                    |
                |__________________________________________________|
                """;

        int opcao;
        do {
            System.out.println(menuCadastro);
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    if (qtdUsuarios <= totalAluno){
                        cadastrarUsuario(qtdUsuarios, "Aluno");
                        totalAluno-=qtdUsuarios;
                    } else {
                        System.out.println("Quantidade máxima de alunos atingida");
                        break;
                    }
                    break;
                case 2:
                    if (qtdUsuarios <= totalCoordenador){
                        cadastrarUsuario(qtdUsuarios, "Coordenador");
                        totalCoordenador-=qtdUsuarios;
                    } else {
                        System.out.println("Quantidade máxima de coordenadores atingida");
                        break;
                    }
                    break;
                case 3:
                    if (qtdUsuarios <= totalAQV){
                        cadastrarUsuario(qtdUsuarios, "AQV");
                        totalAQV-=qtdUsuarios;
                    } else {
                        System.out.println("Quantidade máxima de AQV atingida");
                        break;
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (opcao != 4);

    }

    public static void cadastrarUsuario(int qtdUsuarios, String cargo){

        String[][] novoCadastro = new String[cadastro.length+qtdUsuarios][cabecalho.length];

        for (int linha = 0; linha < cadastro.length; linha++) {
            novoCadastro[linha] = Arrays.copyOf(cadastro[linha],cadastro[linha].length);
        }

        System.out.println("Preencha os dados a seguir:");
        for (int linha = cadastro.length; linha < novoCadastro.length; linha++) {
            System.out.println("Cadastro da pessoa " + linha);

            System.out.println(cabecalho[0] + ": " + linha);
            novoCadastro[linha][0] = String.valueOf(linha); //Converte valor inteiro para String

            System.out.println(cabecalho[1] + ": " + cargo);
            novoCadastro[linha][1] = cargo;

            for (int coluna = 2; coluna < cabecalho.length; coluna++) {
                System.out.print(cabecalho[coluna] + ": ");
                novoCadastro[linha][coluna] = scanner.nextLine();
            }
        }
        cadastro = novoCadastro;
    }

    public static void buscaUsuario() {

        System.out.println("\nDigite o ID do usuario para buscar: ");
        String idEscolhido = scanner.nextLine();

        for (String[] linha : cadastro) {
            if (linha[0].equals(idEscolhido)) {
                StringBuilder tabela = new StringBuilder();
                for (int colunas = 0; colunas < cadastro[0].length; colunas++) {
                    int tamanhoColuna = colunas == 0 ? 5 : (colunas == 3 || colunas == 1 ? 12 : 25);
                    tabela.append(String.format("%-" + tamanhoColuna + "s|", cabecalho[colunas]));
                }
                tabela.append("\n"); // Para pular para a próxima linha
                for (int colunas = 0; colunas < cadastro[0].length; colunas++) {
                    int tamanhoColuna = colunas == 0 ? 5 : (colunas == 3 || colunas == 1 ? 12 : 25);
                    tabela.append(String.format("%-" + tamanhoColuna + "s|", linha[colunas]));
                }
                System.out.println(tabela);
            } else {
                System.out.println("ID não cadatrado");
                break;
            }
        }

    }

    public static void atualizarUsuario(){

        exibirUsuario();

        System.out.println("\n Digite o ID do usuario para atualizar");
        int idEscolhido = scanner.nextInt();
        scanner.nextLine();

        System.out.println(cabecalho[0] +": " + idEscolhido);

        //Cargo automático

        for (int coluna = 1; coluna < cabecalho.length; coluna++) {
            System.out.print(cabecalho[coluna] + ": ");
            cadastro[idEscolhido][coluna] = scanner.nextLine();
        }

        exibirUsuario();

    }
    public static void deletarUsuario(){
        System.out.println("Deletar");
    }
}
