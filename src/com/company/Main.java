package com.company;

public class Main {

    static String althabet = "A" +
            "B" +
            "C" +
            "D" +
            "E" +
            "F" +
            "G" +
            "H" +
            "I" +
            "J" +
            "K" +
            "L" +
            "M" +
            "N" +
            "O" +
            "P" +
            "Q" +
            "R" +
            "S" +
            "T" +
            "U" +
            "V" +
            "W" +
            "X" +
            "Y" +
            "Z";

    public static void main(String[] args) {
        int key = 3;
        String word = "LOL";
        System.out.println(word);
        String secretWord=coder(word, key);
        System.out.println(secretWord);
        System.out.println(decoder(secretWord,key));
    }

    public static String coder(String changeWord, int keyShift) {
        String secretWord = "";
        String[] alfabetTotal = althabet.split("");
        String[] wordArray = changeWord.split("");
        keyShift = keyShift % alfabetTotal.length;
        for (int i = 0; i < wordArray.length; i++) {
            for (int j = 0; j < alfabetTotal.length; j++) {
                if (wordArray[i].equals(alfabetTotal[j])) {
                    int num = j + keyShift;
                    secretWord += alfabetTotal[(num < alfabetTotal.length) ? num : num - alfabetTotal.length];
                }
            }
        }
        return secretWord;
    }

    public static String decoder(String secretWord, int key) {
        String finishWord = "";
        String[] alfabetTotal = althabet.split("");
        String[] wordArray = secretWord.split("");
        key = key % alfabetTotal.length;
        for (int i = 0; i < wordArray.length; i++) {
            for (int j = 0; j < alfabetTotal.length; j++) {
                if (wordArray[i].equals(alfabetTotal[j])) {
                    int num = j - key;
                    finishWord += alfabetTotal[(num > 0) ? num : num + alfabetTotal.length];
                }
            }
        }
        return finishWord;
    }
}
