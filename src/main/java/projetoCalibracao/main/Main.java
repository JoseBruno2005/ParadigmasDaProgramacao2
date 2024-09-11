package projetoCalibracao.main;


import projetoCalibracao.domain.Calibrador;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, String> mapNumerosCombinados = new HashMap<>();
        mapNumerosCombinados.put("twone", "21");
        mapNumerosCombinados.put("fiveight", "58");
        mapNumerosCombinados.put("oneight", "18");
        mapNumerosCombinados.put("nineight", "98");
        mapNumerosCombinados.put("sevenine", "79");
        mapNumerosCombinados.put("eightwo", "82");
        mapNumerosCombinados.put("eighthree", "83");

        Map<String, String> mapNumerosSozinhos = new HashMap<>();
        mapNumerosSozinhos.put("one", "1");
        mapNumerosSozinhos.put("two", "2");
        mapNumerosSozinhos.put("three", "3");
        mapNumerosSozinhos.put("four", "4");
        mapNumerosSozinhos.put("five", "5");
        mapNumerosSozinhos.put("six", "6");
        mapNumerosSozinhos.put("seven", "7");
        mapNumerosSozinhos.put("eight", "8");
        mapNumerosSozinhos.put("nine", "9");


        List<String> numerosSozinhos = new ArrayList<>(mapNumerosSozinhos.keySet());
        Collections.sort(numerosSozinhos, (a, b) -> mapNumerosSozinhos.get(a).compareTo(mapNumerosSozinhos.get(b)));
        System.out.println(numerosSozinhos);

        List<String> numerosCombinados = new ArrayList<>(mapNumerosCombinados.keySet());
        System.out.println(numerosCombinados);


        var calobrador1 = new Calibrador();
        calobrador1.calibrarNumerosELetras(mapNumerosSozinhos, mapNumerosCombinados, numerosSozinhos, numerosCombinados);
        System.out.println(calobrador1.calibrarSoNumeros());
    }
}