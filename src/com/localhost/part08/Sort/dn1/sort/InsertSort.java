package com.localhost.part08.Sort.dn1.sort;
/**
 * 直接插入排序
 * @author Administrator
 *
 */
public class InsertSort {
	public static void main(String [] args){
		int[] a = {6,44,11,3,9,55,10,5};
		//直接插入排序开始
		for(int i = 1;i<a.length;i++){
			int temp = a[i];//新遍历的值，等待插入到前面的有序数组
			int j;
			for(j = i-1;j>=0;--j){
				//将大于temp的数往后面移一步
				if(a[j]>temp){
					a[j+1] = a[j];
				}else{
					break;
				}
				System.out.println(i+"---"+j);
			}
			a[j+1] = temp;
		}
		System.out.println("排序后：");
		for(int i = 0;i<a.length;i++){
			System.out.println(" "+a[i]);
		}
		int i = 10;
		System.out.println(--i);//输出9
		System.out.println(i--);//输出9
		System.out.println(i);//输出8
	}
}
