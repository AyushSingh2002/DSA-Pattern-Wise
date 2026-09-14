class Solution {
    // Method to check if it is valid to put a character at a particular index on the board
    public boolean isValid(char[][] board, int row, int col, char ch) {
        for(int i=0; i<9; i++) {
            if(board[i][col] == ch) return false;
            if(board[row][i] == ch) return false;
            if(board[3*(row/3)+(i/3)][3*(col/3)+i%3] == ch) return false;
        }
        return true;
    }

    // Method to find the solution using recursion
    public boolean solve(char[][] board) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] == '.') {
                    for(char c='1'; c<='9'; c++) {
                        if(isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if(solve(board) == true) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }
}
// Topics -> Backtracking, Recursion, TC: O(9^n), SC: O(n), LC-37