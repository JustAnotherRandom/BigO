package bigO.src.practice.fb_interviewbit;

/**
 * Created by Stanimir on 6/10/17.
 */
public class Session {

    public static void main(String[] str) {
        System.out.println(isPrime(29));
    }

    private static int isPrime(int n) {
        int upperLimit = (int) Math.sqrt(n);
        // Corner cases
        if (n <= 1)  return 0;
        if (n <= 3)  return 1;

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n%2 == 0 || n%3 == 0) return 0;

        for (int i=5; i<=upperLimit; i=i+6)
            if (n%i == 0 || n%(i+2) == 0)
                return 0;

        return 1;
    }

}