package dp3;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] t, p;
	static long[] d;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			N = Integer.parseInt(br.readLine());
			t = new int[N + 1];
			p = new int[N + 1];
			d = new long[N + 1];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				t[i] = Integer.parseInt(st.nextToken());
				p[i] = Integer.parseInt(st.nextToken());
			}
			
			d[0] = 0;
			for(int i = 0; i < N; i++) {
				d[i + 1] = Math.max(d[i + 1], d[i]);
				if(i + t[i] > N)
					continue;
				d[i + t[i]] = Math.max(d[i + t[i]], d[i] + p[i]);
			}
			
			System.out.println(d[N]);
			
			
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
