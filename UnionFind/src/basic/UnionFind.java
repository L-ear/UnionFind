package basic;

import java.util.Random;

public class UnionFind {
	private int[] parent;
	
	public UnionFind(int len) {
		parent = new int[len];
		for(int i = 0; i < len; ++i) {
			parent[i] = i;
		}
	}
	
	public int find(int a) {
		while(a != parent[a]) {
			a = parent[a];
		}
		return a;
	}
	
	public void union(int a, int b) {
		parent[find(a)] = find(b);
	}
	
	static final int N = 100000;
	public static void main(String[] args) {
		int len = N;
		int unionCount = N;
		int findCount = N;
		UnionFind uf = new UnionFind(len);
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
