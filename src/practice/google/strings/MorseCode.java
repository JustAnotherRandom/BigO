package bigO.src.practice.google.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Stanimir on 5/26/17.
 */
public class MorseCode {

    Map<String, String> dictionary = new HashMap<>();

    {
        dictionary.put("the", "the");
        dictionary.put("cat", "the");
        dictionary.put("here", "the");
        dictionary.put("is", "the");

    }

    public static void main(String[] str) {
        MorseCode morseCode = new MorseCode();
        List<List<String>> sentences = morseCode.findSentences("thecatishere".toCharArray(), 0);
        if (sentences != null)
            for (List sentence :
                    sentences) {
                if (sentence != null)
                    System.out.println(sentence.stream().collect(Collectors.joining(" ")));

            }
    }

    // a sentence is a List<String>, where each String is a word from dictionary
    public List<List<String>> findSentences(char[] chars, int start) {
        int n = chars.length;
        List<List<String>> sentences = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (int i = start; i < n; i++) {
            word.append(chars[i]);
            if (dictionary.containsKey(word.toString())) {
                if (n - i > 1) {
                    char[] rest = new char[n - i - 1];
//                    System.arraycopy(chars, i + 1, rest, 0, n - i - 1);
                    List<List<String>> sentencesStartingWithWord = findSentences(chars, i + 1);
                    if (sentencesStartingWithWord != null) {
                        for (List<String> sentence : sentencesStartingWithWord)
                            sentence.add(0, word.toString());
                        sentences.addAll(sentencesStartingWithWord);
                    }
                }
            }
        }
        if (dictionary.containsKey(word.toString())) {
            // all chars form a single word
            List<String> sentenceWithOneWord = new ArrayList<>();
            sentenceWithOneWord.add(word.toString());
            sentences.add(sentenceWithOneWord);
        }
        if (sentences.isEmpty()) {
            // haven't found any sentence using chars, so return null
            sentences = null;
        }
        return sentences;
    }

}
