
    public class NQueens {
        static int N; // Size of the chessboard
    
        // Function to print the solution matrix
        static void printSolution(int[][] board) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }
    
        // Function to check if a queen can be placed at board[row][col]
        static boolean isSafe(int[][] board, int row, int col) {
            // Check this column on the upper side
            for (int i = 0; i < row; i++) {
                if (board[i][col] == 1) {
                    return false;
                }
            }
            // Check upper diagonal on the left side
            for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 1) {
                    return false;
                }
            }
            // Check upper diagonal on the right side
            for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
                if (board[i][j] == 1) {
                    return false;
                }
            }
            return true;
        }
    
        // Recursive function to solve the N-Queens problem
        static boolean solveNQueens(int[][] board, int row) {
            // Base case: If all queens are placed
            if (row >= N) {
                return true;
            }
            // Try placing a queen in each column of the current row
            for (int col = 0; col < N; col++) {
                if (isSafe(board, row, col)) {
                    board[row][col] = 1; // Place the queen
                    // Recur to place the rest of the queens
                    if (solveNQueens(board, row + 1)) {
                        return true;
                    }
                    // Backtrack: Remove the queen
                    board[row][col] = 0;
                }
            }
            return false; // No solution found
        }
    
        public static void main(String[] args) {
            N = 8; // Size of the chessboard (can be modified)
            int[][] board = new int[N][N];
            // Place the first queen manually (e.g., at position (0, 0))
            board[0][0] = 1;
            
            // Solve the problem for the remaining queens
            if (solveNQueens(board, 1)) {
                printSolution(board);
            } else {
                System.out.println("No solution exists.");
            }
        }
    }
    