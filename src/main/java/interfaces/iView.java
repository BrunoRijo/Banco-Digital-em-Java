package interfaces;

import model.Banco;
import model.Cliente;
import model.Conta;

public interface iView {

    void exibirMenu(Banco banco, Cliente cliente, Conta conta);

}
