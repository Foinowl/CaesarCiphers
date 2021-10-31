package com.company.service;

import java.io.IOException;
import java.io.StringReader;

public class CaesarChiperService {

    public static String decode(String text, int shift) {
        StringReader stringReader = new StringReader(text);

        StringBuilder stringBuilder = new StringBuilder();

        int intChar;
        try {
            while ((intChar = stringReader.read()) != -1) {
                System.out.println(intChar);
                System.out.println((char) intChar);
                char ch = (char) ((char) (intChar + shift) % 33);
                stringBuilder.append(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  stringBuilder.toString();
    }

    public String encode(String text, int shift) {
        StringReader stringReader = new StringReader(text);
        return  "2";
    }
}
