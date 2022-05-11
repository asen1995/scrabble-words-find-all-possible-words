package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WordsGameTest {

    @Test
    void generateDisplayColoredBoxWithText() throws IOException {
        WordsGame.loadWords();

        String[] expectedCombinations = new String[]{"STARTLING", "STARLING", "STARING", "SARING", "SARIN", "SAIN", "AIN", "IN", "I"};

        String word = "STARTLING";
        List<String> allPossibleWordsByRemovingOneLetter = WordsGame.getAllPossibleWordsByRemovingOneLetter(word);

        System.out.println(allPossibleWordsByRemovingOneLetter);
        System.out.println(allPossibleWordsByRemovingOneLetter.size());

        String[] allPossibleWordsByRemovingOneLetterArray = allPossibleWordsByRemovingOneLetter.toArray(new String[allPossibleWordsByRemovingOneLetter.size()]);

        assertArrayEquals(expectedCombinations,allPossibleWordsByRemovingOneLetterArray);
    }

}
