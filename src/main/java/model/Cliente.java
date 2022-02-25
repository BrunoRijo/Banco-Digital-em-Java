package model;

public class Cliente extends Pessoa{

    private int id_conta;

    public Cliente(String name, String cpf) {
        this.id_conta = id_conta++;
        super.name = name;
        super.CPF = cpf;
    }

    public String getClientName() {
        return super.name;
    }
}
