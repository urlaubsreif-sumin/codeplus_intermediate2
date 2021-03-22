package dp11;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] coins;
	static int[][] d;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			coins = new int[n];
			d = new int[k + 1][n];
			
			for(int i = 0; i < n; i++) {
				coins[i] = Integer.parseInt(br.readLine());
			}
			for(int i = 0; i < n; i++) {
				d[0][i] = 1;
			}
			
			for(int i = 0; i <= k; i++) {
				for(int j = 0; j < n; j++) {
					for(int c = 0; c <= j; c++) {
						if(i - coins[c] >= 0) {
							d[i][j] += d[i - coins[c]][c];
						}
					}
				}
			}
			
			System.out.println(d[k][n - 1]);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
