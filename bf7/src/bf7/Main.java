package bf7;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		try {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			
			int[] prob = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				prob[i] = Integer.parseInt(st.nextToken());
			}
			
			int ans = 0;
			for(int i = 0; i < (1 << N); i++) {
				int k = 0;
				int max = 0;
				int min = 1000000;
				int sum = 0;
				for(int j = 0; j < N; j++) {
					if((i & (1 << j)) != 0) {
						k++;
						max = max > prob[j] ? max : prob[j];
						min = min < prob[j] ? min : prob[j];
						sum += prob[j];
					}
				}
				if(k < 2 || max - min < X || sum > R || sum < L) {
					continue;
				}
				else {
					ans++;
				}
			}
			
			System.out.println(ans);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
