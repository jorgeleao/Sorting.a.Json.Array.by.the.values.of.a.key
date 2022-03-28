package com.intelie;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class Main {

    public static void main(String[] args) {

        Gson gson = new Gson();
        TwoKeyJsonObject[] twoKeyJsonObjectsEntrada = null;
        TwoKeyJsonObject[] twoKeyJsonObjectsSaida = null;
        String jsonString = null;
        String saida = null;

        try (Reader reader = new FileReader("jsonArray.json")) {
            twoKeyJsonObjectsEntrada = gson.fromJson(reader, TwoKeyJsonObject[].class);
            jsonString = gson.toJson(twoKeyJsonObjectsEntrada);
            System.out.println(jsonString);

//            File file = new File("jsonArray.json");
//            jsonString = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
//            System.out.println(jsonString);

            //jsonString = gson.fromJson(reader, TwoKeyJsonObject[].class).toString();


            saida = new ReorderJsonArray().byOneKey(jsonString, "aKey");
            System.out.println(saida);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter("jsonArraySaida.json")) {
            gson.toJson(twoKeyJsonObjectsSaida, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
