package bf24;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] board;
	static boolean[][] check;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			board = new int[N][M];
			check = new boolean[N][M];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(board[i][j] == 0) {
						board[i][j] = 1;
						for(int p = 0; p < N; p++) {
							for(int q = 0; q < M; q++) {
								if(board[p][q] == 0) {
									board[p][q] = 1;
									int res = go(p, q);
									//System.out.println(i + " " + j + " " + p + " " + q + " " + res);
									max = max > res ? max : res;
									board[p][q] = 0;
								}								
							}
						}
						board[i][j] = 0;
					}
				}
			}
			
			System.out.println(max);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int go(int r, int c) {
		int res = 0;
		check = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(board[i][j] == 2 && !check[i][j]) {
					int tmp = bfs(i, j);
					if(tmp != -1) {
						res += tmp;
					}
				}
			}
		}
		if(res == 0) {
			return -1;
		}
		return res;
	}
	
	public static int bfs(int r, int c) {
		int res = 1;
		boolean fail = false;
		Queue<Integer> queue = new LinkedList<>();
		int cur_i = r;
		int cur_j = c;
		check[cur_i][cur_j] = true;
		queue.add(cur_i);
		queue.add(cur_j);
		while(!queue.isEmpty()) {
			cur_i = queue.remove();
			cur_j = queue.remove();
			for(int i = 0; i < 4; i++) {
				int next_i = cur_i + dy[i];
				int next_j = cur_j + dx[i];
				if(next_i < 0 || next_i >= N || next_j < 0 || next_j >= M)
					continue;
				if(board[next_i][next_j] == 2 && check[next_i][next_j])
					continue;
				else if(board[next_i][next_j] == 0) {
					fail = true;
				}
				else if(board[next_i][next_j] == 2 && !check[next_i][next_j]) {
					check[next_i][next_j] = true;
					queue.add(next_i);
					queue.add(next_j);
					res++;
				}
			}
		}
		if(fail) {
			return -1;
		}
		return res;
		
	}

}
