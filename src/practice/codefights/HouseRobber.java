package bigO.src.practice.codefights;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stanimir on 5/18/17.
 */
public class HouseRobber {

    public static void main(String[] str) {

        System.out.println(houseRobber(new int[]{1, 3, 1, 3, 100}));


    }

    static int houseRobber(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();


        int maxIndex = 0;
        int prevMaxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(i - 2)) {
                int currentMaxIndex = maxIndex == i - 1 ? prevMaxIndex : maxIndex;
                int newMaxValue = map.get(currentMaxIndex) + nums[i];
                map.put(i, newMaxValue);


                if (newMaxValue > map.get(maxIndex)) {
                    prevMaxIndex = maxIndex;
                    maxIndex = i;
                }


            } else {
                int newMaxValue = nums[i];
                int currentMaxIndex = maxIndex == i - 1 ? prevMaxIndex : maxIndex;
                if (newMaxValue > getOrZero(map, currentMaxIndex)) {
                    prevMaxIndex = maxIndex;
                    maxIndex = i;
                }
                map.put(i, newMaxValue);
            }
        }
        return map.get(maxIndex);
    }

    static int getOrZero(Map<Integer, Integer> map, int i) {
        if (map.containsKey(i)) {
            return map.get(i);
        }
        return 0;
    }

}
