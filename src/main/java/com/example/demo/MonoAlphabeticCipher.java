package com.example.demo;


public class MonoAlphabeticCipher implements Cipher {

    private String secretAlphabet;

    public MonoAlphabeticCipher() {
        secretAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
    }

    public String getSecretAlphabet() {
        return this.secretAlphabet;
    }

    protected void setSecretAlphabet(String alphabet) throws IllegalArgumentException {
        for(int i = 0; i<alphabet.length(); i++) {
            for(int j = i+1; j<alphabet.length(); j++) {
                if(alphabet.charAt(i) == alphabet.charAt(j)) {
                    throw new IllegalArgumentException("Invalid Alphabet");
                }
            }
        }

        if(alphabet!=null && alphabet.length() == 30) {
            this.secretAlphabet = alphabet;
        } else {
            throw new IllegalArgumentException("Invalid alphabet");
        }
    }

    @Override
    public String encrypt(String input) throws IllegalArgumentException {
        String defaultAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
        if(input==null) {
            throw new IllegalArgumentException("Invalid text");
        }

        input = input.toLowerCase();
        String encrypted = "";

        for(int i = 0; i<input.length(); i++) {
            if(Character.isLetter(input.charAt(i))) {

                encrypted += getSecretAlphabet().charAt(defaultAlphabet.indexOf(input.charAt(i)));

            } else {
                encrypted += input.charAt(i);
            }

        }

        return encrypted;
    }

    @Override
    public String decrypt(String input) {
        String defaultAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
        if(input==null) {
            throw new IllegalArgumentException("Invalid text");
        }

        input = input.toLowerCase();
        String decrypted = "";

        for(int i = 0; i<input.length(); i++) {
            if(Character.isLetter(input.charAt(i))) {

                decrypted += defaultAlphabet.charAt(getSecretAlphabet().indexOf(input.charAt(i)));

            } else {
                decrypted += input.charAt(i);
            }

        }

        return decrypted;
    }

}
