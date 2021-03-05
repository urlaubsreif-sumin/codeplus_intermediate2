package bf13;
import java.io.*;
import java.util.StringTokenizer;
public class Main {
	static int[][] arr;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[] check = new boolean[1000000];
	static int ans;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		arr = new int[5][5];
		try {
			for(int i = 0; i < 5; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 5; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 5; j++) {
					go(i, j, arr[i][j], 1);
				}
			}
			
			System.out.println(ans);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void go(int i, int j, int res, int n) {
		if(n == 6) {
			if(!check[res]) {
				ans++;
				check[res] = true;
				//System.out.println(res);
			}
			return;
		}
		for(int k = 0; k < 4; k++) {
			int next_i = i + dy[k];
			int next_j = j + dx[k];
			if(next_i < 0 || next_i >= 5 || next_j < 0 || next_j >= 5)
				continue;
			int r = res * 10 + arr[next_i][next_j];
			go(next_i, next_j, r, n + 1);
		}
		
	}
}
