package com.company.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;


public class InputService {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static StringReader readTextFromFile(String path) {
        Path absolutePath = Paths.get(path).toAbsolutePath();
        StringBuilder stringFromFile = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(absolutePath, UTF_8);
            for (String s : lines) {
                stringFromFile.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new StringReader(stringFromFile.toString());
    }

    public static String readString() {
        while (true) {
            try {
                String buf = bis.readLine();
                if (buf != null)
                    return buf;
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
    }
}
