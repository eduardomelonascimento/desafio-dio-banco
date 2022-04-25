public abstract class Conta implements iConta {

    private static final int AGENCIA = 1;
    private static int SEQUENCIAL = 1;
    private final String ERROR_MESSAGE = "Saldo insuficiente para realizar essa operação.";
    private final String SUCCESS_MESSAGE = "Operação realizada realizada com sucesso.";
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println(ERROR_MESSAGE);
        } else {
            saldo -= valor;
            System.out.println(SUCCESS_MESSAGE + " Saldo = " + getSaldo());
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.println(SUCCESS_MESSAGE + " Saldo = " + getSaldo());
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (valor > this.saldo) {
            System.out.println(ERROR_MESSAGE);
        } else {
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Transferência a partir da conta " + this.numero + " no valor de " + valor + " realizada com sucesso para a conta " + contaDestino.numero);
        }
    }

    protected void imprimirInfos() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Número: %d", this.numero));
        System.out.println(String.format("Número da Conta: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }


}
