package math9;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			long M = Long.parseLong(st.nextToken());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			long cnt = 0;
			for(int i = 1; i < (1 << N); i++) {
				long mod = 1;
				int k = 0;
				for(int j = 0; j < N; j++) {
					if((i & (1 << j)) != 0) {
						k++;
						mod *= (long)arr[j];
					}
				}
				if(k % 2 != 0) {
					cnt += (M / mod);
				}
				else {
					cnt -= (M / mod);
				}
			}
			
			System.out.println(cnt);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

}
