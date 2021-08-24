import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/
 * <p>
 * Valid Sudoku
 */
class Leetcode36 {
    public static void main(String args[]) {
        char[][] sample1 = new char[][]{
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}};

        char[][] sample2 = new char[][]{
                {'.', '.', '.', '.', '.', '.', '5', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'9', '3', '.', '.', '2', '.', '4', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '3', '4', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '5', '2', '.', '.'}};

        System.out.println(isValidSudoku(sample1));
        System.out.println(isValidSudoku(sample2));
    }

    public static boolean isValidSudoku(char[][] board) {
        if (isValidColumnAndRow(board)) {
            return isValidSubBoxes(board);
        }

        return false;
    }

    private static boolean isValidColumnAndRow(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> digits = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (digits.contains(board[i][j]) && board[i][j] != '.') {
                    return false;
                }
                digits.add(board[i][j]);
            }
        }

        for (int i = 0; i < 9; i++) {
            Set<Character> digits = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (digits.contains(board[j][i]) && board[j][i] != '.') {
                    return false;
                }
                digits.add(board[j][i]);
            }
        }

        return true;
    }

    private static boolean isValidSubBoxes(char[][] board) {
        int columnIndex = 0;

        while (columnIndex <= 6) {
            int rowIndex = 0;

            while (rowIndex <= 6) {
                Set<Character> digits = new HashSet<>();
                for (int i = columnIndex; i < columnIndex + 3; i++) {
                    for (int j = rowIndex; j < rowIndex + 3; j++) {
                        if (digits.contains(board[i][j]) && board[i][j] != '.') {
                            return false;
                        }
                        digits.add(board[i][j]);
                    }
                }
                rowIndex += 3;
            }
            columnIndex += 3;
        }

        return true;
    }
}