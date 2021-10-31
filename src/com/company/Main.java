package com.company;

import com.company.service.CaesarChiperService;
import com.company.service.InputService;

import java.io.StringReader;

public class Main {

    public static void main(String[] args) {
        String stringReader = InputService.readTextFromFile("D:\\epam\\caesarChiper\\src\\com\\company\\Новый текстовый документ (2).txt");
        System.out.println(stringReader);

        System.out.println(CaesarChiperService.decode("мама мыла раму", 3));
    }
}
