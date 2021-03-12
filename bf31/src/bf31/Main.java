package bf31;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			int[] A = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			int L = 0;
			int R = 0;
			int sum = A[0];
			int len = 1;
			int min = 0;
			while(L >= 0 && R < N) {
				if(sum >= S) {
					//System.out.println(L + " " + R + " " + len);
					if(min == 0 || min > len) {
						min = len;
					}
				}
				if(sum <= S) {
					R++;
					len++;
					if(R < N)
						sum += A[R];
				}
				else if(sum > S) {
					sum -= A[L];
					len--;
					L++;
				}
			}
			
			System.out.println(min);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
