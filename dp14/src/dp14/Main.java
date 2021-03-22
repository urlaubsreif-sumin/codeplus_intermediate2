package dp14;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static long[][] d;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			d = new long[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			long res = go(0, 0);
			System.out.println(res);
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}
	
	public static long go(int i, int j) {
		if(i == N - 1 && j == N - 1) {
			return 1L;
		}
		if(d[i][j] != 0) {
			return d[i][j];
		}
		int n = arr[i][j];
		if(n == 0) {
			d[i][j] = 0;
			return 0;
		}
		if(i + n < N) {
			d[i][j] += go(i + n, j);
		}
		if(j + n < N) {
			d[i][j] += go(i, j + n);
		}
		return d[i][j];
	}

}
