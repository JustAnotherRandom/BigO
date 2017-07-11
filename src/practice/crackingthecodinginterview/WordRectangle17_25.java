package bigO.src.practice.crackingthecodinginterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Stanimir on 6/23/17.
 */
public class WordRectangle17_25 {


    public Rectangle findMaxRectangle(String[] words) {
        Map<Integer, List<String>> wordGroups = generateWordGroups(words);

        int maxWordLen = wordGroups.keySet().stream().max(Integer::compare).get();

        for (int i = maxWordLen; i > 1; i--) {
            for (int j = maxWordLen; j > 1; j--) {
                System.out.println("width" + i + "height" + j);
            }

        }

        return null;
    }

    private Map<Integer, List<String>> generateWordGroups(String[] words) {
        List<String> groups = new ArrayList();


        Map<Integer, List<String>> wordGroups = new HashMap<>();

        int maxLen = 0;
        for (String word : words) {
            int len = word.length();
            List<String> group = wordGroups.get(len);
            if (group == null) {
                group = new ArrayList<>();
                wordGroups.put(len, group);
            }

            group.add(word);
        }
        return wordGroups;
    }

    static class WordGroup {

    }

    public static class Rectangle {


    }
}
