package bfs11;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int N, M;
	static int zero;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int min = -1;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		try {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			zero = -M;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] != 1) {
						zero++;
					}
				}
			}
			
			put_virus(0, 0, 0);
			System.out.println(min);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void put_virus(int i, int j, int cnt) {
		if(cnt == M) {
			int time = bfs();
			//System.out.println("t:" + time);
			if(min == -1 || (time != -1 && min > time)) {
				min = time;
			}
			return;
		}
		for(int r = i; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(r == i && c < j)
					continue;
				if(map[r][c] == 2) {
					//바이러스를 놓는 경우
					map[r][c] = 3;
					put_virus(r + ((c + 1) / N), (c + 1) % N, cnt + 1);
					map[r][c] = 2;
					//바이러스를 놓지 않는 경우
				}
			}
		}
	}
	
	public static int bfs() {
		int cnt = zero;
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int[][] check = new int[N][N];
		for(int i = 0; i < N; i++) {
			Arrays.fill(check[i], -1);
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 3) {
					queue.add(i);
					queue.add(j);
					check[i][j] = 0;
					//System.out.print(i + " " + j + " / ");
				}
			}
		}
		//System.out.println();
		int cur_i = 0;
		int cur_j = 0;
		while(!queue.isEmpty()) {
			cur_i = queue.remove();
			cur_j = queue.remove();
			for(int i = 0; i < 4; i++) {
				int next_i = cur_i + dy[i];
				int next_j = cur_j + dx[i];
				if(next_i < 0 || next_j < 0 || next_i >= N || next_j >= N)
					continue;
				if(check[next_i][next_j] != -1)
					continue;
				if(map[next_i][next_j] == 1)
					continue;
				check[next_i][next_j] = check[cur_i][cur_j] + 1;
				cnt--;
				queue.add(next_i);
				queue.add(next_j);				
			}
		}
		//System.out.println(cnt);
		if(cnt == 0) {
			return check[cur_i][cur_j];
		}
		return -1;
	}
}