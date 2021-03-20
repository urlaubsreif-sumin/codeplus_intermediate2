package dp7;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] w, v;
	static int[][] d;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			w = new int[N + 1];
			v = new int[N + 1];
			d = new int[N + 1][K + 1];
			
			for(int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine());
				w[i] = Integer.parseInt(st.nextToken());
				v[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 1; i < N + 1; i++) {
				for(int j = 1; j < K + 1; j++) {
					d[i][j] = -1;
				}
			}
			
			int res = go(N, K);
			
			System.out.println(res);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int go(int i, int j) {
		if(i < 0 || j < 0) {
			return -100000;
		}
		//System.out.println(i + " " + j + " " + d[i][j]);
		if(d[i][j] != -1) {
			return d[i][j];
		}
		d[i][j] = Math.max(go(i - 1, j - w[i]) + v[i], go(i - 1, j));
		return d[i][j];
	}

}
