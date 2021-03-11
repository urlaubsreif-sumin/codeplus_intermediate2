package bf30;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] A = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			int L = 0;
			int R = 0;
			int sum = A[0];
			int n = 0;
			
			while(L >= 0 && R < N) {
				//System.out.println(L + " " + R + " " + sum);
				if(sum == M)
					n++;
				if(sum <= M) {
					R++;
					if(R < N)
						sum += A[R];
				}
				else if(sum > M) {
					sum -= A[L];
					L++;
				}
			}
			
			System.out.println(n);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
