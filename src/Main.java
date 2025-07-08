import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        System.out.println("Digite o valor do depósito inicial para abrir sua conta: ");
        double depositoInicial = sc.nextDouble();
        ContaBancaria conta = new ContaBancaria(depositoInicial);
        System.out.println("===========================================================");

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
                case 1:
                    System.out.println(conta.consultaSaldo());
                    System.out.println("===========================================================");
                    break;
                case 2:
                    System.out.println(conta.consultaChequeEspecial());
                    System.out.println("===========================================================");
                    break;
                case 3:
                    System.out.println("Qual o valor do depósito?");
                    double deposito = sc.nextDouble();
                    System.out.println(conta.depositaDinheiro(deposito));
                    System.out.println("===========================================================");
                    break;
                case 4:
                    System.out.println("Qual o valor do saque? ");
                    double saque = sc.nextDouble();
                    System.out.println(conta.sacaDinheiro(saque));
                    System.out.println("===========================================================");
                    break;
                case 5:
                    System.out.println("Qual o valor do boleto?");
                    double valorBoleto = sc.nextDouble();
                    System.out.println(conta.pagaBoleto(valorBoleto));
                    System.out.println("===========================================================");
                    break;
                case 6:
                    System.out.println(conta.usaChequeEspecial());
                    System.out.println("===========================================================");
                    break;
                case 7:
                    System.out.println("Encerrando o Programa! Obrigado!");
                    System.out.println("===========================================================");
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    System.out.println("===========================================================");
            }
        }
        sc.close();
    }
}
