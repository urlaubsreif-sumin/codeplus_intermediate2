package math7;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int res = go(N, K);
			System.out.println(res);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int go(int n, int k) {
		if(n == k) {
			return 1;
		}
		if(k == 0) {
			return 1;
		}
		int res = go(n - 1, k - 1) + go(n - 1, k);
		return res;
	}

}
