package com.company.service;

import java.util.regex.Pattern;

public class CaesarCipherService {
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

    public static String encode(String text, int shift) {
        return decode(text, ALPHABET_SIZE - (shift % ALPHABET_SIZE));
    }


    public static String bruteForceEncode(String text) {
        InputAndOutputService.writeMessage("\nШифрованный текст:\n\"" + text + "\"");
        InputAndOutputService.writeMessage("\nЕсли увидите расшифрованное сообщение, нажмите '1' ");
        InputAndOutputService.writeMessage("\nЕсли сообщение не оказалась расшифрованным, нажмите '0'\n");

        int keyShift = 1;
        while (keyShift <= ALPHABET_SIZE) {
            String encryptText = encode(text, keyShift++);
            InputAndOutputService.writeMessage(encryptText);
            int messageFromUser = InputAndOutputService.readInt();
            if (messageFromUser == 1) {
                return encryptText;
            }
        }
        return null;
    }
}
