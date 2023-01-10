//На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
package Seminar05;

import java.util.ArrayList;

public class Seminar05task04 {
    public static void main(String[] args) {
        String[][] chessBoard = new String[9][9];
        fillBoard(chessBoard);
        placeQueen(chessBoard);
        printBoard(chessBoard);
    }

    private static void fillBoard(String[][] board) {
        String[] fields = {"A", "B", "C", "D", "E", "F", "G", "H"};
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                if (i == 0 && j != 0) {
                    board[i][j] = String.valueOf(j);
                } else if (j == 0 && i != 0) {
                    board[i][j] = fields[i - 1];
                } else {
                    board[i][j] = ".";
                }
            }
        }
    }

    private static void printBoard(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i == 0 && j == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print("|");
                    System.out.print(board[i][j]);
                }
            }
            System.out.println("|");
        }
    }

    private static void placeQueen(String[][] board) {
        ArrayList<int[]> positions = new ArrayList<>();
        int x = 1;
        int y = 1;
        while (true) {
            for (int i = x; i < board.length; i++) {
                for (int j = y; j < board[i].length; j++) {
                    board[i][j] = "Q";
                    if (checkPositions(board, i, j)) {
                        int[] current = new int[2];
                        current[0] = i;
                        current[1] = j;
                        positions.add(current);
                        break;
                    } else {
                        board[i][j] = ".";
                    }
                }
            }
            if (positions.size() < 7) {
                int[] temp = positions.get(positions.size() - 1);
                if (temp[1] + 1 == 9 || temp[0] + 1 == 9) {
                    x = temp[0] + 1;
                    y = 1;
                } else {
                    x = temp[0];
                    y = temp[1] + 1;
                }
                positions.remove(positions.size() - 1);
                for (int i = x; i < 9; i++) {
                    for (int j = 1; j < 9; j++) {
                        board[i][j] = ".";
                    }
                }
            } else {
                break;
            }
        }
    }

    private static boolean checkPositions(String[][] board, int row, int col) {
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (i == row || j == col) {
                    if (!(i == row && j == col)) {
                        if (board[i][j].equals("Q")) {
                            return false;
                        }
                    }
                } else if (Math.abs(i - row) == Math.abs(j - col)) {
                    if (board[i][j].equals("Q")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
