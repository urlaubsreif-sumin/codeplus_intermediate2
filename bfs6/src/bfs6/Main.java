package bfs6;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int K, W, H;
	static int[][] arr;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			K = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			arr = new int[H][W];
			for(int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int min = bfs();
			
			System.out.println(min);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int bfs() {
		Queue<Integer> queue = new LinkedList<>();
		int[] dx = {-1, 1, 0, 0, -1, -2, -2, -1, 1, 2, 2, 1};
		int[] dy = {0, 0, -1, 1, -2, -1, 1, 2, 2, 1, -1, -2};
		int[] dk = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1};
		int[][][] check = new int[H][W][K + 1];
		int min = -1;
		int cur_i = 0;
		int cur_j = 0;
		int cur_k = 0;
		check[cur_i][cur_j][cur_k] = 1;
		queue.add(cur_i);
		queue.add(cur_j);
		queue.add(cur_k);
		while(!queue.isEmpty()) {
			cur_i = queue.remove();
			cur_j = queue.remove();
			cur_k = queue.remove();
			if(cur_i == H - 1 && cur_j == W - 1) {
				if(min == -1 || min > check[cur_i][cur_j][cur_k] - 1) {
					min = check[cur_i][cur_j][cur_k] - 1;
				}
				return min;
			}
			for(int i = 0; i < 12; i++) {
				int next_i = cur_i + dy[i];
				int next_j = cur_j + dx[i];
				int next_k = cur_k + dk[i];
				if(next_i < 0 || next_j < 0 || next_i >= H || next_j >= W || next_k > K)
					continue;
				if(check[next_i][next_j][next_k] != 0) {
					continue;
				}
				if(arr[next_i][next_j] == 1)
					continue;
				check[next_i][next_j][next_k] = check[cur_i][cur_j][cur_k] + 1;
				queue.add(next_i);
				queue.add(next_j);
				queue.add(next_k);
			}
		}
		return min;
	}

}
