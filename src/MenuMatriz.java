import java.util.Scanner;

public class MenuMatriz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] cadastro = new String[10][2];
        
        cadastro[0][0] = "Nome";
        cadastro[0][1] = "Matrícula";
        
        int opcaoMenu;
        boolean sair = false;
        int contadorLinhas = 0;
        int contadorColunas = 0;
        String consulta;

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
                    for (int i = contadorLinhas; i < 10; i++) {
                        contadorLinhas++;
                        contadorColunas = 0;
                        System.out.print("Digite o nome do aluno: ");
                        cadastro[contadorLinhas][contadorColunas] = scanner.nextLine();
                        contadorColunas++;
                        System.out.print("Digite o número da matrícula: ");
                        cadastro[contadorLinhas][contadorColunas] = scanner.nextLine();
                    }
                    System.out.println("Cadastro efetuado com sucesso!");
                    break;
                case 2:
                    System.out.println("Selecionado Consulta");
                    for (int j = 0; j < contadorLinhas; j++) {
                        System.out.println(cadastro[j][0] + cadastro[j][1]);
                    }
                    System.out.println("Digite o número da matrícula: ");
                    consulta = scanner.nextLine();


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
