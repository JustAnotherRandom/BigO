package bigO.src.practice.google.strings;

import java.util.*;

/**
 * Created by Stanimir on 6/4/17.
 */
public class AbsoluteLongestPathInFileSys {

    Entry root;
    Map<String, Entry> map = new HashMap<>();

    static class Entry {
        Entry parent = null;
        String name;
        boolean isfile;
        int size;
        int level;

        List<Entry> children = new ArrayList();

        Entry(String name) {
            this.name = name;
            level++;
        }

        int getLength() {
            System.out.print("_" + name + "_");
            return name.length() + (parent != null ? parent.getLength() : 0) + 1;
        }

        public void addChild(Entry n) {
            n.parent = this;
            this.children.add(n);
        }
    }

    public static int findLongestAbsolutePath(String s) {
        int maxLength = 0, curLength = 0;
        if (s == null || s.length() == 0) return 0;
        Deque<String> stack = new ArrayDeque<>();
        String[] splits = s.split("\n");
        for (String sp : splits) {
            int tabs = 0;
            while (sp.charAt(tabs) == '\t')
                tabs++;
            while (tabs < stack.size()) {
                String pop = stack.pop();
                curLength -= pop.length();
            }
            String newPart = sp.substring(tabs);
            stack.push(newPart);
            curLength += newPart.length();
            if (newPart.endsWith(".ext")) {
                maxLength = Math.max(maxLength, curLength);
            }
        }
        return maxLength;
    }




    public static void main(String[] str) {
        AbsoluteLongestPathInFileSys app = new AbsoluteLongestPathInFileSys();
//        System.out.println(app.solve("dir\\n\\tsubdir1\\n\\t\\tfile1.ext\\n\\t\\tsubsubdir1\\n\\tsubdir2\\n\\t\\tsubsubdir2\\n\\t\\t\\tfile2.ext"));

        System.out.println(app.longestSystemPath("dir\\n\\tsubdir1\\n\\t\\tfile1.ext\\n\\t\\tsubsubdir1\\n\\tsubdir2\\n\\t\\tsubsubdir2\\n\\t\\t\\tfile2.ext"));
    }

    //"dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
    private int solve(String str) {
        int maxLength = 0;


        Entry current = null;
        StringBuilder reg = new StringBuilder();
        if (str.startsWith("dir") && root == null) {
            root = new Entry("dir");
            current = root;
            map.put(reg.toString(), root);
            reg.append("\\n");
        }
        int index = 2;
        while (index + 1 < str.length()) {

            StringBuilder buffer = new StringBuilder();
            index += 2;
            buffer.append("\\n");
            while (str.startsWith("\\t", index + 1)) {
                buffer.append("\\t");
                index += 2;
            }

            if (!(buffer.toString().equals(reg.toString()) || buffer.toString().equals(reg.toString() + "\\t"))) {
                current = map.get(buffer.toString()).parent;
                reg = buffer;
            }

            if (buffer.toString().equals(reg.toString()) || buffer.toString().equals(reg.toString() + "\\t")) {
                if (buffer.toString().equals(reg.toString() + "\\t")) reg.append("\\t");
                StringBuilder name = new StringBuilder();
                boolean isWord = false;
                for (int i = index + 1; i < str.length() && str.charAt(i) != '\\'; i++) {
                    if (str.charAt(i) == '.') isWord = true;
                    name.append(str.charAt(i));
                    index = i;
                }


                int currentLen = current.getLength();
                if (!isWord) {
                    Entry n = new Entry(name.toString());
                    map.put(reg.toString(), n);
                    current.addChild(n);
                    current = n;
                } else if (isWord && name.length() + currentLen > maxLength) {
                    System.out.print("_" + name);
                    maxLength = name.length() + currentLen;
                }
                System.out.println();
            }


        }

        return maxLength;
    }

    boolean isWord(String str, int index) {
        return str.startsWith("\\", index);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private int longestSystemPath(String path) {
        this.idx = 1;
        parent = new Entry("dir");
        return consume(path.split("\\\\n"), 0);
    }

    private int idx;
    private Entry parent;
    int max = 0;

    private int consume(String[] str, int depth) {

        if (idx < str.length) {
            String st = str[idx];
            String[] split = str[idx].split("\\\\t+");
            String cur = split[split.length - 1];
            int _depth = (st.length() - cur.length()) / 2;
            if (depth + 1 == _depth) {
                Entry e = addEntry(cur);
                max = updateMaxLen(e);
                idx += 1;
                consume(str, depth + 1);
            } else if (depth == _depth) {
                Entry e = addEntry(cur);
                max = updateMaxLen(e);
                idx += 1;
                consume(str, depth);
            } else {
                parent = getDir(_depth);
                consume(str, _depth);
            }
        }
        return max;
    }

    private int updateMaxLen(Entry e) {
        if (e.isfile) {

            System.out.println("");
            max = Math.max(max, e.getLength());

        }
        return max;
    }

    Entry addEntry(String name) {
        Entry sub = new Entry(name);
        sub.isfile = isFile(name);
        sub.level = parent.level + 1;
        sub.parent = parent;
        parent = sub;
        return sub;
    }

    private boolean isFile(String name) {
        return name.contains(".");
    }

    Entry getDir(int level) {
        while (parent != null && parent.level != level && parent.parent != null) {
            parent = parent.parent;
            level--;
        }
        return parent;
    }
}
