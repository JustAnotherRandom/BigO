package bigO.src.practice.randomCompanies;

/**
 * Created by Stanimir on 5/11/17.
 */
public class Sofi {

    public static void main(String[] args) {
        System.out.println(fibonacci(48));
    }

    private static long fibonacci(long num) {
        if (num == 0L)
            return 0L;
        if (num == 1L)
            return 1L;
        return fibonacci(num-1) + fibonacci(num-2);
    }
}
