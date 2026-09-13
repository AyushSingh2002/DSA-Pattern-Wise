import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    // Method to check if it is safe to place a queen on a particular row and column
    public boolean isSafe(char[][]board, int row, int col, int n) {
        int dupRow = row;
        int dupCol = col;
        // Check for top-left direction
        while(row>=0 && col>=0) {
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        //Check for left direction
        row = dupRow;
        col = dupCol;
        while(col>=0) {
            if(board[row][col] == 'Q') return false;
            col--;
        }
        // Check for bottom-right direction
        row = dupRow;
        col = dupCol;
        while(row<n && col>=0) {
            if(board[row][col] == 'Q') return false;
            row++;
            col--;
        }
        return true;
    }

    // Method to find the solution using recursion
    public void solve(List<List<String>> answer, char[][] board, int n, int col) {
        // Base Case - Every column has a queen
        if(col == n) {
            List<String> state = new ArrayList<>();
            for(int row=0; row<n; row++) state.add(new String(board[row]));
            answer.add(state);
            return;
        }
        // Recursion logic
        for(int row=0; row<n; row++) {
            if(isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                solve(answer, board, n, col+1);
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answer = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int row=0; row<n; row++) Arrays.fill(board[row], '.');
        solve(answer, board, n, 0);
        return answer;
    }
}
// Topics -> Backtracking, Recursion, TC: O(n!), SC: O(n), LC-51