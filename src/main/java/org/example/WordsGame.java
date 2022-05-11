package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class WordsGame {

    private static Map<String, String> wordsMap;

    private static final String validSingleLetterL = "I";
    private static final String validSingleLetterA = "A";

    public static void loadWords() throws IOException {

        String url = "https://raw.githubusercontent.com/nikiiv/JavaCodingTestOne/master/scrabble-words.txt";
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));

        List<String> collect = in.lines().skip(2).collect(Collectors.toList());

        wordsMap = new HashMap<>();
        for (String d : collect
        ) {
            wordsMap.put(d, d);
        }

    }

    public static List<String> getAllPossibleWordsByRemovingOneLetter(String word) {

        List<String> discoveredWordsResultList = new ArrayList<>();

        findWord(word, word, discoveredWordsResultList);

        return discoveredWordsResultList;

    }

    public static void findWord(String word, String originalWord, List<String> discoveredWords) {

        if (word == null) {
            return;
        }

        if (word.length() == 2) {
            String[] split = word.split("");
            if (validSingleLetterL.equals(split[0])) {
                discoveredWords.add(split[0]);
                return;
            } else if (validSingleLetterA.equals(split[1])) {
                discoveredWords.add((split[1]));
                return;
            } else {
                discoveredWords.remove(discoveredWords.size() - 1);//remove the last founded word and start searching from above level
                return;
            }
        }

        //first word case
        if (discoveredWords.isEmpty() && word.length() == originalWord.length()) {
            if (wordsMap.containsKey(word)) {
                discoveredWords.add(word);
            } else {
                return;
            }
        }

        for (int index = 0; index < word.length(); index++) {

            StringBuilder stringBuilder = new StringBuilder(word);
            String possibleWord = stringBuilder.deleteCharAt(index).toString();

            if (wordsMap.containsKey(possibleWord)) {

                discoveredWords.add(possibleWord);
                findWord(possibleWord, originalWord, discoveredWords); //recursively call after we find a valid word
            }

            if (discoveredWords.size() == originalWord.length()) { //the algorithm has finish work and find all possibilities and needs to break all recursive loops
                break;
            }

            if (word.length() - index == 1) {//didn't found new word with this combination, so we delete previous valid word and continue to search
                discoveredWords.remove(discoveredWords.size() - 1);
                return;
            }
        }
        return;
    }


}
