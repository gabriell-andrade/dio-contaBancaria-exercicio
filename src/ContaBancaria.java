public class ContaBancaria {
    private double saldo;
    private final double chequeEspecialInicial;
    private double chequeEspecialDisponivel;

    public ContaBancaria(double depositoInicial) {
        this.saldo = depositoInicial;
        if (depositoInicial <= 500) {
            this.chequeEspecialInicial = 50;
        } else {
            this.chequeEspecialInicial = depositoInicial * 0.5;
        }
        this.chequeEspecialDisponivel = chequeEspecialInicial;
    }

    public String consultaSaldo() {
        taxaChequeEspecial();
        return String.format("Saldo: R$ %.2f (Cheque Especial: R$ %.2f)", saldo, chequeEspecialDisponivel);
    }

    public String consultaChequeEspecial() {
        return String.format("Cheque Especial: R$ %.2f", chequeEspecialDisponivel);
    }

    public String depositaDinheiro(double deposito) {
        //todo: tem que recuperar primeiro o cheque especial (se estiver sendo usado) e depois adicionar saldo
        if (saldo >= 0) { //deposito normal: tem saldo positivo
            saldo += deposito;
        } else {
            if (saldo + deposito >= 0) { //recupera chq esp
                chequeEspecialDisponivel = chequeEspecialInicial;
                saldo += deposito;
            } else { //não recupera total
                // -70 0 +50  >> -20 30 0

                saldo += deposito;
                chequeEspecialDisponivel = saldo + chequeEspecialInicial;
            }
        }
        return consultaSaldo();
    }

    public String sacaDinheiro(double saque) {
        if (saldo > saque) {
            saldo -= saque;
            System.out.println("Saque Realizado com Sucesso!");
        } else if (saldo + chequeEspecialDisponivel >= saque) {
            saldo -= saque;
            chequeEspecialDisponivel += saldo;
            System.out.println("Saque Realizado com Sucesso!");
        } else if (saldo <= 0 && chequeEspecialDisponivel >= saque) {
            chequeEspecialDisponivel -= saque;
            saldo -= saque;
            System.out.println("Saque Realizado com Sucesso!");
        } else {
            System.out.println("Você não tem saldo nem limite para esta operação");
        }
        return consultaSaldo();
    }

    public String pagaBoleto(double valorBoleto) {
        if (saldo > valorBoleto) {
            saldo -= valorBoleto;
            System.out.println("Boleto Pago!");
        } else if (saldo + chequeEspecialDisponivel >=  valorBoleto) {
            saldo -= valorBoleto;
            chequeEspecialDisponivel += saldo;
            System.out.println("Boleto Pago!");
        } else if (saldo <= 0 && chequeEspecialDisponivel >= valorBoleto) {
            chequeEspecialDisponivel -= valorBoleto;
            saldo -= valorBoleto;
            System.out.println("Saque Realizado com Sucesso!");
        } else {
            System.out.println("Você não tem saldo nem limite para esta operação");
        }
        return consultaSaldo();
    }

    public String usaChequeEspecial() {
        if (saldo < 0) {
            System.out.println("Você está usando o cheque especial");
        } else {
            System.out.println("Você não está usando o cheque especial");
        }
        return consultaSaldo();
    }

    public void taxaChequeEspecial() {
        if (saldo < 0) {
            double taxa = Math.abs(saldo) * 0.2;
            saldo -= taxa;
            chequeEspecialDisponivel -= taxa;
            if (chequeEspecialDisponivel < 0) {
                chequeEspecialDisponivel = 0;
            }
            System.out.printf("Foi cobrada uma taxa de R$ %.2f por estar usando o Cheque Especial\n", taxa);
        }
    }
}
