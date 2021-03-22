package dp16;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	static long[][] d;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			d = new long[N][21];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			long res = go(N - 2, arr[N - 1]);
			
			System.out.println(res);
			
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static long go(int i, int j) {
		if(j > 20 || j < 0) {
			return 0L;
		}
		if(i == 0) {
			if(arr[i] == j) {
				return 1L;
			}
			else {
				return 0L;
			}
		}
		if(d[i][j] != 0) {
			return d[i][j];
		}
		d[i][j] = go(i - 1, j + arr[i]) + go(i - 1, j - arr[i]);
		return d[i][j];
	}

}
