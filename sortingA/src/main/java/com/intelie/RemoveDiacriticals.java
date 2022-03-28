package com.intelie;

import java.text.Normalizer;

public class RemoveDiacriticals {

        public static String remove(final String input) {
            if (input == null) return null;
            final String decomposed = Normalizer.normalize(input, Normalizer.Form.NFD);
            String final2 = decomposed.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
            final2 = final2.replace("'", "");
            return final2;
        }
    }

