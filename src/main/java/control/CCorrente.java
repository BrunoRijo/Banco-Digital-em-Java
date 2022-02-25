package control;

import model.Cliente;
import model.Conta;

public class CCorrente extends Conta {

    public CCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println(" *** Extrato Conta Corrente ***");
        super.getDadosCliente();
    }


}
