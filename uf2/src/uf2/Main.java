package uf2;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[] p;
	static int[] rank;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			int n = Integer.parseInt(br.readLine());
			p = new int[n];
			rank = new int[n];
			int m = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < n; i++) {
				p[i] = i;
			}
			
			while(m --> 0) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				union(a, b);
			}
			
			int ans = 0;
			int x = find(0);
			for(int i = 1; i < n; i++) {
				if(x == find(i)) {
					ans++;
				}
			}
			
			System.out.println(ans);
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int find(int a) {
		if(a == p[a])
			return a;
		else {
			return p[a] = find(p[a]);
		}
	}
	
	public static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if(x == y)
			return;
		if(rank[x] < rank[y]) {
			int temp = y;
			y = x;
			x = temp;
		}
		p[y] = x;
		if(rank[x] == rank[y]) {
			rank[x] = rank[y] + 1;
		}
	}

}
