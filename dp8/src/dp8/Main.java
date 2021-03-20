package dp8;
import java.io.*;
import java.util.StringTokenizer;
public class Main {
	static int N, S, M;
	static int[] v;
	static boolean[][] d;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			d = new boolean[N + 1][M + 1];
			v = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				v[i] = Integer.parseInt(st.nextToken());
			}
			d[0][S] = true;
			
			for(int i = 1; i <= N; i++) {
				boolean change = false;
				for(int j = 0; j <= M; j++) {
					if(d[i - 1][j]) {
						if(j - v[i - 1] >= 0) {
							d[i][j - v[i - 1]] = true;
							change = true;
						}
						if(j + v[i - 1] <= M) {
							d[i][j + v[i - 1]] = true;
							change = true;
						}
					}
				}
				if(!change) {
					System.out.println(-1);
					return;
				}
			}
			
			for(int i = M; i >= 0; i--) {
				if(d[N][i]) {
					System.out.println(i);
					return;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
		
}
