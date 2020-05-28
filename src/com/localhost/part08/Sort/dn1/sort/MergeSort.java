package com.localhost.part08.Sort.dn1.sort;

public class MergeSort {
	public void mergeSort(int[] a,int left,int right){
		if(left<right){
			int middle = (left+right)/2;
			mergeSort(a, left, middle);
			mergeSort(a,middle+1,right);
			merge(a,left,middle,right);//合并
		}
	}

	private void merge(int[] a, int left, int middle, int right) {
		int [] tmpArray = new int[a.length];
		int rightStart = middle+1;
		int tmp = left;
		int third = left;
		//比较两个小数组相应下标位置的数组大小，小的先放进新数组
		while(left<=middle&&rightStart<=right){
			if(a[left]<=a[rightStart]){
				tmpArray[third++] = a [left++];
			}else{
				tmpArray[third++] = a[rightStart++];
			}
		}
		//如果左边还有数据需要拷贝，把左边数组剩下的拷贝到新数组
		while(left<=middle){
			tmpArray[third++] = a[left++];
		}
		//如果右边还有数据......
		while(rightStart<=right){
			tmpArray[third++] = a[rightStart++];
		}
		while(tmp<=right){
			a[tmp] = tmpArray[tmp++];
		}
	}

	//建立一个函数，用于计算数列中的每一项
	public static int fib(int num) {
		//判断：是否是第一个数和第二个数
		if(num == 1 || num == 2) {
			return 1;
		}else {
			//循环调用本函数
			int a=fib(num - 1);
			System.out.print(" "+a);
			return fib(num - 2) + fib(num - 1);
		}
	}


	public static void main(String[] args){
		MergeSort mergeSort = new MergeSort();
		int [] a = new int[]{90,3,2,67,44,-9,87,65,11,9,2,8};
		mergeSort.mergeSort(a, 0, a.length-1);
		for(int n:a){
			System.out.print(" "+n);
		}
		//建立一个for循环，用于打印第一个至第十个数字
		//调用函数进行打印
		System.out.print(fib(10) + "\t");
	}
}
