package bfs7;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Queue<Integer> queue = new LinkedList<>();
	static int N, M;
	static int[][] arr;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N][M];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] == 1) {
						queue.add(i);
						queue.add(j);
					}
				}
			}
			
			int ans = bfs();
			
			System.out.println(ans);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int bfs() {
		int[][] check = new int[N][M];
		int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
		int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
		int max = 0;
		while(!queue.isEmpty()) {
			int cur_i = queue.remove();
			int cur_j = queue.remove();
			for(int i = 0; i < 8; i++) {
				int next_i = cur_i + dy[i];
				int next_j = cur_j + dx[i];
				if(next_i < 0 || next_j < 0 || next_i >= N || next_j >= M)
					continue;
				if(arr[next_i][next_j] == 1)
					continue;
				if(check[next_i][next_j] != 0)
					continue;
				check[next_i][next_j] = check[cur_i][cur_j] + 1;
				if(max < check[next_i][next_j])
					max = check[next_i][next_j];
				queue.add(next_i);
				queue.add(next_j);
			}
		}
		return max;
	}

}
