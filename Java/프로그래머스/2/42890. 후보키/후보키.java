import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int rowSize = relation.length;
        int colSize = relation[0].length;

        List<Integer> candidateKeys = new ArrayList<>();

        for (int mask = 1; mask < (1 << colSize); mask++) {

            // 1. 최소성 검사
            boolean isMinimal = true;

            for (int key : candidateKeys) {
                if ((mask & key) == key) {
                    isMinimal = false;
                    break;
                }
            }

            if (!isMinimal) continue;

            // 2. 유일성 검사
            Set<String> set = new HashSet<>();

            for (int r = 0; r < rowSize; r++) {
                StringBuilder sb = new StringBuilder();

                for (int c = 0; c < colSize; c++) {
                    if ((mask & (1 << c)) != 0) {
                        sb.append(c)
                          .append(":")
                          .append(relation[r][c])
                          .append("|");
                    }
                }

                set.add(sb.toString());
            }

            if (set.size() == rowSize) {
                candidateKeys.add(mask);
            }
        }

        return candidateKeys.size();
    }
}