class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                char num = board[i][j];

                if (num == '.') continue;

                if (set.contains(num)) return false;

                set.add(num);
            }
        }

        // ✅ Check columns
        for (int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                char num = board[j][i];

                if (num == '.') continue;

                if (set.contains(num)) return false;

                set.add(num);
            }
        }
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {

                HashSet<Character> set = new HashSet<>();

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        int row = boxRow * 3 + i;
                        int col = boxCol * 3 + j;

                        char num = board[row][col];

                        if (num == '.') continue;

                        if (set.contains(num)) return false;

                        set.add(num);
                    }
                }
            }
        }
        return true;

    }
}
