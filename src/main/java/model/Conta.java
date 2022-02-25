package model;

import interfaces.iContaBancaria;

public abstract class Conta implements iContaBancaria {

    private static final String AGENCIA_PADRAO = "1";
    private static int SEQUENCIAL = 1;

    private String agencia;
    private int numero;
    private double saldo;
    protected Cliente cliente;

    public Conta(){}

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public String getAgencia() {
        return agencia;
    }

    public void getDadosCliente() {
        System.out.println("Títular: "+this.cliente.getClientName()
                +", Agencia: "+ this.agencia
                +" : Conta "+ this.numero
                +" saldo :"+this.getSaldo());
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino){
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void ImprimeInfosComuns() {
        System.out.println("Titular: "+cliente.name);
        System.out.println("CPF: "+ cliente.CPF);
        System.out.println("Agencia: "+ this.agencia);
        System.out.println("Numero: "+this.numero);
        System.out.println(String.format("Saldo:" + this.saldo));
    }

}
