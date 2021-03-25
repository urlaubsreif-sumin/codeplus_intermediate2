package dp21;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] arr;
	static long[][] d;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n];
			d = new long[n + 1][m + 2];
			
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			
			for(int i = 0; i < n + 1; i++) {
				Arrays.fill(d[i], -1);
			}
			
			long res = go(1, arr[0] + 1);
			
			System.out.println(res);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static long go(int i, int j) {
		if(i == n) {
			return 0;
		}
		if(d[i][j] != -1)
			return d[i][j];
		long ans = go(i + 1, arr[i] + 1) + (m - j + 1) * (m - j + 1);
		if(j + arr[i] <= m) {
			long v2 = go(i + 1, j + arr[i] + 1);
			if(ans > v2) {
				ans = v2;
			}
		}
		d[i][j] = ans;
		return ans;
	}

}
