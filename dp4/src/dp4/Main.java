package dp4;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	static int[][] d;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		try {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			d = new int[N][N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				Arrays.fill(d[i], -1);
			}
			int M = Integer.parseInt(br.readLine());
			
			while(M --> 0) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken()) - 1;
				int e = Integer.parseInt(st.nextToken()) - 1;
				
				go(s, e);
				
				sb.append(d[s][e]).append('\n');
				
			}
			
			System.out.println(sb.toString());
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
	
	public static boolean go(int s, int e) {
		if(d[s][e] != -1) {
			return d[s][e] == 0 ? false : true;
		}
		if(s >= e) {
			d[s][e] = 1;
			return true;
		}
		if(arr[s] == arr[e] && go(s + 1, e - 1)) {
			d[s][e] = 1;
			return true;
		}
		else {
			d[s][e] = 0;
			return false;
		}
	}

}
