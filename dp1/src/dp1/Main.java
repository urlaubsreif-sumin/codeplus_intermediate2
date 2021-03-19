package dp1;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int[][] d;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			arr = new int[N + 1][M + 1];
			d = new int[N + 1][M + 1];
			
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <= M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			d[1][1] = arr[1][1];
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					d[i][j] = Math.max(d[i][j - 1], Math.max(d[i - 1][j], d[i - 1][j - 1])) + arr[i][j];
				}
			}
			
			System.out.println(d[N][M]);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
