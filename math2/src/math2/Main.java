package math2;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
		static int N;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		try {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			StringBuilder sb = new StringBuilder();
			
			long B = Long.parseLong(st.nextToken());
			int[][] arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] ans = go(arr, B);
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					sb.append(ans[i][j]).append(' ');
				}
				sb.append('\n');
			}
			
			System.out.println(sb.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static int[][] go(int[][] arr, long b) {
		if(b == 0) {
			int[][] tmp = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(i == j) {
						tmp[i][j] = 1;
					}
				}
			}
			return tmp;
		}
		if(b % 2 == 0) {
			int[][] tmp = go(arr, b / 2);
			return mult(tmp, tmp);
		}
		else {
			return mult(arr, go(arr, b - 1));
		}
	}
	
	public static int[][] mult(int[][] first, int[][] second) {
		int[][] tmp = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					tmp[i][j] = (tmp[i][j] + ((first[i][k] * second[k][j]) % 1000)) % 1000;
				}
			}
		}
		return tmp;
	}

}
