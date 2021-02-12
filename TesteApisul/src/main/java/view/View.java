package view;

import java.io.IOException;

import com.elopes.testeapisul.IElevadorServiceDAO;

import comum.Constantes;

/**
 *
 * @author elopes
 */
public class View extends Constantes {

    public static void main(String[] args) throws IOException {

        IElevadorServiceDAO eleServ = new IElevadorServiceDAO();

        eleServ.getMensagem(ANDAR_CRESCENTE);
        for (int andar : eleServ.andarMenosUtilizado()) {
            System.out.print(andar + "º ");
        }
        eleServ.getMensagem(ELEVADOR_DECRESCENTE);

        for (char elevador : eleServ.elevadorMaisFrequentado()) {
            System.out.print(elevador + " ");
        }
        eleServ.getMensagem(" ");

        System.out.println(ELEVADOR_MAIS + eleServ.elevadorMaisFrequentado().get(0) + PERIODO_MAIS
                + eleServ.periodoMaiorFluxoElevadorMaisFrequentado().get(0));

        eleServ.getMensagem(ELEVADOR_CRESCENTE);

        for (char elevador : eleServ.elevadorMenosFrequentado()) {
            System.out.print(elevador + " ");
        }

        eleServ.getMensagem(" ");

        System.out.println(ELEVADOR_MENOS + eleServ.elevadorMenosFrequentado().get(0) + PERIODO_MENOS
                + eleServ.periodoMenorFluxoElevadorMenosFrequentado().get(0));

        eleServ.getMensagem(" ");

        System.out.println(MAIOR_FLUXO + eleServ.periodoMaiorUtilizacaoConjuntoElevadores().get(0));

        eleServ.getMensagem(" ");

        System.out.println(PER_A + eleServ.percentualDeUsoElevadorA() + "%");

        eleServ.getMensagem(" ");

        System.out.println(PER_B + eleServ.percentualDeUsoElevadorB() + "%");

        eleServ.getMensagem(" ");

        System.out.println(PER_C + eleServ.percentualDeUsoElevadorC() + "%");

        eleServ.getMensagem(" ");

        System.out.println(PER_D + eleServ.percentualDeUsoElevadorD() + "%");

        eleServ.getMensagem(" ");

        System.out.println(PER_E + eleServ.percentualDeUsoElevadorE() + "%");

        eleServ.getMensagem(" ");

    }
}
