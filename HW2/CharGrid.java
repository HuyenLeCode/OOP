package HW2;

// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

import java.util.Scanner;

public class CharGrid {
    private char[][] grid;
    int [] dx = { -1 , 1 , 0 , 0 } ;
    int [] dy = { 0 , 0, -1 , 1 } ;

    /**
     * Constructs a new CharGrid with the given grid.
     * Does not make a copy.
     * @param grid is char array
     */
    public CharGrid(char[][] grid) {
        this.grid = grid;
    }

    /**
     * Returns the area for the given char in the grid. (see handout).
     * @param ch char to look for
     * @return area for given char
     */
    public int charArea(char ch) {
        int n = grid.length ;
        int m = grid[0].length ;

        int i_max = -1 , i_min = n + 1 , j_min = m + 1 , j_max = -1 ;

        for ( int i = 0 ; i < n ; i++) {
            for ( int j = 0 ; j < m ; j++) {
                if ( grid[i][j] == ch ) {
                    i_max = Math.max ( i_max, i ) ;
                    i_min = Math.min ( i_min, i ) ;
                    j_max = Math.max ( j_max, j ) ;
                    j_min = Math.min ( j_min, j ) ;
                }
            }
        }

        if ( i_max == -1 || j_max == -1 || i_min == n + 1 || j_min == m + 1 ) return 0 ; // không có kí tự char
        return ( i_max - i_min + 1 ) * ( j_max - j_min + 1 ); // YOUR CODE HERE
    }

    /**
     * Returns the count of '+' figures in the grid (see handout).
     * @return number of + in grid
     */
    public boolean check ( int i , int j , int n, int m) {
        for ( int k = 0 ; k < 4 ; k++) {
            int i1 = i + dx[k] ;
            int j1 = j + dy[k] ;

            if ( !(i1 >= 0 && i1 < n && j1 >= 0 && j1 < m && grid[i1][j1] == grid[i][j] )) {
                return false ;
            }
        }

        // đi đến đây là ít nhất có hình chữ thập dạng minimum
        /*
             +
           + + +
             +

            Check nốt nhánh trái = phải
            trên = dưới
         */

        int tren = 0 ;
        for ( int t = j - 1 ; t >= 0 ; t--) {
            if ( grid[i][t] == grid[i][j]) {
                tren++;
            }
            else {
                break ;
            }
        }

        int duoi = 0 ;
        for ( int t = j + 1; t < m; t++) {
            if ( grid[i][t] == grid[i][j]) {
                duoi++;
            }
            else {
                break ;
            }
        }

        int trai = 0 ;
        for ( int t = i - 1 ; t >= 0 ; t--) {
            if ( grid[t][j] == grid[i][j]) {
                trai++;
            }
            else {
                break ;
            }
        }

        int phai = 0 ;
        for ( int t = i + 1 ; t < n ; t++) {
            if ( grid[t][j] == grid[i][j]) {
                phai++;
            }
            else {
                break ;
            }
        }

        return tren == duoi && trai == phai ;
    }
    public int countPlus() {
        int n = grid.length ;
        int m = grid[0].length ;

        int cnt = 0 ;
        for ( int i = 1 ; i < n - 1 ; i++) {
            for ( int j = 1 ; j < m - 1 ; j++) {
                if ( check( i , j , n , m )) {
                    cnt++;
                }
            }
        }
        return cnt; // YOUR CODE HERE
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in) ;
        int n = sc.nextInt() ;
        int m = sc.nextInt() ;
        sc.nextLine() ;
        char [][] b = new char [n][m] ;

        for ( int i = 0 ; i < n ; i++) {
            String line = sc.nextLine() ;
            for ( int j = 0 ; j < m ; j++) {
                b[i][j] = line.charAt(j) ;
            }
        }

        CharGrid X = new CharGrid(b) ;
        //System.out.println(X.charArea('a'));
        System.out.println(X.countPlus());
    }
}
