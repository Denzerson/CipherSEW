package com.example.demo;

public class ShiftCipher extends MonoAlphabeticCipher{
    public ShiftCipher(int val) {
        setShiftValue(val);
    }

    public void setShiftValue(int val) {
        if(val>30) {
            val = 30;
        }

        if(val < 0) {
            val = val * -1;
        }


        String secretAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
        secretAlphabet = secretAlphabet.substring(30-val,30) + secretAlphabet.substring(0, 30-val);
        this.setSecretAlphabet(secretAlphabet);
        System.out.println(secretAlphabet);

    }

}
