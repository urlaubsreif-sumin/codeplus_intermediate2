package dp5;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[][] d = new int[10001][10001];
		try {
			int T = Integer.parseInt(br.readLine());
			while(T --> 0) {
				int n = Integer.parseInt(br.readLine());
				d[1][1] = 1;
				d[2][2] = 1;
				d[3][3] = 1;
				
				for(int i = 1; i <= n; i++) {
					if(d[i][1] == 0 && i - 1 > 0) {
						d[i][1] = d[i - 1][1];
					}
					if(d[i][2] == 0 && i - 2 > 0) {
						d[i][2] = d[i - 2][1] + d[i - 2][2];
					}
					if(d[i][3] == 0 && i - 3 > 0) {
						d[i][3] = d[i - 3][1] + d[i - 3][2] + d[i - 3][3];
					}
				}
				
				sb.append(d[n][1] + d[n][2] + d[n][3]).append('\n');
				
			}
			
			System.out.println(sb.toString());
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
