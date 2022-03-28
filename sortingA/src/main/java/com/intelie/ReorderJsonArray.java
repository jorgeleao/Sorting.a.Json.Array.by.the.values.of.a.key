package com.intelie;

import com.google.gson.Gson;

import java.util.Locale;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class ReorderJsonArray {
    Gson gson = new Gson();

    /**
     * TODO:
     * - Must accept repeated key values
     * - Must process json objects of arbitrary structure/content
     * - Must include objects without the reference key at the end
     * @param jsonString
     * @param key
     * @return
     */
    public String byOneKey(String jsonString, String key) {

        TreeMap<String, OneKeyObjectsJsonArray> treeMap = new TreeMap<>();
        OneKeyObjectsJsonArray[] oneKeyJsonObjectsInput =
                gson.fromJson(jsonString, OneKeyObjectsJsonArray[].class);

        stream(oneKeyJsonObjectsInput)
                .map(x -> {
                    if(x.getaKey()==null){
                        treeMap.put("zzzzzzzzzzzz", x);
                    }else {
                        String str = x.getaKey()
                                .trim()
                                .toUpperCase(Locale.ROOT);
                        str = RemoveDiacriticals.remove(str);
                        treeMap.put(str, x);
                    }
                    return null;
                })
                .collect(Collectors.toList());

        OneKeyObjectsJsonArray[] oneKeyJsonObjectsOutput =
                new OneKeyObjectsJsonArray[oneKeyJsonObjectsInput.length];
        int i = 0;
        for (String s : treeMap.keySet()) {
            oneKeyJsonObjectsOutput[i] = treeMap.get(s);
            i++;
        }

        return gson.toJson(oneKeyJsonObjectsOutput);
    }
}

class OneKeyObjectsJsonArray {
    private String aKey;
    private String zzz;

    public String getaKey() {
        return aKey;
    }
}
