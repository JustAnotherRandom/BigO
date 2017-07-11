package bigO.src.trees;

import bigO.common.TreePrinter;

import java.io.*;
import java.util.List;


/**
 * Created by Stanimir on 6/8/17.
 */
public class NAryTree<T> implements Serializable {

    private NAryNode<T> root;
    private static final char END = '#';

    public NAryTree(NAryNode root) {
        this.root = root;
    }

    NAryTree() {
    }


    public NAryNode<T> getRoot() {
        return root;
    }

    public static void main(String[] str) {
        NAryNode<String> root = new NAryNode<>("A");
        NAryNode B = root.addChild("B");
        B.addChild("E");
        NAryNode F = B.addChild("F");
        F.addChild("K");
        root.addChild("C");
        NAryNode D = root.addChild("D");
        D.addChild("G");
        D.addChild("H");
        D.addChild("I");
        D.addChild("J");


        NAryTree tree = new NAryTree(root);
        TreePrinter.printNAryTree(tree);
        try {
            tree.serialize("testFile");

            NAryTree deserializedTree = new NAryTree();
            deserializedTree.deserialize("testFile");
            TreePrinter.printNAryTree(deserializedTree);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private void serialize(String filename) throws IOException {
        StringBuilder sb = new StringBuilder();


        FileWriter fw = new FileWriter(filename);
        NAryNode<T> focusNode = root;
        serialize(focusNode, fw);

        BufferedWriter b = new BufferedWriter(fw);
        b.flush();
        b.close();

    }

    private void serialize(NAryNode<T> root, FileWriter fw) throws IOException {
        if (root == null) return;

        fw.append(root.getVal().toString());

        List<NAryNode<T>> children = root.getChildren();
        if (children != null) {
            for (NAryNode child : children) {
                serialize(child, fw);

            }
        }
        fw.append(END);
    }


    void deserialize(String fileName) throws IOException {


        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);

        String sCurrentLine = br.readLine();
        System.out.println(sCurrentLine);

        NAryNode root = new NAryNode(sCurrentLine.charAt(0));
        build(root, sCurrentLine, new Index());
        this.root = root;
    }

    static class Index {
        int ind = 0;

        public int increment() {
            return ++ind;
        }
    }

    private NAryNode<T> build(NAryNode<T> root, String str, Index ind) {

        while (ind.ind + 1 < str.length()) {
            int cind = ind.increment();
            char c = str.charAt(cind);

            if (c == END) return null;

            NAryNode<T> current = new NAryNode(c);
            root.addChild(current);
            NAryNode<T> res = build(current, str, ind);
            if (res != null)
                root.addChild(res);


        }
        return null;
    }

}
