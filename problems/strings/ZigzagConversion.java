package problems.strings;

import java.util.Arrays;

public class ZigzagConversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        String result = convert(s, numRows);
        System.out.println(result);
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        // Create an array of StringBuilder for each row.
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // If we're at the first or the last row, change direction.
            if (currentRow == 0 || currentRow == numRows - 1) goingDown = !goingDown;

            // Move to the next row in the current direction.
            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
