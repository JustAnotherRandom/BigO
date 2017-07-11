package bigO.src.practice.moderate;

/**
 * Created by Stanimir on 3/29/17.
 */
public class PatternMatching {

    public static void main(String[] str) {
        PatternMatching app = new PatternMatching();

        System.out.println(app.doesMatch("aabab", "catcatgocatgo"));
    }


    public boolean doesMatch(String pattern, String value) {
        if (pattern == null) return value == null;
        if (pattern.isEmpty()) return value.isEmpty();


        Stats stats = countMains(pattern);
        int maxLenMain = value.length() / stats.numberMains;

        int size = value.length();

        for (int main = 0; main < size; main++) {
            int remaining = size - main * stats.numberMains;
            String mainPart = value.substring(0, main);


            //todo if no alts
            int altPartStart = main * stats.firstAlt;
            int altPartEnd = remaining / stats.numberAlts;


            String altPart = value.substring(altPartStart, altPartEnd);

            String cand = getCandidate(pattern, mainPart, altPart);

            if (cand.equals(value)) {
                System.out.println(cand);
                return true;
            }

        }


        return false;
    }

    private String getCandidate(String pattern, String mainPart, String altPart) {
        char main = pattern.charAt(0);
        StringBuilder sb = new StringBuilder();
        sb.append(mainPart);
        for (int i = 1; i < pattern.length(); i++) {
            if (pattern.charAt(i) == main) {
                sb.append(mainPart);
            } else {
                sb.append(altPart);
            }
        }
        return sb.toString();
    }


    private class Stats {
        public int numberMains;
        public int numberAlts;
        public int firstAlt;

        public Stats(int numMains, int numberAlts, int firstAlt) {
            this.numberMains = numMains;
            this.numberAlts = numberAlts;
            this.firstAlt = firstAlt;
        }

    }


    //aabab
    private Stats countMains(String pattern) {
        int numMains = 1;
        int numberAlts = 0;
        char main = pattern.charAt(0);
        int firstAlt = -1;

        for (int i = 1; i < pattern.length(); i++) {
            if (pattern.charAt(i) == main) {
                numMains++;
            } else {
                if (firstAlt == -1) {
                    firstAlt = i;
                }
                numberAlts++;
            }
        }
        return new Stats(numMains, numberAlts, firstAlt);
    }
}
