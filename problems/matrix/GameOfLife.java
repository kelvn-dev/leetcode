package problems.matrix;

import java.util.Arrays;
import java.util.List;

/**
 * Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 */
public class GameOfLife {
    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        gameOfLife(board);

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void gameOfLife(int[][] board) {
        if (board.length < 1) {
            return;
        }
        int rowLength = board.length;
        int columnLength = board[0].length;

        int[] neighborPosition = {-1, 0, 1};
        List<Integer> liveValues = Arrays.asList(1, 2);
        for (int i = 0; i < rowLength; ++i) {
            for (int j = 0; j < columnLength; ++j) {
                int liveNeighbors = 0;

                // Check all 8 neighbors
                for (int rowNeighborPosition: neighborPosition) {
                    int rowNeighborIndex = i + rowNeighborPosition;
                    if (rowNeighborIndex < 0 || rowNeighborIndex >= rowLength) {
                        continue;
                    }
                    for (int columnNeighborPosition: neighborPosition) {
                        if (rowNeighborPosition == 0 && columnNeighborPosition == 0) {
                            continue;
                        }
                        int columnNeighborIndex = j + columnNeighborPosition;
                        if (columnNeighborIndex < 0 || columnNeighborIndex >= columnLength) {
                            continue;
                        }

                        if (liveValues.contains(board[rowNeighborIndex][columnNeighborIndex])) {
                            ++liveNeighbors;
                        }
                    }
                }

                int currentState = board[i][j];

                /**
                 * die -> die: 0
                 * live -> live: 1
                 * live -> die: 2
                 * die -> live: 3
                 */

                /**
                 * Any live cell with fewer than two live neighbors dies && Any live cell with more than three live neighbors dies
                 * live -> die
                 */
                if (currentState == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = 2;
                }

                /**
                 * Any dead cell with exactly three live neighbors becomes a live cell
                 * die -> live
                 */
                if (currentState == 0 && liveNeighbors == 3) {
                    board[i][j] = 3;
                }

                /**
                 * Any live cell with two or three live neighbors lives on to the next generation.
                 * live -> live
                 */
//                if (currentState == 1 && liveNeighbors == 2 || liveNeighbors == 3) {
//                    board[i][j] = 1;
//                }

            }
        }

        for (int i = 0; i < rowLength; ++i) {
            for (int j = 0; j < columnLength; ++j) {
                board[i][j] = board[i][j] % 2;
            }
        }
    }
}
