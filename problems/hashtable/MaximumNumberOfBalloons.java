package problems.hashtable;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBalloons {
    public static void main(String[] args) {
        String text = "loonbalxballpoon";
//        System.out.println(1 / 2);
        System.out.println(maxNumberOfBalloons(text));
    }

    public static int maxNumberOfBalloons(String text) {
        Map<Character, Integer> textMap = new HashMap<>();
        for (char c: text.toCharArray()) {
            textMap.put(c, textMap.getOrDefault(c, 0) + 1);
        }

        String balloon = "balloon";
        Map<Character, Integer> balloonMap = new HashMap<>();
        for (char c: balloon.toCharArray()) {
            balloonMap.put(c, balloonMap.getOrDefault(c, 0) + 1);
        }

        int min = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry: balloonMap.entrySet()) {
            char key = entry.getKey();
            int requiredFrequency = entry.getValue();
            min = Math.min(min, textMap.getOrDefault(key, 0) / requiredFrequency);
        }

        return min;
    }
}
