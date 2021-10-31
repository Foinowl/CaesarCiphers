package com.company.repository;

import java.util.Locale;
import java.util.regex.Pattern;

public class RuCaesarCipherRepository implements CaesarCipherRepository{
    private static final String upperLetters = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String lowerLetters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final char[] upperListLetters = upperLetters.toCharArray();
    private static final char[] lowerListLetters = lowerLetters.toCharArray();
    private static final int ALPHABET_SIZE = upperLetters.length();

    public RuCaesarCipherRepository() {
    }

    private String decode(String text, int shift) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (!(Pattern.matches("[&*^$#@;:.,!?\\-\\s]", String.valueOf(character)))) {
                int alphabetPosition = upperLetters.indexOf(String.valueOf(character).toUpperCase(Locale.ROOT));
                int newAlphabetPosition = (alphabetPosition + shift) % ALPHABET_SIZE;
                stringBuilder.append(Character.isUpperCase(character)
                        ? upperListLetters[newAlphabetPosition]
                        : lowerListLetters[newAlphabetPosition]);
            } else {
                stringBuilder.append(character);
            }
        }

        return stringBuilder.toString();
    }

    public String encode(String text, int shift) {
        return decode(text, ALPHABET_SIZE - (shift % ALPHABET_SIZE));
    }
}
