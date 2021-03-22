package dp13;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			long[] d = new long[N + 1];
			
			for(int i = 1; i <= N; i++) {
				d[i] = d[i - 1] + 1;
				if(i - 3 < 1) {
					continue;
				}
				int v = 0;
				for(int j = 1; j <= i - 3; j++) {
					d[i] = Math.max(d[i], d[i - 2 - j] * (long)(j + 1));
				}
			}
			
			System.out.println(d[N]);
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

}
