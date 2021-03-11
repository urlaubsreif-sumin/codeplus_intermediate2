package bf33;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static int[] arr;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] A = partialSum(0, N / 2);
			int[] B = partialSum(N / 2, N);
			
			int a = 0;
			int b = B.length - 1;
			long ans = 0;
			int sum = 0;
			while(a < A.length && b >= 0) {
				sum = A[a] + B[b];
				if(sum == S) {
					//System.out.println(a + " " + b);
					long na = 1, nb = 1;
					while(a + 1 < A.length && A[a] == A[a + 1]) {
						a++;
						na++;
					}
					while(b > 0 && B[b] == B[b - 1]) {
						b--;
						nb++;
					}
					ans += (na * nb);
				}
				if(sum > S) {
					b--;
				}
				else if(sum <= S) {
					a++;
				}
			}
			if(S == 0) {
				ans--; //아무것도 포함하지 않는 경우는 뺸다.
			}
			System.out.println(ans);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static int[] partialSum(int from, int to) {
		int n = to - from;
		int[] tmp = new int[1 << n];
		for(int i = 0; i < (1 << n); i++) {
			int sum = 0;
			for(int j = 0; j < n; j++) {
				if((i & (1 << j)) != 0) {
					sum += arr[from + j];
				}
			}
			tmp[i] = sum;
		}
		Arrays.sort(tmp);
		return tmp;
	}
}