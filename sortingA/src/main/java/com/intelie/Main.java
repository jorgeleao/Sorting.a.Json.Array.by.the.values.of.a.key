package com.intelie;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Locale;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Main {

    public static void main(String[] args) {

        Gson gson = new Gson();
        TwoKeyJsonObject[] twoKeyJsonObjectsEntrada = null;
        TwoKeyJsonObject[] twoKeyJsonObjectsSaida = null;
        String saida = null;

        try (Reader reader = new FileReader("jsonArray.json")) {
            twoKeyJsonObjectsEntrada = gson.fromJson(reader, TwoKeyJsonObject[].class);
            TreeMap<String, TwoKeyJsonObject> firstMap = new TreeMap<>();
            stream(twoKeyJsonObjectsEntrada)
                    .map(x -> { String str = x.getaKey()
                                              .trim()
                                              .toUpperCase(Locale.ROOT);
                                str = RemoveDiacriticals.remove(str);
                                firstMap.put(str,x);
                                return null;})
                    .collect(Collectors.toList());

            twoKeyJsonObjectsSaida = new TwoKeyJsonObject[twoKeyJsonObjectsEntrada.length];
            int i = 0;
            for (String s : firstMap.keySet()) {
                System.out.println(s);
                twoKeyJsonObjectsSaida[i] = firstMap.get(s);
                i++;
            }
            saida = gson.toJson(twoKeyJsonObjectsSaida);
            System.out.println(saida);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter("jsonArraySaida.json")){
            gson.toJson(twoKeyJsonObjectsSaida, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
