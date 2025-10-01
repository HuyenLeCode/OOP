package HW2;

import java.util.Scanner;

// CS108 HW1 -- String static methods

public class StringCode {

    /**
     * Given a string, returns the length of the largest run.
     * A a run is a series of adajcent chars that are the same.
     * @param s is input
     * @return max run length
     */
    public static int maxRun(String s) {
        if ( s == null || s.isEmpty()) return 0 ;
        int res = 1 , dem = 1 ;
        s = s.trim() ;   // bỏ dấu cách đầu cuối
        if ( s.isEmpty()) return 0 ;
        s = s + " " ;
        for ( int i = 1 ; i < s.length() ; i++) {
            if ( s.charAt(i) != s.charAt(i-1)) {
                res = Math.max ( res , dem ) ;
                dem = 1 ;
            }
            else dem++;
        }
        return res ;  // YOUR CODE HERE
    }


    /**
     * Given a string, for each digit in the original string,
     * replaces the digit with that many occurrences of the character
     * following. So the string "a3tx2z" yields "attttxzzz".
     * @param s is input
     * @return blown up string
     */
    public static String blowup(String s) {
        if ( s == null || s.isEmpty() ) return "" ;

        StringBuilder sb = new StringBuilder ("") ;
        // xét riêng phần tử cuối là số hay chữ sau
        for ( int i = 0 ; i < s.length() - 1 ; i++) {
            if ( Character.isDigit(s.charAt(i))) {
                int m = s.charAt(i) - '0' ;
                char c = s.charAt(i + 1) ;

                for ( int j = 0 ; j < m ; j++) {
                    sb.append(c) ;
                }
            }
            else sb.append(s.charAt(i)) ;
        }

        // còn phần tử tại chỉ số cuối cùng
        if ( !Character.isDigit(s.charAt(s.length() - 1 ))) sb.append( s.charAt(s.length() - 1 )) ;
        // số ở cuối thì thôi xóa đi -> nhân nhiều lần rỗng làm cái gì
        return sb.toString(); // YOUR CODE HERE
    }

    /**
     * Given 2 strings, consider all the substrings within them
     * of length len. Returns true if there are any such substrings
     * which appear in both strings.
     * Compute this in linear time using a HashSet. Len will be 1 or more.
     */
    public static boolean stringIntersect(String a, String b, int len) {
        int n = a.length() ;
        int m = b.length() ;
        a = " " + a ;
        b = " " + b ;

        int [][] F = new int [n + 1][m + 1 ] ;
        for ( int i = 1 ; i <= n ; i++) {
            for ( int j = 1 ; j <= m ; j++) {
                if ( a.charAt(i) != b.charAt(j)) {
                    F[i][j] = Math.max ( F[i-1][j] , F[i][j-1]) ;
                }
                else {
                    F[i][j] = F[i-1][j-1] + 1 ;
                }

                if ( F[i][j] >= len ) return true ;
            }
        }
        return false; // YOUR CODE HERE
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in ) ;
//        String s = sc.nextLine() ;
//        System.out.println ( blowup(s));
//        System.out.println( maxRun(s));
        String a = sc.nextLine() ;
        String b = sc.nextLine() ;
        int len = sc.nextInt() ;
        System.out.println(stringIntersect(a,b , len));
    }
}
