package com.company.service;

import com.company.repository.CaesarCipherRepository;

public class CaesarCipherService implements CaesarCipher{

    private CaesarCipherRepository caesarCipherRepository;

    public CaesarCipherService(CaesarCipherRepository caesarCipherRepository) {
        this.caesarCipherRepository = caesarCipherRepository;
    }

    public String bruteForceEncode(String text) {
        InputAndOutputService.writeMessage("\nШифрованный текст:\n\"" + text + "\"");
        InputAndOutputService.writeMessage("\nЕсли увидите расшифрованное сообщение, нажмите '1' ");
        InputAndOutputService.writeMessage("\nЕсли сообщение не оказалась расшифрованным, нажмите '0'\n");

        int keyShift = 1;
        String encryptText = null;
        while (keyShift <= 33) {
            encryptText = caesarCipherRepository.encode(text, keyShift);
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
