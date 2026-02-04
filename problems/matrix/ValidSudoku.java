package problems.matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * Sudoku board is not necessarily solvable => Only the filled cells need to be validated
 */
public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }

                if (set.add(String.format("%c-column-%d", c, j))
                        && set.add(String.format("%c-row-%d", c, i))
                        && set.add(String.format("%c-grid-%d-%d", c, i / 3, j / 3))
                ) {
                    continue;
                }

                return false;
            }
        }

        return true;
    }
}
