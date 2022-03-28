package com.intelie;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Locale;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Gson gson = new Gson();
        TwoKeyJsonObject[] twoKeyJsonObjectsSaida = null;
        String saida = null;
        try (Reader reader = new FileReader("jsonArray.json")) {
            TwoKeyJsonObject[] twoKeyJsonObjects =
                    gson.fromJson(reader, TwoKeyJsonObject[].class);
            TreeMap<String, TwoKeyJsonObject> firstMap = new TreeMap<>();
            stream(twoKeyJsonObjects)
                    .map(x -> { String str = RemoveDiacriticals.remove(x.getaKey().trim().toUpperCase(Locale.ROOT));
                                firstMap.put(str,x);
                                return null;})
                    .collect(Collectors.toList());
            twoKeyJsonObjectsSaida = new TwoKeyJsonObject[twoKeyJsonObjects.length];
            int i = 0;
            for (String s : firstMap.keySet()) {
                System.out.println(s);
                twoKeyJsonObjectsSaida[i] = firstMap.get(s);
                i++;
            }
            saida = gson.toJson(twoKeyJsonObjectsSaida);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileWriter writer = new FileWriter("jsonArraySaida.json")){
            System.out.println(saida);
            gson.toJson(twoKeyJsonObjectsSaida, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
