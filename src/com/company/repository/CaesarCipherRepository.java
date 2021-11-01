package com.company.repository;

public interface CaesarCipherRepository {
    String encode(String text, int shift);
}