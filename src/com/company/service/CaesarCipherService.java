package com.company.service;

import java.util.Locale;
import java.util.regex.Pattern;

public class CaesarCipherService {
    private static final String upperLetters = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String lowerLetters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final char[] upperListLetters = upperLetters.toCharArray();
    private static final char[] lowerListLetters = lowerLetters.toCharArray();
    private static final int ALPHABET_SIZE = upperLetters.length();

    public static String decode(String text, int shift) {
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

    public static String encode(String text, int shift) {
        return decode(text, ALPHABET_SIZE - (shift % ALPHABET_SIZE));
    }


    public static String bruteForceEncode(String text) {
        InputAndOutputService.writeMessage("\nШифрованный текст:\n\"" + text + "\"");
        InputAndOutputService.writeMessage("\nЕсли увидите расшифрованное сообщение, нажмите '1' ");
        InputAndOutputService.writeMessage("\nЕсли сообщение не оказалась расшифрованным, нажмите '0'\n");

        int keyShift = 1;
        String encryptText = null;
        while (keyShift <= 33) {
            encryptText = encode(text, keyShift);
            InputAndOutputService.writeMessage(encryptText);
            int messageFromUser = InputAndOutputService.readInt();
            if (messageFromUser == 1) {
                break;
            }
            keyShift++;
        }
        return encryptText;
    }
}
