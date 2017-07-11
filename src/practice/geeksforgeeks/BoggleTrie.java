package bigO.src.practice.geeksforgeeks;

import bigO.src.trees.Trie;
import bigO.src.trees.TrieImpl;

import java.util.*;

/**
 * Created by Stanimir on 6/21/17.
 */
public class BoggleTrie {

    Trie trie;
    char[][] board;


    static int counter =0;

    private void initTrie(String[] words) {
        for (String word : words) {
            trie.insert(word);
        }
    }

    public List<String> searchWords(char[][] board, String[] words) {
        trie = new TrieImpl();
        initTrie(words);
        this.board = board;


        List<String> allWords = new ArrayList<>();

        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board[0].length; col++) {

                Set<Location> visited = new HashSet<>();
                WordBuilder prefix = new WordBuilder();
                Location start = new Location(row, col);
                allWords.addAll(scan(start, visited, prefix));
            }

        System.out.println(counter);
        return allWords;
    }

    private List<String> scan(Location location, Set<Location> visited, WordBuilder prefix) {
        if (!checkBounds(location) || visited.contains(location)) return Collections.emptyList();
        counter++;
        visited.add(location);
        char current = getValue(location);

        prefix.word.offer(current);

        String pref = prefix.toString();

        if (!trie.startsWith(pref)) {//TODO update Trrie to work with a WordBuilder to avoid converting to string
            prefix.word.removeLast();
            return Collections.EMPTY_LIST;
        }

        List<String> words = new ArrayList<>();
        if (trie.contains(pref)) {
            words.add(pref);

        }

        List<Location> neightbours = getNeightbours(location);

        for (Location l : neightbours) {
            words.addAll(scan(l, visited, prefix));
            visited.remove(l);
        }

        prefix.word.removeLast();

        visited.remove(location);

        return words;
    }

    private char getValue(Location location) {
        return board[location.row][location.col];
    }

    private List<Location> getNeightbours(Location location) {
        List<Location> neightbours = new ArrayList<>();
        int row = location.row;
        int col = location.col;
        neightbours.add(new Location(row - 1, col));
        neightbours.add(new Location(row - 1, col - 1));
        neightbours.add(new Location(row - 1, col + 1));
        neightbours.add(new Location(row + 1, col));
        neightbours.add(new Location(row + 1, col - 1));
        neightbours.add(new Location(row + 1, col + 1));
        neightbours.add(new Location(row, col - 1));
        neightbours.add(new Location(row, col + 1));
        return neightbours;
    }

    private boolean checkBounds(Location loc) {
        if (loc.row < 0 || loc.col < 0 || loc.row >= board.length || loc.col >= board[0].length) return false;
        return true;
    }

    static class WordBuilder {
        Deque<Character> word = new ArrayDeque();

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (char c : word) {
                sb.append(c);
            }
            return sb.toString();
        }
    }


    static class Location {
        int row, col;

        Location(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Location location = (Location) o;
            return row == location.row &&
                    col == location.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
