package com.company;

import com.company.repository.RuCaesarCipherRepository;
import com.company.service.CaesarCipher;
import com.company.service.CaesarCipherService;
import com.company.service.InputAndOutputService;

public class Main {

    public static void main(String[] args) {
        String stringReader = InputAndOutputService.readTextFromFile("D:\\epam\\caesarChiper\\src\\com\\company\\Новый текстовый документ (2).txt");
        CaesarCipher caesarCipherService = new CaesarCipherService(new RuCaesarCipherRepository());
        String resultBruteForceEncode = caesarCipherService.bruteForceEncode(stringReader);
        if (resultBruteForceEncode != null) {
            System.out.println("\nРезультат поиска:\n" + resultBruteForceEncode);
        } else {
            System.out.println("Ничего не нашел :(");
        }
    }
}