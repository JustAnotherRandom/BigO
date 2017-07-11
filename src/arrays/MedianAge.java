package bigO.src.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Stanimir on 2/20/17.
 */
public class MedianAge {

    ArrayList<Integer> ages;

    public static void main(String[] args) throws InterruptedException {
        MedianAge ma = new MedianAge();
        Scanner sc = new Scanner(System.in);
        while (true) {
            int num = sc.nextInt();
            ma.add(num);
            Thread.sleep(1000l);
        }
    }

    public MedianAge() {
        ages = new ArrayList<>();
    }

    public void add(int age) {
        int index = Collections.binarySearch(ages, age);
        if (index < 0) {
            index = Math.abs(index) - 1;
        }
        ages.add(index, age);
        System.out.println(getMedian());
        System.out.println(ages.toString());
    }

    public double getMedian() {
        int mid = ages.size() / 2;
        if (ages.size() % 2 == 1) {
            return ages.get(mid);
        } else {
            int curr = ages.get(mid);
            int prev = ages.get(mid - 1);
            return (curr + prev) / 2.0;
        }
    }
}


