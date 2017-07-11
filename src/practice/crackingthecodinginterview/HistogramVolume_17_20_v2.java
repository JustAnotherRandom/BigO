package bigO.src.practice.crackingthecodinginterview;

/**
 * Created by Stanimir on 6/20/17.
 */
public class HistogramVolume_17_20_v2 {


    public static int calculateVolume(int[] arr) {

        Entry[] mem = new Entry[arr.length];
        int maxIndex = initMem(arr, mem);


        return volumesOnTheRight(mem, maxIndex) + volumesOnTheLeft(mem, maxIndex);
    }

    private static int volumesOnTheRight(Entry[] mem, int maxIndex) {
        Entry maxEntry = mem[maxIndex];
        Entry maxOnTheRigth = mem[maxEntry.maxIndexOnRight];
        if (maxOnTheRigth.value == 0) return 0;
        return Math.min(maxEntry.value, maxOnTheRigth.value) * (maxOnTheRigth.index - 1 - maxIndex) - maxEntry.deltaOnRight;
    }

    private static int volumesOnTheLeft(Entry[] mem, int maxIndex) {

        Entry maxEntry = mem[maxIndex];
        Entry maxOnTheLeft = mem[maxEntry.maxIndexOnLeft];
        if (maxOnTheLeft.value == 0) return 0;
        return Math.min(maxEntry.value, maxOnTheLeft.value) * (maxIndex - 1 - maxOnTheLeft.index) - maxEntry.deltaOnLeft;
    }

    private static int initMem(int[] arr, Entry[] mem) {
        int maxIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];

            Entry e = new Entry();
            e.index = i;
            e.value = val;


            int oldMax = maxIndex;
            e.maxIndexOnLeft = maxIndex;
            if (val > arr[maxIndex]) {
                maxIndex = i;
            }


            int delta = 0;
            if ((val > 0)) {
                int maxOnTheLEftVal = mem[e.maxIndexOnLeft].value;
                if (maxOnTheLEftVal >= val) {
                    delta = val;
                }
            }


            if (maxIndex != oldMax && oldMax > 0) {
                e.deltaOnLeft = delta + mem[i - 1].deltaOnLeft;
            } else {
                e.deltaOnLeft = delta;
            }


            mem[i] = e;

        }


        maxIndex = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int val = arr[i];

            if (val > arr[maxIndex]) {
                maxIndex = i;
            }
            int oldMax = maxIndex;
            Entry e = mem[i];
            e.maxIndexOnRight = maxIndex;


            int delta = 0;
            if ((val > 0)) {
                int maxOnTheRightVal = mem[e.maxIndexOnRight].value;
                if (maxOnTheRightVal >= val) {
                    delta = val;
                }
            }


            if (maxIndex != oldMax && oldMax > 0) {
                e.deltaOnLeft = delta + mem[i + 1].deltaOnLeft;
            } else {
                e.deltaOnRight = delta;
            }
            mem[i] = e;
        }
        return maxIndex;
    }

    static class Entry {
        int index;
        int value;
        int maxIndexOnLeft;
        int maxIndexOnRight;
        int deltaOnLeft;
        int deltaOnRight;
    }
}
