package bigO.src.practice.randomCompanies;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Stanimir on 7/7/17.
 */
public class AList {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] arr = input.split(",");




        int res =   Integer.valueOf(arr[0]) + Integer.valueOf(arr[1]);
        // Use this to print your answer
        System.out.println(res);

    }

}
