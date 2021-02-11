package comum;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Elevador;

/**
 *
 * @author elopes
 */
public class JsonReader {

    public List<Elevador> readJson(String input) throws IOException {
        List<Elevador> ListElevador = new ArrayList<>();
        Elevador el;
        String output = String.join("", Files.readAllLines(Paths.get(input), StandardCharsets.UTF_8));
        output = output.replaceAll(" ", "");
        JSONArray jsonArray = new JSONArray(output);

        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject obj = jsonArray.getJSONObject(i);
            int andar = obj.getInt("andar");
            String elevador = obj.getString("elevador");
            String turno = obj.getString("turno");

            el = new Elevador(andar, elevador, turno);
            ListElevador.add(el);
        }
        return ListElevador;
    }
}
