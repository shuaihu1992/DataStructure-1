package com.localhost.part08.Sort.dn1.sorttest;

/**
 * Created by HuShuai on 2020/6/6.
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] a = {6,44,11,3,9,55,10,5};
        for (int i = 1; i < a.length; i++) {
            int temp = 0;
            temp = a[i];
            int j;
            for ( j = i -1; j >= 0; j--) {
                if (temp < a[j]) {
                    a[j+1] = a[j];
                }else {
                    break;
                }
            }
            a[j+1] = temp;
            System.out.println(a);


        }
        for (int s:a) {
            System.out.println(s);

        }
    }
}
