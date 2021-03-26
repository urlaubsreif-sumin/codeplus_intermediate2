package math8;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][] d;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			d = new int[N + 1][K + 1];
			d[0][0] = 1;
			
			int res = go(N, K);
			
			System.out.println(res % 10007);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int go(int n, int k) {
		if(k == 0 || k == n) {
			d[n][k] = 1;
			return 1;
		}
		if(d[n][k] != 0) {
			return d[n][k];
		}
		d[n][k] = (go(n - 1, k - 1) + go(n - 1, k)) % 10007;
		return d[n][k];
	}

}
