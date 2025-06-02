import java.util.ArrayList;
import java.util.Scanner;

public class BancoEstacio {

    public static void main (String args []){

        Scanner leitor = new Scanner(System.in);
        String contaEsperada = "12345";
        String senhaEsperada = "430318";

        System.out.println("===== LOGIN NO SISTEMA =====");
        System.out.print("Digite o número da conta: ");
        String contaDigitada = leitor.nextLine();

        System.out.print("Digite a senha: ");
        String senhaDigitada = leitor.nextLine();

        if (!contaDigitada.equals(contaEsperada) || !senhaDigitada.equals(senhaEsperada)) {
            System.out.println("Número da conta ou senha incorretos. Acesso negado.");
            return;
        }

        String nome = "AMANDA OTTONI-1";
        String tipoDeConta = "Corrente";
        double saldo = 0;
        int opc = 0;
        ArrayList<String> extrato = new ArrayList<>();

        System.out.println("*****************************************");
        System.out.println("""
        
        - B E M   V I N D O -
        
            Nome do cliente: %s 
            Tipo de conta:%s
            Saldo atual: %.2f """ .formatted(nome, tipoDeConta, saldo)
        );
        System.out.println("*****************************************");

        String menu = """
        
        Operações
        
        1 - Consulta saldo
        2 - Depositar
        3 - Transferir
        4 - Sair
        5 - Pagar boleto
        6 - Ver extrato
        
        """;

        while (opc != 4){
            System.out.println(menu);
            System.out.println("Digite a operação desejada !");
            opc = leitor.nextInt();

            if (opc == 1){
                System.out.println("O seu saldo é %.2f\n" .formatted(saldo));
            }
            else if (opc == 2){
                System.out.println("Digite o valor do deposito");
                double depositar = leitor.nextDouble();
                saldo += depositar;
                extrato.add("Depósito de R$ %.2f".formatted(depositar));
                System.out.println("""
                          Deposito realizado com sucesso
                          Saldo atual: %.2f """ .formatted(saldo));
            }
            else if (opc == 3){
                System.out.println("Digite o valor da transferência");
                double transferir = leitor.nextDouble();
                if (saldo < transferir){
                    System.out.println("Transferência não realizada, saldo insuficiente");
                }
                else{
                    saldo -= transferir;
                    extrato.add("Transferência de R$ %.2f".formatted(transferir));
                    System.out.println("""
                       Transferência realizada com sucesso!
                       Saldo atual: %.2f """ .formatted(saldo));
                }
            }
            else if (opc == 5){
                System.out.println("Digite o valor do boleto:");
                double valorBoleto = leitor.nextDouble();
                double taxa = valorBoleto * 0.02;
                double totalPago = valorBoleto + taxa;

                if (saldo < totalPago){
                    System.out.println("Pagamento não realizado. Saldo insuficiente para cobrir o boleto e a taxa.");
                } else {
                    saldo -= totalPago;
                    extrato.add("Pagamento de boleto: R$ %.2f (Taxa: R$ %.2f)".formatted(valorBoleto, taxa));
                    System.out.println("""
                        Boleto pago com sucesso!
                        Valor do boleto: R$ %.2f
                        Taxa aplicada (2%%): R$ %.2f
                        Total debitado: R$ %.2f
                        Saldo atual: R$ %.2f
                        """.formatted(valorBoleto, taxa, totalPago, saldo));
                }
            }
            else if (opc == 6){
                System.out.println("===== EXTRATO DE TRANSAÇÕES =====");
                if (extrato.isEmpty()) {
                    System.out.println("Nenhuma transação realizada ainda.");
                } else {
                    for (String linha : extrato) {
                        System.out.println("- " + linha);
                    }
                }
                System.out.println("==================================");
            }
            else if (opc == 4){
                System.out.println("Obrigado por utilizar nossos serviços.");
            }
            else{
                System.out.println("Opção inválida...");
            }
        }

        System.out.println("FIM DO PROGRAMA");
    }
}
