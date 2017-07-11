package bigO.src.practice.codelab;

/**
 * Created by Stanimir on 5/19/17.
 */
public class GCD {
    public  static void main(String[] str){
        System.out.println(gcd(114,672));
    }
    public static int gcd(int a, int b) {
        if(a == b) return a;
        int res =1;
        int counter =res+1;

        do{
            if(a % counter ==0 && b % counter ==0){
                res = counter;

            }
            counter ++;

        } while(counter <= a &&  counter  <= b);

        return res;
    }
}
