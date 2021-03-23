package dp22;
import java.io.*;
import java.util.Arrays;

public class Main {
	static char[] arr;
	static long[][] d;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			arr = br.readLine().toCharArray();
			d = new long[N][N + 1];
			for(int i = 0; i < N; i++) {
				Arrays.fill(d[i], -1);
			}
			
			long res = go(0, N - 1);
			
			if(res >= 100000) {
				System.out.printf("%05d", res % 100000);
				return;
			}
			System.out.println(res);
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static long go(int i, int j) {
		if(i == j + 1) {
			return 1;
		}
		if(d[i][j] != -1) {
			return d[i][j];
		}
		d[i][j] = 0;
		for(int k = i + 1; k <= j; k++) {
			long res = 0;
			if(isValid(i, k)) {
				res = res + go(i + 1, k - 1) * go(k + 1, j);
			}
			if(arr[i] == '?' && arr[k] == '?') {
				res *= 3L;
			}
			d[i][j] += res;
			if(d[i][j] >= 100000) {
				d[i][j] = 100000L + (d[i][j] % 100000L);
			}
		}
		//System.out.println(i + " " + j + " " + d[i][j]);
		return d[i][j];
	}
	
	public static boolean isValid(int i, int j) {
		if(arr[i] == ')' || arr[i] == '}' || arr[i] == ']')
			return false;
		if(arr[j] == '(' || arr[j] == '{' || arr[j] == '[')
			return false;
		if(arr[i] == '(' && arr[j] == ')') {
			return true;
		}
		if(arr[i] == '{' && arr[j] == '}' ) {
			return true;
		}
		if(arr[i] == '[' && arr[j] == ']') {
			return true;
		}
		if(arr[i] == '?' || arr[j] == '?') {
			return true;
		}
		return false;
	}

}
