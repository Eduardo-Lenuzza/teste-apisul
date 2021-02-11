package view;

import java.io.IOException;

import comum.JsonReader;
import model.Elevador;

/**
 *
 * @author elopes
 */
public class View {

    public static void main(String[] args) throws IOException {

        String input = "input.json";

        JsonReader jsonReader = new JsonReader();

        for (Elevador el : jsonReader.readJson(input)) {
            System.out.println(el.toString());
        }
    }
}
