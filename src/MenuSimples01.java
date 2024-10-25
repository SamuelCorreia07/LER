import java.util.Scanner;

public class MenuSimples01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nomeAluno = null, numMatricula = null, consulta;
        int opcaoMenu;
        boolean sair = false;

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
                    System.out.print("Digite o nome do aluno: ");
                    nomeAluno = scanner.nextLine();
                    System.out.print("Digite o número da matrícula: ");
                    numMatricula = scanner.nextLine();
                    System.out.println("Cadastro efetuado com sucesso!");
                    break;
                case 2:
                    System.out.println("Selecionado Consulta");
                    System.out.println("Digite o número da matrícula: ");
                    consulta = scanner.nextLine();
                    if (consulta.equals(numMatricula)) {
                        System.out.println("Consulta realizada com sucesso!\n" +
                                "Nome: " + nomeAluno +
                                "\nNúmero de matrícula: " + numMatricula);
                    }
                    break;
                case 3:
                    System.out.println("Selecionado sair");
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!!!!!!!!!!!");
            }

        } while (!sair);
        System.out.println("Até breve!");

        scanner.close();
    }
}
