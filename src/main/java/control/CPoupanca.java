package control;

import model.Cliente;
import model.Conta;

public class CPoupanca extends Conta {


    public CPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println(" *** Extrato Conta Corrente ***");
        super.ImprimeInfosComuns();
    }
}
