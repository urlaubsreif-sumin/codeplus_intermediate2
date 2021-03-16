package uf1;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[] p;
	static int[] rank;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		try {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			p = new int[n + 1];
			rank = new int[n + 1];
			
			for(int i = 0; i < n + 1; i++) {
				p[i] = i;
			}
			
			while(m --> 0) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(op == 1) {
					if(find(a) == find(b)) {
						sb.append("YES\n");
					}
					else {
						sb.append("NO\n");
					}
				}
				else if(op == 0) {
					union(a, b);
				}
			}
			
			System.out.println(sb.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int find(int a) {
		if(a == p[a]) {
			return a;
		}
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
			int temp = x;
			x = y;
			y = temp;
		}
		p[y] = x;
		if(rank[x] == rank[y]) {
			rank[x] = rank[y] + 1;
		}
	}

}
