package com.example.demo;

import java.util.IllformedLocaleException;

public class SubstitutionCipher extends MonoAlphabeticCipher {
    private String secretAlphabet;

    public SubstitutionCipher(String input) {
        setSecretAlphabet(input);
    }

    public void setSecretAlphabet(String alphabet) throws IllegalArgumentException {
        if(alphabet!=null && alphabet.length() == 30) {
            int count = 0;
            char alph[] = alphabet.toCharArray();

            for(int i = 0; i<alphabet.length(); i++) {

                for(int j = i+1; j<alphabet.length(); j++) {

                    if(alphabet.charAt(i) == alphabet.charAt(j)) {

                        throw new IllegalArgumentException("Invalid alphabet");

                    }

                }

            }

            this.secretAlphabet = alphabet;

        } else {
            throw new IllegalArgumentException("Invalid alphabet");
        }
    }
}
