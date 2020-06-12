package com.localhost.part08.Sort.dn1.sort;

public class HeerSort {
	public static void main(String[] args){
		int[] a = {6,44,11,3,9,55,10,5};
		int d = a.length;//默认增量是8
		while(true){
			d = d/2;
			System.out.println("d:"+d);
			for(int i = 0;i<d;i++){

				for(int j = i;j+d<a.length;j+=d){
					for(int n = i;n+d<a.length;n+=d){
						int tmp;
						if(a[n] > a[n+d]){
							tmp = a[n];
							a[n] = a[n+d];
							a[n+d] = tmp;
						}
					}
					System.out.println("");

				}
			}
			if(d == 1){break;}
		}
		for(int i = 0;i<a.length;i++){
			System.out.println(" "+a[i]);
		}
	}
}
