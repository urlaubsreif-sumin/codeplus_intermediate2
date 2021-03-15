package bfs12;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static int N, M;
	static int[][] map;
	static ArrayList<Pair> virus = new ArrayList<Pair>();
	static int min = -1;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		try {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 2) {
						virus.add(new Pair(i, j));
					}
				}
			}
			
			put_virus(0, 0);
			
			System.out.println(min);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void put_virus(int i, int cnt) {
		if(cnt == M) {
			int time = bfs();
			if(min == -1 || (time != -1 && time < min)) {
				min = time;
			}
			return;
		}
		for(int k = i; k < virus.size(); k++) {
			Pair cur = virus.get(k);
			map[cur.i][cur.j] = 3;
			put_virus(k + 1, cnt + 1);
			map[cur.i][cur.j] = 2;
		}
	}
	
	public static int bfs() {
		Queue<Integer> queue = new LinkedList<>();
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int[][] check = new int[N][N];
		int zero = 0;
		for(int i = 0; i < N; i++) {
			Arrays.fill(check[i], -1);
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 3) {
					queue.add(i);
					queue.add(j);
					check[i][j] = 0;
				}
				else if(map[i][j] == 0) {
					zero++;
				}
			}
		}
		int cur_i = 0;
		int cur_j = 0;
		if(zero == 0) {
			return 0;
		}
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
				if(map[next_i][next_j] == 0) {
					zero--;
				}
				check[next_i][next_j] = check[cur_i][cur_j] + 1;
				queue.add(next_i);
				queue.add(next_j);
				if(zero == 0) {
					return check[next_i][next_j];
				}
			}
		}
		return -1;
	}

}

class Pair {
	int i;
	int j;
	Pair(int i, int j){
		this.i = i;
		this.j = j;
	}
}
