package View;

import interfaces.iView;
import model.Banco;
import model.Cliente;
import model.Conta;

import java.util.Scanner;

public class View implements iView{

    Scanner ler = new Scanner(System.in);

    @Override
    public void exibirMenu(Banco banco, Cliente titular, Conta conta) {
        System.out.println("Olá "+titular.getClientName()+" Bem Vindo ao BruNubank");
        int opcao = novaOpcao();
        while(opcao!=6){
            if(opcao>6) {
                System.out.println("Opção inválida");
                opcao = novaOpcao();
            }
            else{
                if (opcao==1) {
                    System.out.println("Informe o valor que deseja sacar:");
                    double valor = ler.nextDouble();
                    if(valor>conta.getSaldo()){
                        System.out.println("Saldo insuficiente");
                        opcao=novaOpcao();
                    } else{
                        saque(conta, valor);
                        opcao = novaOpcao();
                    }
                }
                else if (opcao==2){
                    System.out.println("Informe o valor que deseja depositar:");
                    double valor = ler.nextDouble();
                    if (valor<0.0){
                        System.out.println("Digite um valor válido");
                    } else {
                        depositar(conta, valor);
                        opcao = novaOpcao();
                    }
                }
                else if (opcao==3){
                    System.out.println("Informe o valor que deseja transferir: ");
                    double valor = ler.nextDouble();
                    if (valor<0) {
                        System.out.println("Digita um valor acima de 0");
                    }
                    System.out.println("Informe o ID da conta do destinatario: ");
                    int recebedor = ler.nextInt();

                    if (banco.verifyClient(recebedor)){
                       transferir(conta,valor,banco.buscaConta(recebedor));
                    } else {
                       System.out.println("Cliente não encontrado");
                       banco.printClientList();
                    }
                    opcao = novaOpcao();
                }
                else if (opcao==4){
                    conta.imprimirExtrato();
                    opcao = novaOpcao();
                } else if (opcao==5) {
                    banco.printClientList();
                    opcao = novaOpcao();
                }
                else {
                    System.out.println("saindo");
                    break;
                }
            }

        }
    }

    public int novaOpcao(){
        System.out.println("------BRUNUBANK -----------");
        System.out.println("1 = Efetuar saque");
        System.out.println("2 = Efetuar depósito");
        System.out.println("3 = Efetuar transferência");
        System.out.println("4 = Visualizar extrato");
        System.out.println("5 = Visualizar lista de clientes");
        System.out.println("6 = sair");
        System.out.print("Digite a opção desejada: ");
        int opcao = ler.nextInt();
        return opcao;
    }

    public void saque(Conta conta, double valor) {
        conta.sacar(valor);
        System.out.println("Saque efetuado com sucesso, seu novo saldo é:"+conta.getSaldo());
    }

    public void depositar(Conta conta, double valor) {
        conta.depositar(valor);
        System.out.println("Depósito efetuado com sucesso, seu novo saldo é:"+conta.getSaldo());
    }

    public void transferir(Conta conta, double valor, Conta contaRecebedora){
        conta.transferir(valor, contaRecebedora);
    }
}
