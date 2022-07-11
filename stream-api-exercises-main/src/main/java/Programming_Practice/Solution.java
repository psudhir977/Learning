package Programming_Practice;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static int[] solution(int[] A, int K) {
        A = new int[]{3, 8, 9, 7, 6};
        K= 4;
        int j=0;
        int[] B = new int[A.length];
        System.out.println("ARRAY A"+ Arrays.toString(A));
        while(j < K){

            for(int i =0; i <= A.length ; i++) {
                if (i < A.length - 1)
                    B[i + 1] = A[i];
                else {
                    B[0] = A[A.length - 1];
                }
            }

            for(int i= 0;i<A.length;i++){
                A[i]=B[i];
            }
            System.out.println("ARRAY A"+ Arrays.toString(A));
            System.out.println("ARRAY B"+ Arrays.toString(B));
            j++;
        }

        return B;
    }

    public static void main(String[] args) {
        Solution.solution(new int[]{1,2},3);
    }
}
