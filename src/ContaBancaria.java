public class ContaBancaria {
    private double saldo;
    private double chequeEspecial;

    //Getters-Setters
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getChequeEspecial() {
        if (saldo >= 500) {
            return saldo * 0.5;
        } else {
            return saldo * 0.1;
        }
    }

    //METODOS
    public void semSaldo() {
        System.out.println("Você não tem saldo nem limite para esta operação");
    }

    public String consultaSaldo() {
        return String.format("Saldo: R$ %.2f (Cheque Especial: R$ %.2f)", saldo, chequeEspecial);
    }

    public void consultaChequeEspecial () {
        if (saldo >= 500) {
            chequeEspecial = saldo * 0.5;
        } else if (saldo < 500 && saldo >= 1){
            chequeEspecial = saldo * 0.1;
        } else {
            chequeEspecial = 0;
        }
    }

    public String depositaDinheiro (double deposito) {
        saldo += deposito;
        consultaChequeEspecial();
        return consultaSaldo();
    }

    public String sacaDinheiro(double saque) {
        if (saldo > saque) {
            saldo -= saque;
            System.out.println("Saque Realizado com Sucesso!");
            return consultaSaldo();
        } else if (saldo + chequeEspecial >= saque) {
            saldo -= saque;
            chequeEspecial += saldo;
            System.out.println("Saque Realizado com Sucesso!");
            return consultaSaldo();
        } else if (saldo <= 0 && chequeEspecial >= saque) {
            chequeEspecial -= saque;
            saldo -= saque;
            System.out.println("Saque Realizado com Sucesso!");
            return consultaSaldo();
        } else {
            semSaldo();
            return consultaSaldo();
        }
    }

    public String pagaBoleto (double valorBoleto) {
        if (saldo > valorBoleto) {
            saldo -= valorBoleto;
            System.out.println("Boleto Pago!");
            return consultaSaldo();
        } else if (saldo + chequeEspecial >=  valorBoleto) {
            saldo -= valorBoleto;
            chequeEspecial += saldo;
            System.out.println("Boleto Pago!");
            return consultaSaldo();
        } else if (saldo <= 0 && chequeEspecial >= valorBoleto) {
            chequeEspecial -= valorBoleto;
            saldo -= valorBoleto;
            System.out.println("Saque Realizado com Sucesso!");
            return consultaSaldo();
        } else {
            semSaldo();
            return consultaSaldo();
        }
    }

    public String usandoChequeEspecial () {
        if (saldo < 0) {
            System.out.println("Você está usando o cheque especial");
            return consultaSaldo();
        } else {
            System.out.println("Você não está usando o cheque especial");
            return consultaSaldo();
        }
    }
}
