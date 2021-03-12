package bfs5;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] arr;
	static int[][] check;
	static ArrayList<Integer> group = new ArrayList<>();
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N][M];
			check = new int[N][M];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			go();
			
			HashMap<Integer, Integer> hm = new HashMap<>();
			int max = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(arr[i][j] == 0) {
						hm = new HashMap<Integer, Integer>();
						for(int k = 0; k < 4; k++) {
							int next_i = i + dy[k];
							int next_j = j + dx[k];
							if(next_i < 0 || next_j < 0 || next_i >= N || next_j >= M)
								continue;
							if(check[next_i][next_j] != 0) {
								int gr = check[next_i][next_j];
								hm.put(gr, group.get(gr - 1));
							}
						}
						int sum = 1;
						for(int key : hm.keySet()) {
							sum += hm.get(key);
						}
						max = max > sum ? max : sum;
					}
				}
			}
			
			System.out.println(max);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void go() {
		int n = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] != 0 && check[i][j] == 0) {
					int cnt = bfs(i, j, n);
					group.add(cnt);
					n++;
				}
			}
		}
	}
	
	public static int bfs(int si, int sj, int n) {
		int cnt = 0;
		Queue<Integer> queue = new LinkedList<>();
		int cur_i = si;
		int cur_j = sj;
		check[cur_i][cur_j] = n;
		queue.add(cur_i);
		queue.add(cur_j);
		cnt++;
		while(!queue.isEmpty()) {
			cur_i = queue.remove();
			cur_j = queue.remove();
			for(int i = 0; i < 4; i++) {
				int next_i = cur_i + dy[i];
				int next_j = cur_j + dx[i];
				if(next_i < 0 || next_j < 0 || next_i >= N || next_j >= M)
					continue;
				if(check[next_i][next_j] != 0)
					continue;
				if(arr[next_i][next_j] == 1) {
					check[next_i][next_j] = n;
					queue.add(next_i);
					queue.add(next_j);
					cnt++;
				}
			}
		}
		return cnt;		
	}

}
