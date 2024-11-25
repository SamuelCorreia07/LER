import java.util.Scanner;

public class MenuFuncoes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] cadastro = new String[10][2];

        cadastro[0][0] = "Nome";
        cadastro[0][1] = "Matrícula";

        int opcaoMenu;
        boolean sair = false;
        int contadorLinhas = 0;
        int contadorColunas;
        String consulta;
        boolean consultaV = false;
        int contadorConsulta = 0;

        do {
            System.out.println("Escolha uma opção:\n" +
                    "\t1 - Cadastro\n" +
                    "\t2 - Consulta\n" +
                    "\t3 - Sair");
            opcaoMenu = scanner.nextInt();
            scanner.nextLine();
            switch (opcaoMenu) {
                case 1:
                    System.out.println("Selecionado Cadastro");
                    if (contadorLinhas < 11) {
                        contadorLinhas++;
                        contadorColunas = 0;
                        System.out.print("Digite o nome do aluno: ");
                        cadastro[contadorLinhas][contadorColunas] = scanner.nextLine();
                        contadorColunas++;
                        System.out.print("Digite o número da matrícula: ");
                        cadastro[contadorLinhas][contadorColunas] = scanner.nextLine();
                    } else {
                        System.out.println("Quantidade máxima de alunos cadastrados atingida");
                        break;
                    }
                    System.out.println("Cadastro efetuado com sucesso!");
                    break;
                case 2:
                    System.out.println("Selecionado Consulta");
                    System.out.println("Digite o número da matrícula: ");
                    consulta = scanner.nextLine();
                    for (int k = 0; k < 10; k++) {
                        if (consulta.equals(cadastro[k][1])) {
                            consultaV = true;
                            contadorConsulta = k;
                            break;
                        }
                    }
                    if (consultaV == true){
                        System.out.println("Cadastro encontrado: " +
                                "\nNome: " + cadastro[contadorConsulta][0] + " | Matrícula: " + cadastro[contadorConsulta][1]);
                    } else {
                        System.out.println("Cadastro não encontrado");
                    }
                    break;
                case 3:
                    System.out.println("Selecionado sair");
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (!sair);
        System.out.println("Até breve!");

        scanner.close();
    }
}
