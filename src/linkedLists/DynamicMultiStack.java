package bigO.src.linkedLists;

import java.lang.reflect.Array;

/**
 * Created by Stanimir on 2/28/17.
 */
public class DynamicMultiStack<V> implements MultiStack<V> {

    public static void main(String str[]) throws Exception {
        MultiStack<String> d = new DynamicMultiStack(3, 3);
        d.push(0, "0.1");
        d.push(0, "0.2");
        d.push(0, "0.3");
        d.printAll();
        d.push(0, "0.4");
        d.push(1, "1.1");

//        String res = d.pop(0);
//        System.out.println(res);

        d.printAll();

        d.printAll();
    }

    private class StackInfo {
        private int capacity;
        private int start;


        private int size;

        public StackInfo(int stackIndex, int capacity) {
            this.start = stackIndex;
            this.capacity = capacity;
        }

        public boolean isWithInStackCapacity(int index) {
            if (index < 0 || index >= values.length) return false;

            int contiguousIndex = index < start ? index + values.length : index;
            int end = start + capacity;
            return start <= contiguousIndex && contiguousIndex < end;
        }

        private int lastCapacityIndex() {
            return adjustIndex(start + capacity - 1);
        }

        public int lastElementIndex() {
            return adjustIndex(start + size - 1);
        }

        private boolean isFull() {
            return size == capacity;
        }

        public boolean isEmpty() {
            return size == 0;
        }

    }

    private V[] values;


    private StackInfo[] infos;

    public DynamicMultiStack(int stacks, int defaultSize) {

        values = (V[]) new Object[defaultSize * stacks];


        infos = (DynamicMultiStack<V>.StackInfo[]) Array.newInstance(StackInfo.class, stacks);
        for (int i = 0; i < stacks; i++) {
            infos[i] = new StackInfo(i * defaultSize, defaultSize);
        }
    }

    @Override
    public void push(int stackNum, V v) throws StackIsFullException {
        if (allStacksAreFull()) throw new StackIsFullException();

        StackInfo stack = infos[stackNum];
        if (stack.isFull()) {
            expand(stackNum);
        }

        stack.size++;
        values[stack.lastElementIndex()] = v;
    }

    @Override
    public V pop(int stackNum) throws StackIsEmptyException {
        StackInfo stack = infos[stackNum];
        if (stack.isEmpty()) {
            throw new StackIsEmptyException();
        }
        V value = values[stack.lastElementIndex()];

        values[stack.lastElementIndex()] = null;
        stack.size--;
        return value;
    }

    private void shift(int stackNum) {
        System.out.println("Shifting stack num: " + stackNum);

        StackInfo stack = infos[stackNum];
        if (stack.size >= stack.capacity) {
            int nextStack = (stackNum + 1) % infos.length;
            shift(nextStack);
            stack.capacity++;
        }

        int index = stack.lastCapacityIndex();
        while (stack.isWithInStackCapacity(index)) {
            values[index] = values[previousIndex(index)];
            index = previousIndex(index);
        }
    }


    private void expand(int stackNum) {
        shift((stackNum + 1) % infos.length);
        infos[stackNum].capacity++;
    }

    public int numberOfElements() {
        int size = 0;
        for (StackInfo s : infos) {
            size += s.size;
        }
        return size;
    }

    private boolean allStacksAreFull() {
        return numberOfElements() == values.length;
    }

    private int adjustIndex(int index) {
        int max = values.length;
        return ((index % max) + max) % max;
    }

    private int nextIndex(int index) {
        return adjustIndex(index + 1);
    }

    private int previousIndex(int index) {
        return adjustIndex(index - 1);
    }


    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void printAll() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            sb.append("[" + values[i] + "] ");
        }
        System.out.println(sb.toString());
    }


}

interface MultiStack<V> {
    void push(int stack, V v) throws StackIsFullException;

    V pop(int stack) throws StackIsEmptyException;

    boolean isEmpty();

    void printAll();
}

class StackIsFullException extends Exception {

}

class StackIsEmptyException extends Exception {

}
