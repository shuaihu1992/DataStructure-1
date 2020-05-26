package com.localhost.part07.graph.dn2;

import java.util.HashMap;
import java.util.Map;

public class DnjavaDijstra {
	private final static int MAXVEX = 9;
	private final static int MAXWEIGHT = 65535;
	private int shortTablePath[] = new int[MAXVEX];// 记录的是v0到某顶点的最短路径和
	private Map<Integer,String> path = new HashMap<>();

	/**
	 * 获取一个图的最短路径
	 */
	public void shortestPathDijstra(Graph graph) {
		int min;
		int k = 0;// 记录下标
		boolean isgetPath[] = new boolean[MAXVEX];
		for (int v = 0; v < graph.getVertexSize(); v++) {
			shortTablePath[v] = graph.getMatrix()[0][v];// 获取v0这一行的权值数组
			path.put(v,graph.getMatrix()[0][v]==1000?null:"v0"+"v"+v);
		}
		shortTablePath[0] = 0;
		isgetPath[0] = true;
		path.put(0,"v0");
		for (int v = 1; v < graph.getVertexSize(); v++) {
			min = MAXWEIGHT;
			for (int w = 0; w < graph.getVertexSize(); w++) {
				if (!isgetPath[w] && shortTablePath[w] < min) {
					k = w;
					min = shortTablePath[w];
				}
			}

			isgetPath[k] = true;
			for(int i = 0;i<shortTablePath.length;i++){
				System.out.println("V0到V"+i+"的最短路径为:"+shortTablePath[i]+"路径为:"+path.get(i)+"\n");
			}
			for (int j = 0; j < graph.getVertexSize(); j++) {
				//graph.getMatrix()[k][j] 第k个顶点到各个顶点的距离
				int gap = graph.getMatrix()[k][j];
				if(!isgetPath[j]&&(min+graph.getMatrix()[k][j]<shortTablePath[j])){
					shortTablePath[j] = min + graph.getMatrix()[k][j];
					path.put(j,path.get(k)+"v"+j);
				}
			}
			for(int i = 0;i<shortTablePath.length;i++){
				System.out.println("最新V0到V"+i+"的最短路径为:"+shortTablePath[i]+"路径为:"+path.get(i)+"\n");
			}
			System.out.println("一轮结束\n");
		}
		for(int i = 0;i<shortTablePath.length;i++){
			System.out.println("V0到V"+i+"的最短路径为:"+shortTablePath[i]+"\n");
		}

	}

	public static void main(String[] args){
		Graph graph = new Graph(MAXVEX);
		graph.createGraph();
		DnjavaDijstra dijstra = new DnjavaDijstra();
		dijstra.shortestPathDijstra(graph);
	}
}