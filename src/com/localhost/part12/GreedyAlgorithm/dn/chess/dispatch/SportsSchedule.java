package com.localhost.part12.GreedyAlgorithm.dn.chess.dispatch;

public class SportsSchedule {
	public void scheduleTable(int[][] table,int n){
		System.out.println(n);

		if(n == 1){
			table[0][0] = 1;
			System.out.println(n);
		}else{
			//填充左上区域矩阵
			int m = n/2;
			System.out.println("A"+m);
			scheduleTable(table, m);

			//填充右上区域矩阵
			for(int i = 0;i<m;i++){
				for(int j = m;j<n;j++){
					table[i][j] = table[i][j-m]+m;
				}
			}
			System.out.println("B"+m);

			//填充左下区域矩阵
			for(int i = m;i<n;i++){
				for(int j=0;j<m;j++){
					table[i][j] = table[i-m][j]+m;
				}
			}
			//填充右下区域矩阵
			for(int i = m;i<n;i++){
				for(int j= m;j<n;j++){
					table[i][j] = table[i-m][j-m];
				}
			}
			System.out.println("C"+m);

		}
	}

	public static void main(String[] args){
		int [][] table = new int[8][8];
		int n = 8;
		SportsSchedule schedule = new SportsSchedule();
		schedule.scheduleTable(table, n);
		int c = 0;
		for(int i = 0;i<n;i++){
			for(int j = 0;j<n;j++){
				System.out.print(table[i][j]+" ");
				c++;
				if(c%n == 0){
					System.out.println();
				}
			}
		}
	}
}
