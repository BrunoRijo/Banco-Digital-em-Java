import View.View;
import control.CCorrente;
import control.CPoupanca;
import model.Banco;
import model.Cliente;
import model.Conta;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Banco banco = new Banco();

        Cliente c1 = new Cliente("Bruno", "000.000.000-00");
        Cliente c2 = new Cliente ("Francisco", "999.999.999.99");

        Conta cc = new CCorrente(c1);
        Conta pp = new CPoupanca(c2);

        banco.addConta(cc);
        banco.addConta(pp);

        View operacao = new View();

        operacao.exibirMenu(banco, c1,cc);
    }
}
