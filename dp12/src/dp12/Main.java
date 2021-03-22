package dp12;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] coins = new int[n];
			int[] d = new int[k + 1];
			for(int i = 0; i < n; i++) {
				coins[i] = Integer.parseInt(br.readLine());
			}
			Arrays.fill(d, -1);
			
			d[0] = 0;
						
			for(int i = 1; i <= k; i++) {
				for(int j = 0; j < n; j++) {
					if(i - coins[j] >= 0 && d[i - coins[j]] != -1) {
						if(d[i] == -1 || d[i] > d[i - coins[j]] + 1) {
							d[i] = d[i - coins[j]] + 1;
						}
					}
					
				}
			}
			
			System.out.println(d[k]);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
