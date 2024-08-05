class Solution {
    int count = 0;

    public int totalNQueens(int n) {
        // boolean arrays to track columns and diagonals under attack
        boolean[] cols = new boolean[n];
        boolean[] d1 = new boolean[2 * n];  // diagonals (row + col)
        boolean[] d2 = new boolean[2 * n];  // diagonals (row - col + n)

        backtrack(0, n, cols, d1, d2);
        return count;
    }

    private void backtrack(int row, int n, boolean[] cols, boolean[] d1, boolean[] d2) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int id1 = row - col + n;  // index for d1
            int id2 = row + col;      // index for d2
            if (cols[col] || d1[id1] || d2[id2]) continue;

            // place queen
            cols[col] = true;
            d1[id1] = true;
            d2[id2] = true;

            backtrack(row + 1, n, cols, d1, d2);

            // remove queen (backtrack)
            cols[col] = false;
            d1[id1] = false;
            d2[id2] = false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int result = solution.totalNQueens(n);
        System.out.println(result);  // Expected Output: 2
    }
}
