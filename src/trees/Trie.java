package bigO.src.trees;

/**
 * Created by Stanimir on 6/18/17.
 */
public interface Trie {

    boolean contains(String key);

    void insert(String key);

    boolean startsWith(String key);

    String remove(String key);
}
