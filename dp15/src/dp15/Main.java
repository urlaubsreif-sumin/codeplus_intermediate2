package dp15;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr, d;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		try {
			int N = Integer.parseInt(br.readLine());
			
			arr = new int[N][2];
			d = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int res = go(0, N - 1);
			System.out.println(res);
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int go(int i, int j) {
		if(i == j) return 0;
		if(d[i][j] != 0) {
			return d[i][j];
		}
		d[i][j] = Integer.MAX_VALUE;
		for(int k = i; k < j; k++) {
			d[i][j] = Math.min(d[i][j], go(i, k) + go(k + 1, j) + arr[k + 1][0] * arr[j][1] * arr[i][0]);
		}
		return d[i][j];
	}

}
