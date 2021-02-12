package com.elopes.testeapisul;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import comum.JsonReader;
import model.Elevador;

/**
 *
 * @author elopes
 */
public class IElevadorServiceDAO extends JsonReader implements IElevadorService {

    @Override
    public List<Integer> andarMenosUtilizado() {
        List<Elevador> listElev = readJson();
        List<Integer> andares = new ArrayList<>();
        List<Integer> andaresOrdenados = new ArrayList<>();
        Map<Integer, Integer> toMap = new HashMap<>();
        int andarMaisAlto;

        listElev.stream().forEach(a -> andares.add(a.getAndar()));
        Collections.sort(andares);
        andarMaisAlto = Collections.max(andares);

        for (int i = 0; i < andarMaisAlto; i++) {
            toMap.put(i, Collections.frequency(andares, i));
        }
        Stream<Map.Entry<Integer, Integer>> sorted = toMap.entrySet().stream().sorted(Map.Entry.comparingByValue());

        sorted.forEach(item -> andaresOrdenados.add(item.getKey()));

        return andaresOrdenados;
    }

    @Override
    public List<Character> elevadorMaisFrequentado() {
        List<Elevador> listElev = readJson();
        List<Character> elevadores = new ArrayList<>();
        List<Character> elevadoresOrdenados = new ArrayList<>();
        Map<Character, Integer> toMap = new HashMap<>();

        listElev.stream().forEach(a -> elevadores.add(a.getElevador()));
        Collections.sort(elevadores);

        toMap.put('A', Collections.frequency(elevadores, 'A'));
        toMap.put('B', Collections.frequency(elevadores, 'B'));
        toMap.put('C', Collections.frequency(elevadores, 'C'));
        toMap.put('D', Collections.frequency(elevadores, 'D'));
        toMap.put('E', Collections.frequency(elevadores, 'E'));

        Stream<Map.Entry<Character, Integer>> sorted = toMap.entrySet().stream().sorted(Map.Entry.comparingByValue());

        sorted.forEach(item -> elevadoresOrdenados.add(item.getKey()));
        Collections.reverse(elevadoresOrdenados);

        return elevadoresOrdenados;
    }

    @Override
    public List<Character> periodoMaiorFluxoElevadorMaisFrequentado() {
        char elevadorMaisFreq = this.elevadorMaisFrequentado().get(0);
        List<Character> listTurno = this.turnoFrequencia(elevadorMaisFreq);

        Collections.reverse(listTurno);

        return listTurno;
    }

    @Override
    public List<Character> elevadorMenosFrequentado() {
        List<Character> elevMenosFreq = new ArrayList<>();
        elevMenosFreq = this.elevadorMaisFrequentado();

        Collections.reverse(elevMenosFreq);

        return elevMenosFreq;
    }

    @Override
    public List<Character> periodoMenorFluxoElevadorMenosFrequentado() {
        char elevadorMenosFreq = this.elevadorMenosFrequentado().get(0);
        List<Character> listTurno = this.turnoFrequencia(elevadorMenosFreq);

        return listTurno;
    }

    @Override
    public List<Character> periodoMaiorUtilizacaoConjuntoElevadores() {
        List<Character> listTurno = this.turnoFrequencia(' ');

        Collections.reverse(listTurno);

        return listTurno;
    }

    @Override
    public float percentualDeUsoElevadorA() {
        return calculaPercentual('A');
    }

    @Override
    public float percentualDeUsoElevadorB() {
        return calculaPercentual('B');
    }

    @Override
    public float percentualDeUsoElevadorC() {
        return calculaPercentual('C');
    }

    @Override
    public float percentualDeUsoElevadorD() {
        return calculaPercentual('D');
    }

    @Override
    public float percentualDeUsoElevadorE() {
        return calculaPercentual('E');
    }

    public void getMensagem(String mensagem) {
        System.out.println("\n=====================================================");
        if (!mensagem.equals(" "))
            System.out.println(mensagem);
    }

    private List<Character> turnoFrequencia(char elevador) {
        List<Elevador> listElev = readJson();
        List<Character> listTurno = new ArrayList<>();
        Map<Character, Integer> turnoFrequencia = new HashMap<>();
        if (elevador != ' ') {
            listElev.stream().filter(item -> item.getElevador().equals(elevador))
                    .forEach(e -> listTurno.add(e.getTurno()));
        } else {
            listElev.stream().forEach(item -> listTurno.add(item.getTurno()));
        }

        turnoFrequencia.put('M', Collections.frequency(listTurno, 'M'));
        turnoFrequencia.put('N', Collections.frequency(listTurno, 'N'));
        turnoFrequencia.put('V', Collections.frequency(listTurno, 'V'));

        Stream<Map.Entry<Character, Integer>> sorted = turnoFrequencia.entrySet().stream()
                .sorted(Map.Entry.comparingByValue());
        listTurno.clear();

        sorted.forEach(item -> listTurno.add(item.getKey()));

        return listTurno;
    }

    private float calculaPercentual(char elevador) {
        List<Elevador> listElev = readJson();
        List<Character> elev = new ArrayList<>();
        int total_de_uso_totos;
        float total_de_uso_cada;
        String percentualFormatado;

        listElev.stream().forEach(item -> elev.add(item.getElevador()));
        total_de_uso_totos = elev.size();

        total_de_uso_cada = Collections.frequency(elev, elevador);

        total_de_uso_cada = (total_de_uso_cada * 100) / total_de_uso_totos;

        percentualFormatado = String.format("%.2f", total_de_uso_cada);

        total_de_uso_cada = Float.valueOf(percentualFormatado.replaceAll(",", "."));

        return total_de_uso_cada;
    }

}
