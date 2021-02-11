package view;

import java.io.IOException;

import com.elopes.testeapisul.IElevadorServiceDAO;

import comum.JsonReader;
import model.Elevador;

/**
 *
 * @author elopes
 */
public class View {

    public static void main(String[] args) throws IOException {

        IElevadorServiceDAO eleServ = new IElevadorServiceDAO();

        System.out.println("\n");

        for (int andar : eleServ.andarMenosUtilizado()) {
            System.out.print(andar + " ");
        }
        System.out.println("\n");
        
        for (char elevador : eleServ.elevadorMaisFrequentado()) {
            System.out.print(elevador + " ");
        }
        System.out.println("\n");
    }
}
