package bigO.src.practice.google.sequences;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Stanimir on 6/7/17.
 */
public class CarParkingProblem {


    /*@1337c0d3r maybe I am wrong but suspect that car problem is famous beloved by Google, Amazon and .... problem.
There is an array of length n representing a parking place with n slots . All slots are occupied by cars with except of one.It is a free slot.
The owner of the parking place decides that there is another way to arrange all cars. He/ she provides you another permutation of the cars. Your task is to arrange the cars in the way the owner requires. You can move a car only to a free place, swap car position with free slot position. Of course there is requirements for minimal swaps.
Lets take a look at the signature of the problem
carPark(vector<int>& order, vector<int>& cur, int null_pos, int n)
vector<int>& order - describes how to arrange the cars
vector<int>& cu -current situations
int null_pos - position of the empty slot
n - number of slots
An example is : order= [4,3,0,1,2] and current = [2,0,3,1,4] and lets nullpos = 2 and n = 5*/
    public static void main(String[] str) {
        int[] curr = {2, 0, 3, 1, 4};

        park(new int[]{4, 3, 0, 1, 2}, curr, 2, 5);
        System.out.println(Arrays.stream(curr).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
    }


    static void park(int[] order, int[] curr, int null_pos, int n) {
        Map<Integer, Integer> map = new HashMap<>();


        int start = 0;
        boolean gap = false;
        for (int i = 0; i < n; i++) {
            if (!gap && curr[i] == order[i]) {
                start++;
            } else {
                gap = true;
            }

            map.put(curr[i], i);
        }


        for (; start < n; start++) {
            if (curr[start] != order[start]) {
                swap(curr, map, start, getZeroIndex(map));
                swap(curr, map, getZeroIndex(map), map.get(order[start]));
            }
        }
    }

    static int getZeroIndex(Map<Integer, Integer> map) {
        return map.get(0);
    }

    private static void swap(int[] curr, Map<Integer, Integer> map, int left, int right) {
        int temp = curr[left];
        curr[left] = curr[right];
        curr[right] = temp;
        map.put(curr[left], left);
        map.put(curr[right], right);

    }


    //void  carPark(vector<int>& order,  vector<int>& cur, int null_pos, int n) {
}
