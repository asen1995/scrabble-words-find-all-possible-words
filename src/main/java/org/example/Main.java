package org.example;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        WordsGame.loadWords();
        String word = "STARTLING";
        List<String> allPossibleWordsByRemovingOneLetter = WordsGame.getAllPossibleWordsByRemovingOneLetter(word);
        System.out.println(allPossibleWordsByRemovingOneLetter);
        System.out.println(allPossibleWordsByRemovingOneLetter.size());
    }
}
