package com.company.service;

import java.awt.geom.RectangularShape;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CaesarChiperService {
    private static final char FIRST_LETTER = 'а';
    private static final char LAST_LETTER = 'я';
    private static final int ALPHABET_SIZE = LAST_LETTER - FIRST_LETTER + 1;


    public static String decode(String text, int shift) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (!(Pattern.matches("[.!?\\-\\s]", String.valueOf(character)))) {
                int originalAlphabetPosition = character - FIRST_LETTER;
                int newAlphabetPosition = (originalAlphabetPosition + shift) % ALPHABET_SIZE;
                stringBuilder.append((char) (FIRST_LETTER + newAlphabetPosition));
            } else {
                stringBuilder.append(character);
            }
        }

        return  stringBuilder.toString();
    }

    public String encode(String text, int shift) {
        StringReader stringReader = new StringReader(text);
        return  "2";
    }
}
