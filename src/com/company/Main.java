package com.company;

import com.company.service.CaesarCipherService;
import com.company.service.InputAndOutputService;

public class Main {

    public static void main(String[] args) {
        String stringReader = InputAndOutputService.readTextFromFile("D:\\epam\\caesarChiper\\src\\com\\company\\Новый текстовый документ (2).txt");
        System.out.println(stringReader);

        System.out.println(CaesarCipherService.decode("мама мыла раму", 3));
        System.out.println(CaesarCipherService.encode("пгпг пюог угпц", 3));
        System.out.println(CaesarCipherService.bruteForceEncode(stringReader));
    }
}