import java.util.Scanner;

public class MenuSimples01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcaoMenu;

        System.out.println("Digite uma opção: \n" +
                "\t1 - Cadastro \n" +
                "\t2 - Consulta");
        opcaoMenu = scanner.nextInt();
        scanner.nextLine();
        String nomeAluno = null, numMatricula = null;


        switch (opcaoMenu) {
            case 1:
                System.out.print("Digite o nome do aluno: ");
                nomeAluno = scanner.nextLine();
                System.out.print("\nDigite o número da matrícula: ");
                numMatricula = scanner.nextLine();
                System.out.println("Cadastro efetuado com sucesso!");
                break;
            case 2:
                System.out.print("Digite o número da matrícula para consulta: ");
                String consulta = scanner.nextLine();
                if (nomeAluno!=null && numMatricula!=null) {
                    if (consulta.equals(numMatricula)) {
                        System.out.println(nomeAluno + "\n" + numMatricula);
                    } else System.out.println("Número de matrícula inválido");

                }
                break;
            default:
                System.out.println("Opção inválida");
        }

        scanner.close();
    }
}
