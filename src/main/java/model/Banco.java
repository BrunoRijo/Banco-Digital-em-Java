package model;

import java.util.ArrayList;
import java.util.List;

public class Banco{

    private static final String BANK_NAME = "BruNubank";
    public List<Conta> contas = new ArrayList<>();

    public void addConta(Conta conta){
        contas.add(conta);
    }

    public void printClientList(){
        for (int i=0; i<contas.size();i++){
            contas.get(i).getDadosCliente();
        }
    }

    public boolean verifyClient(int numConta){
        boolean result = false;
        //for (int i=0; i<contas.size();i++){}
        int i = 0;
        while (i<contas.size()){
            if(numConta==contas.get(i).getNumero()){
                System.out.println("Cliente encontrado, aguarde um momento.");
                result = true;
                break;
            } else {
                i++;
                result = false;
            }
        }
        return result;
    }

    public Conta buscaConta (int numeroConta){
        Conta contaRetorno = null;
        for (int i=0; i<contas.size();i++) {
            if (numeroConta == contas.get(i).getNumero()) {
                return contaRetorno = contas.get(i);
            }
        }
        return contaRetorno;
    }

}
