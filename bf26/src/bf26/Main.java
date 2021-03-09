package bf26;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		try {
			String input;
			int tc = 1;
			while(!(input = br.readLine()).equals("0")) {
				max = Integer.MIN_VALUE;
				sb.append(tc++).append(". ");
				st = new StringTokenizer(input);
				N = Integer.parseInt(st.nextToken());
				arr = new int[N + 1][2 * N + 1];
				
				for(int i = 1; i <= N; i++) {
					for(int j = 1; j <= i * 2 - 1; j++) {
						int a = Integer.parseInt(st.nextToken());
						arr[i][j] = arr[i][j - 1] + a;
					}
				}
				
				for(int i = 1; i <= N; i++) {
					for(int j = 1; j <= i * 2 - 1; j++) {
						calc(i, j, j, 0);
					}
				}
				sb.append(max).append('\n');
			}
			
			System.out.println(sb.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void calc(int i, int l, int r, int sum) {
		if(i < 1 || i > N)
			return;
		if(l < 1 || r > 2 * i - 1)
			return;
		sum += (arr[i][r] - arr[i][l - 1]);
		max = max > sum ? max : sum;
		if(l % 2 == 0) {
			calc(i - 1, l - 2, r, sum);
		}
		else {
			calc(i + 1, l, r + 2, sum);
		}
	}
	
	
}