import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        ContaBancaria conta = new ContaBancaria();

        while (opcao != 7) {
            System.out.println("""
                    Escolha uma opção:
                    1. Consultar Saldo
                    2. Consultar Cheque Especial
                    3. Depositar Dinheiro
                    4. Sacar Dinheiro
                    5. Pagar um Boleto
                    6. Verificar se a conta está usando cheque especial
                    7. Sair
                    """);
            opcao = sc.nextInt();

            switch (opcao) {
                case 1, 2:
                    System.out.println(conta.consultaSaldo());
                    break;
                case 3:
                    System.out.println("Qual o valor do depósito?");
                    double deposito = sc.nextDouble();
                    System.out.println(conta.depositaDinheiro(deposito));
                    break;
                case 4:
                    System.out.println("Qual o valor do saque? ");
                    double saque = sc.nextDouble();
                    System.out.println(conta.sacaDinheiro(saque));
                    break;
                case 5:
                    System.out.println("Qual o valor do boleto?");
                    double valorBoleto = sc.nextDouble();
                    conta.pagaBoleto(valorBoleto);
                    break;
                case 6:
                    conta.usandoChequeEspecial();
                    break;
                case 7:
                    System.out.println("Encerrando o Programa! Obrigado!");
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        }
        sc.close();
    }
}
