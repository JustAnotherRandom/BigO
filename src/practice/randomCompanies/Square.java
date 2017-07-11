package bigO.src.practice.randomCompanies;

/**
 * Given a paragraph of text print it out fully justified with a width of 25
 * characters. Words must fully fit on a line, do not split midword across lines.
 * The text should align on the left and right sides of the column and the spaces
 * should be evenly distributed between words:
 * <p>
 * |------    --   ---    ---| VALID
 * |------ -- ---         ---| INVALID
 * <p>
 * If any line has a single word then it should be printed left justified but you
 * do not need to print out remaining characters.
 * <p>
 * |--- ------- -------- ----|
 * |--                       |
 * <p>
 * The input to the program is the single string
 * <p>
 * "Lorem ipsum dolor sit amet, nibh suscipit proin leo at magnis. Sed quam rutrum
 * sed. Suscipit ut neque auctor cras dictum platea, et lacinia vivamus dui sed,
 * quam ac leo mus nec rhoncus sem. Tempor urna orci mi purus dignissim dapibus,
 * dapibus vitae eros eros, vestibulum tellus duis amet, nullam tellus, architecto
 * maecenas sed mi mattis. Condimentum wisi per aliquam nulla massa, quisque justo
 * ut magna, nunc est et sapien morbi, justo praesent consectetuer, egestas sit
 * semper. Ac commodo, rerum sed, vel eget at libero."
 * <p>
 * Example output:
 * <p>
 * Lorem   ipsum  dolor  sit
 * amet,    nibh    suscipit
 * proin   leo   at  magnis.
 * Sed   quam   rutrum  sed.
 */

import java.util.ArrayDeque;
import java.util.Deque;


/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Square {

    public static final String INPUT = "Lorem ipsum dolor sit amet, nibh suscipit proin leo at magnis. Sed quam rutrum sed. Suscipit ut neque auctor cras dictum platea, et lacinia vivamus dui sed, quam ac leo mus nec rhoncus sem. Tempor urna orci mi purus dignissim dapibus, dapibus vitae eros eros, vestibulum tellus duis amet, nullam tellus, architecto maecenas sed mi mattis. Condimentum wisi per aliquam nulla massa, quisque justo ut magna, nunc est et sapien morbi, justo praesent consectetuer, egestas sit semper. Ac commodo, rerum sed, vel eget at libero.";

    public static final int WIDTH = 25;

    public static final char EMPTY_SPACE = ' ';

    public static void main(String[] args) {
        Square app = new Square();
        app.solution(INPUT);
    }


    private void solution(String in) {


        Deque<String> words = buildQueue(in);

        StringBuilder sb = new StringBuilder();
        ParagraphBuilder pb = new ParagraphBuilder(sb, words);
        pb.build();

        System.out.println(sb.toString());
    }

    static class ParagraphBuilder {
        StringBuilder sb;
        Deque<String> words;

        ParagraphBuilder(StringBuilder sb, Deque<String> words) {
            this.sb = sb;
            this.words = words;
        }

        public void build() {

            LineBuilder lb = new LineBuilder(sb);
            while (!words.isEmpty()) {
                String element = words.peekFirst();

                if (element != null) {
                    int wordLen = element.length();

                    if (lb.currentLineLen + wordLen <= WIDTH) {
                        lb.currentLineLen += wordLen;
                        lb.temp.add(words.remove());

                    } else {
                        if (!lb.temp.isEmpty()) {
                            adjustSpacing(words, lb);
                        }
                        lb.build();
                        lb = new LineBuilder(sb);
                    }
                }
            }
        }

        private void adjustSpacing(Deque<String> queue, LineBuilder lb) {
            int numberEmptySpaces = WIDTH - lb.currentLineLen;
            if (numberEmptySpaces <= 0) {
                revert(queue, lb);
                numberEmptySpaces = WIDTH - lb.currentLineLen;
            }
            int numberWords = lb.temp.size();
            if (numberWords == 1) {
                return;
            }

            int tempSlots = WIDTH - lb.currentLineLen;
            int tempSpaces = lb.temp.size() - 1;
            int carryLen = tempSlots % tempSpaces;
            int spacesLen = tempSlots / tempSpaces;
            if (tempSlots > tempSpaces && (tempSlots % tempSpaces == 0 || (tempSlots % 2 != 0 && tempSpaces % 2 != 0))) {

                lb.carryLen = carryLen;
                lb.spacesLen = spacesLen;
            } else {
                revert(queue, lb);
                adjustSpacing(queue, lb);
            }

        }

        private String revert(Deque<String> queue, LineBuilder lb) {
            String previous = lb.temp.removeLast();
            lb.currentLineLen -= previous.length();
            queue.addFirst(previous);
            return previous;
        }
    }


    static class LineBuilder {
        int spacesLen;
        int carryLen;
        int currentLineLen;
        StringBuilder sb;
        Deque<String> temp = new ArrayDeque<>();

        public LineBuilder(StringBuilder sb) {
            this.sb = sb;
        }

        void build() {
            int numberWords = temp.size();
            int numberSpaces = numberWords - 1;

            int midWord = numberSpaces / 2;


            int wordCounter = 0;
            while (!temp.isEmpty()) {
                String word = temp.pop();
                sb.append(word);
                wordCounter++;
                if (numberWords == wordCounter) break;
                if (carryLen != 0 && wordCounter == (numberWords + 1) / 2) {
                    for (int i = 0; i < spacesLen + carryLen; i++) {
                        sb.append(" ");
                    }

                } else {
                    for (int i = 0; i < spacesLen; i++) {
                        sb.append(" ");
                    }
                }
            }
            sb.append("\n");
        }
    }


    private Deque<String> buildQueue(String in) {
        Deque<String> queue = new ArrayDeque<>();

        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < in.length()) {

            char temp = in.charAt(index);
            if (temp != EMPTY_SPACE) {
                sb.append(temp);
            } else {
                queue.add(sb.toString());
                sb.setLength(0);
            }
            index++;
        }
        if (sb.length() > 0) {
            queue.add(sb.toString());
        }
        return queue;
    }

}
