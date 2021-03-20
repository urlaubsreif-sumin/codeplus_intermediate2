package dp6;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int K;
	static int[] arr;
	static int[][] d;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		try {
			int T = Integer.parseInt(br.readLine());
			while(T --> 0) {
				K = Integer.parseInt(br.readLine());
				arr = new int[K];
				d = new int[K][K];
				st = new StringTokenizer(br.readLine());
				for(int i = 0; i < K; i++) {
					arr[i] = Integer.parseInt(st.nextToken());
				}
				
				sb.append(go(0, K - 1)).append('\n');	
			}
			
			System.out.println(sb.toString());
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int go(int s, int e) {
		if(s == e || d[s][e] != 0) {
			return d[s][e];
		}
		if(s + 1 == e) {
			d[s][e] = arr[s] + arr[e];
			return arr[s] + arr[e];
		}
		int sum = 0;
		for(int i = s; i <= e; i++) {
			sum += arr[i];
		}
		int min = -1;
		for(int i = s; i < e; i++) {
			int res = go(s, i) + go(i + 1, e);
			if(min == -1 || min > res) {
				min = res;
			}
		}
		d[s][e] = min + sum;
		return d[s][e];
	}

}
