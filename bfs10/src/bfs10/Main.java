package bfs10;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map;
	static int[][] group;
	static int g;
	static int max;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static ArrayList<Integer> size = new ArrayList<>();
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		try {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new int[m][n];
			group = new int[m][n];
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			go();
			sb.append(g).append('\n');
			sb.append(Collections.max(size)).append('\n');
			sb.append(max);
			
			System.out.println(sb.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void go() {
		size = new ArrayList<Integer>();
		g = 1;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(group[i][j] == 0) {
					int sz = bfs(i, j, g);
					size.add(sz);
					g++;
				}
			}
		}
		g--;
		max = size.get(0);
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				int sz = size.get(group[i][j] - 1);
				if(j + 1 < n && group[i][j] != group[i][j + 1]) {
					int next_sz = size.get(group[i][j + 1] - 1);
					max = max > (sz + next_sz) ? max : sz + next_sz;
				}
				if(i + 1 < m && group[i][j] != group[i + 1][j]) {
					int next_sz = size.get(group[i + 1][j] - 1);
					max = max > (sz + next_sz) ? max : sz + next_sz;
				}
			}
		}
	}
	
	public static int bfs(int si, int sj, int g) {
		Queue<Integer> queue = new LinkedList<>();
		int[] wall = {8, 4, 2, 1};
		int cur_i = si;
		int cur_j = sj;
		int sz = 1;
		queue.add(cur_i);
		queue.add(cur_j);
		group[cur_i][cur_j] = g;
		while(!queue.isEmpty()) {
			cur_i = queue.remove();
			cur_j = queue.remove();
			int a = map[cur_i][cur_j];
			for(int i = 0; i < 4; i++) {
				if(a < wall[i]) {
					int next_i = cur_i + dy[i];
					int next_j = cur_j + dx[i];
					if(next_i < 0 || next_j < 0 || next_i >= m || next_j >= n)
						continue;
					if(group[next_i][next_j] != 0)
						continue;
					group[next_i][next_j] = g;
					sz++;
					queue.add(next_i);
					queue.add(next_j);
				}
				else {
					a -= wall[i];
				}
			}
		}
		return sz;
	}

}
