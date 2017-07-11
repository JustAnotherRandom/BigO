package bigO.src.practice.hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Stanimir on 5/5/17.
 */
public class LevelOrderTraversal {

    public static void main(String[] str) {

    }

    public static void LevelOrder(Node root)
    {
        Deque<Node> q = new ArrayDeque<>();

        q.add(root);


        while(!q.isEmpty()){
            Node n = q.remove();

            System.out.print(n.data+" ");

            if(n.left!= null)
               q.add(n.left);

            if(n.right!= null)
                q.add(n.right);

        }

    }

}
