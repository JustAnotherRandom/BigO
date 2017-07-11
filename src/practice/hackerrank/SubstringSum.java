package bigO.src.practice.hackerrank;

/**
 * Created by Stanimir on 5/3/17.
 */
public class SubstringSum {
    public static class Sum {
        public int sum = 0;
    }

    public static void main(String[] str) {
//        Scanner in = new Scanner(System.in);
//
//        Sum sum =   new Sum();
//
//        calculateSubstringSum("", "", in.next(), sum);
//
//        System.out.println(sum.sum);

//        Scanner in = new Scanner(System.in);
//        String s = in.next();
//        long sum[] = new long[s.length()];
//        sum[0] = Integer.parseInt(Character.toString(s.charAt(0)));
//        long result = sum[0];
//        for (int i = 1; i < s.length(); i++) {
//            sum[i] = ((i + 1) * Integer.parseInt(Character.toString(s.charAt(i)))) % 1000000007 + (10 * (sum[i - 1])) % 1000000007;
//            sum[i] = sum[i] % 1000000007;
//            result += sum[i];
//            result = result % 1000000007;
//        }
//        System.out.print(result);
    }

    private static void calculateSubstringSum(String pre, String curr, String post, Sum sum) {

        int l = pre.length() <= 1 ? 0 : Integer.valueOf(pre);
        int c = curr.length() == 0 ? 0 : Integer.valueOf(curr);
        int r = post.length() <= 1 ? 0 : Integer.valueOf(post);

        sum.sum = sum.sum + l + c + r;
        if (post.isEmpty()) return;
        String newPre = pre + (curr.isEmpty() ? "" : curr.charAt(0));
        String newCur = (curr.isEmpty() ? "" : curr.substring(1)) + (post.isEmpty() ? "" : post.charAt(0));
        String newPost = post.substring(1);
        calculateSubstringSum(newPre, newCur, newPost, sum);
    }

}
