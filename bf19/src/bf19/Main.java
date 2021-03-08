package bf19;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[][] arr;
	static int ans;
	static int[] dx = {1, 0, 1};
	static int[] dy = {0, 1, 1};
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		try {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					if(Integer.parseInt(st.nextToken()) == 1) {
						arr[i][j] = true;
					}
				}
			}
			
			arr[0][0] = true;
			arr[0][1] = true;
			go(0, 1, 0);
			
			System.out.println(ans);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}
	//dir: 0 - 가로 / 1 - 세로 / 2 - 대각선
	public static void go(int r, int c, int dir) {
		if(r == N - 1 && c == N - 1) {
			ans++;
			return;
		}
		for(int k = 0; k < 3; k++) {
			if((dir == 0 && k == 1) || (dir == 1 && k == 0))
				continue;
			int next_i = r + dy[k];
			int next_j = c + dx[k];
			if(next_i >= N || next_j >= N)
				continue;
			if(arr[next_i][next_j])
				continue;
			if(k == 2) {
				if(arr[next_i][next_j - 1] || arr[next_i - 1][next_j])
					continue;
			}
			arr[next_i][next_j] = true;
			go(next_i, next_j, k);
			arr[next_i][next_j] = false;
		}
	}

}
