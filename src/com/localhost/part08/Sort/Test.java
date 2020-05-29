package com.localhost.part08.Sort;

/**
 * Created by HuShuai on 2020/5/26.
 */
public class Test {

    private static int[] array = {7, 5, 3, 11, 8, 2, 10, 9};

    public static void BubbleSortTest() {

        Sort.insertionSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }


    }

    public static void SelectSort() {

        int n = array.length;
        // 最小值的下标
        int min = 9999 ;
        // 临时变量
        int temp;
        // 寻找最小值位置并与当前位置交换
        for (int i = 0; i < n; i++) {
            // 寻找最小值位置
            min = 9999 ;
            for (int j = i; j < n; j++) {
                if (array[j] < min) {
                    min = array[j];
                    temp = array[i];
                    array[i] = min;
                    array[j] = temp;
                }
            }

        }
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void insertionSort() {
        // 获取数组元素个数
        int n = array.length;
        // 临时变量
        int temp;
        // 有序序列的循环变量
        int j;
        for (int i = 1; i < n; i++) {
            // 获取输入数据
            temp = array[i];
            j = i;
            // 排序
            while (j >= 1 && (array[j - 1] > temp)) {
                array[j] = array[j - 1];
                j--;
            }
            // 将数据放入有序序列
            array[j] = temp;
        }
    }

    public static void main(String[] args) {
        insertionSort();
    }
}
