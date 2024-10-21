import java.util.Scanner;

public class MenuSimples02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcaoMenu;

        System.out.println("Digite uma opção: \n" +
                "\t1 - Cadastro \n" +
                "\t2 - Consulta");
        opcaoMenu = scanner.nextInt();
        scanner.nextLine();
        String nomeAluno = null, numMatricula = null;


        if (opcaoMenu == 1) {
            System.out.print("Digite o nome do aluno: ");
            nomeAluno = scanner.nextLine();
            System.out.print("\nDigite o número da matrícula: ");
            numMatricula = scanner.nextLine();
            System.out.println("Cadastro efetuado com sucesso!");
        } else if (opcaoMenu == 2) {
            System.out.print("Digite o número da matrícula para consulta: ");
            String consulta = scanner.nextLine();
            if (consulta.equals(numMatricula)) {
                System.out.println(nomeAluno + "\n" + numMatricula);
            } else System.out.println("Número de matrícula inválido");
        } else {
            System.out.println("Opção inválida");
        }
        if (opcaoMenu == 1) {
            System.out.print("Digite o nome do aluno: ");
            nomeAluno = scanner.nextLine();
            System.out.print("\nDigite o número da matrícula: ");
            numMatricula = scanner.nextLine();
            System.out.println("Cadastro efetuado com sucesso!");
        } else if (opcaoMenu == 2) {
            System.out.print("Digite o número da matrícula para consulta: ");
            String consulta = scanner.nextLine();
            if (consulta.equals(numMatricula)) {
                System.out.println(nomeAluno + "\n" + numMatricula);
            } else System.out.println("Número de matrícula inválido");
        } else {
            System.out.println("Opção inválida");
        }
        scanner.close();
    }
}
