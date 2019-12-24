package path_compression.rank;

import java.util.Random;

public class UnionFind1 {
	private int[] parent;
	
	public UnionFind1(int len) {
		parent = new int[len];
		for(int i = 0; i < len; ++i) {
			parent[i] = -1;
		}
	}
	
	public int find(int a) {
		if(parent[a] >= 0) return parent[a] = find(parent[a]);
		else return a;
	}
	
	public void union(int a, int b) {
		if((a = find(a)) == (b = find(b))) return;
		if(parent[a] < parent[b]) parent[b] = a;
		else parent[a] = b;
		if(parent[a] == parent[b]) --parent[b];
	}
	
	static final int N = 10000000;
	public static void main(String[] args) {
		System.out.println("完全路径压缩（递归）和depth优化：");
		int len = N;
		int unionCount = N;
		int findCount = N;
		UnionFind1 uf = new UnionFind1(len);
		Random r = new Random(1);
		int sum = 0;
		for(int iter = 0; iter < 10; ++iter) {			
			long start = System.currentTimeMillis();
			for(int i = 0; i < unionCount; ++i) {
				int a = r.nextInt(len);
				int b = r.nextInt(len);
				uf.union(a, b);
			}
			for(int i = 0; i < findCount; ++i) {
				int a = r.nextInt(len);
				uf.find(a);
			}
			long end = System.currentTimeMillis();
			System.out.println(end-start);
			sum += (end-start);
		}
		System.out.println("平均用时："+sum/10);
	}

}
