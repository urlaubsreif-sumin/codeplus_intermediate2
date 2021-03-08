package bf20;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[][] arr;
	static long[][][] check;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			N = Integer.parseInt(br.readLine());
			arr = new boolean[N][N];
			check = new long[N][N][3];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					if(Integer.parseInt(st.nextToken()) == 1) {
						arr[i][j] = true;
					}
					check[i][j][0] = -1;
					check[i][j][1] = -1;
					check[i][j][2] = -1;
				}
			}
			
			arr[0][0] = true;
			
			if(!arr[N - 1][N - 2]) {
				check[N - 1][N - 1][0] = 1;
			}
			if(!arr[N - 2][N - 1]) {
				check[N - 1][N - 1][1] = 1;
			}
			if(!arr[N - 2][N - 2] && !arr[N - 2][N - 1] && !arr[N - 1][N - 2]) {
				check[N - 1][N - 1][2] = 1;
			}
			
			long ans = dp(0, 1, 0);
			System.out.println(ans);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static long dp(int i, int j, int dir) {
		//System.out.println(i + " " + j + " " + dir);
		if(i >= N || j >= N || arr[i][j])
			return 0;
		if(check[i][j][dir] != -1) {
			return check[i][j][dir];
		}
		else {
			if(dir == 2) {
				if(arr[i - 1][j] || arr[i][j - 1]) {
					check[i][j][dir] = 0;
					return 0;
				}
			}
			long res = 0;
			if(dir == 0) {
				res = dp(i, j + 1, 0) + dp(i + 1, j + 1, 2);
			}
			else if(dir == 1) {
				res = dp(i + 1, j, 1) + dp(i + 1, j + 1, 2);
			}
			else if(dir == 2) {
				res = dp(i, j + 1, 0) + dp(i + 1, j, 1) + dp(i + 1, j + 1, 2);
			}
			check[i][j][dir] = res;
			return res;
		}
	}

}
