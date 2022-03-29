package com.intelie;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {

        String jsonString = null;
        String saida = null;

        try {
            File file = new File("jsonArray.json");
            jsonString = FileUtils.readFileToString(file, StandardCharsets.UTF_8)
                                  .replaceAll("\\n", "");

            saida = new ReorderJsonArray().byOneKey(jsonString, "aKey");

            System.out.println(saida);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
