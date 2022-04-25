public class Main {
    public static void main(String[] args) {
        Cliente Eduardo = new Cliente();
        Eduardo.setNome("Eduardo");
        Cliente Pedro = new Cliente();
        Pedro.setNome("Pedro");
        
        Conta cc = new ContaCorrente(Eduardo);
        Conta cp = new ContaPoupanca(Pedro);

        cc.depositar(150.60);
        System.out.println("-----------------------------------------------------");
        cc.transferir(100, cp);
        System.out.println("-----------------------------------------------------");

        cc.imprimirInfos();
        cp.imprimirInfos();
    }
}
