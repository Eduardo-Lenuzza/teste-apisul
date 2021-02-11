package com.elopes.testeapisul;

import java.security.KeyStore.Entry;
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

        /*
         * sorted.forEach(item -> { System.out.println(" Andar " + item.getKey() +
         * " quantiddade " + item.getValue()); });
         */
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

        /*
         * sorted.forEach(item -> { System.out.println(" Elevador " + item.getKey() +
         * " quantiddade " + item.getValue()); });
         */
        sorted.forEach(item -> elevadoresOrdenados.add(item.getKey()));

        return elevadoresOrdenados;
    }

    @Override
    public List<Character> periodoMaiorFluxoElevadorMaisFrequentado() {
        return null;
    }

    @Override
    public List<Character> elevadorMenosFrequentado() {
        return null;
    }

    @Override
    public List<Character> periodoMenorFluxoElevadorMenosFrequentado() {
        return null;
    }

    @Override
    public List<Character> periodoMaiorUtilizacaoConjuntoElevadores() {
        return null;
    }

    @Override
    public float percentualDeUsoElevadorA() {
        return 0;
    }

    @Override
    public float percentualDeUsoElevadorB() {
        return 0;
    }

    @Override
    public float percentualDeUsoElevadorC() {
        return 0;
    }

    @Override
    public float percentualDeUsoElevadorD() {
        return 0;
    }

    @Override
    public float percentualDeUsoElevadorE() {
        return 0;
    }

}
