✅ Resumo do Código BancoEstacio
Login do usuário:

Solicita número da conta e senha.

Verifica se estão corretos, senão encerra.

Dados da conta:

Nome do cliente, tipo de conta e saldo iniciam com valores fixos.

Menu de operações (loop até sair):

Exibe opções:
1 - Saldo
2 - Depositar
3 - Transferir
4 - Sair
5 - Pagar boleto
6 - Ver extrato

Operações:

1. Consulta saldo: mostra o valor atual.

2. Depósito: adiciona valor ao saldo e registra no extrato.

3. Transferência: debita valor (se tiver saldo) e registra no extrato.

5. Pagamento de boleto:

Solicita valor.

Calcula taxa de 2%.

Debita total (boleto + taxa) se houver saldo.

Registra no extrato.

6. Extrato: mostra todas as transações realizadas.

4. Sair: encerra o programa.

Histórico (ArrayList<String>):

Armazena descrição de cada transação realizada.
