package org.example.fibonachi;

import java.util.Iterator;
import java.util.Scanner;

public class FibonachiMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n==0 || n==1) {
            System.out.println(n);
        } else {
            System.out.println(calcNFib(n));
        }
    }

    private static int calcNFib(int n) {
        int arr[] = new int[41];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2; i<=n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    public static int findEll(int[] arr, int element) {
        int n = arr.length;

        int middleIdx = n / 2;
        int startIndex = 0;

        while (middleIdx > 0 && n!=startIndex) {
            middleIdx = (n - startIndex) / 2;
            if (element < arr[middleIdx]) {
                n = middleIdx;
            } else if (element > arr[middleIdx]) {
                startIndex = middleIdx;
            } else {
                return middleIdx;
            }
        }

        return -1;
    }

}
