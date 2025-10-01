package HW2;

//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.
//

public class TetrisGrid {
    private boolean [][] grid ;

    /**
     * Constructs a new instance with the given grid.
     * Does not make a copy.
     * @param grid is input
     */
    public TetrisGrid(boolean[][] grid) {
        this.grid = grid ;
    }

    /**
     * Does row-clearing on the grid (see handout).
     */
    public void clearRows() {
        int width = grid.length;
        int height = grid[0].length;

        for (int y = 0; y < height; y++) {
            boolean full = true;
            for (int x = 0; x < width; x++) {
                if (!grid[x][y]) {
                    full = false;
                    break;
                }
            }

            if (full) {
                // dịch tất cả các hàng trên y xuống một hàng
                for (int k = y; k < height - 1; k++) {
                    for (int x = 0; x < width; x++) {
                        grid[x][k] = grid[x][k + 1];
                    }
                }
                // hàng trên cùng gán false
                for (int x = 0; x < width; x++) {
                    grid[x][height - 1] = false;
                }
                y--; // kiểm tra lại hàng y mới
            }
        }
    }

    /**
     * Returns the internal 2d grid array.
     * @return 2d grid array
     */
    boolean[][] getGrid() {
        return this.grid;
    }
}
