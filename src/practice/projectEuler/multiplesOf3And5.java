package bigO.src.practice.projectEuler;

/**
 * Created by Stanimir on 5/12/17.
 */
public class multiplesOf3And5 {

    public static void main(String[] str) {

        //multipels of 3 or 5
        //below 100

        // usecase, 3 or 5 below 10 = 3,5,6,9 = 25


        int limit = 4000000;


        System.out.println("res " + numDivisors(120));

    }

    public static int numDivisors(int n) {
        int counter = 0;

        int t = 1;
        while (t <= n) {
            if (n % t == 0) {
                System.out.println(t);
                counter++;
            }
            t++;
        }

        return counter;
    }
}
