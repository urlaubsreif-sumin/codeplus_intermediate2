package bf35;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] CD;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			int N = Integer.parseInt(br.readLine());
			int[] A = new int[N];
			int[] B = new int[N];
			int[] C = new int[N];
			int[] D = new int[N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				A[i] = Integer.parseInt(st.nextToken());
				B[i] = Integer.parseInt(st.nextToken());
				C[i] = Integer.parseInt(st.nextToken());
				D[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] AB = new int[N * N];
			CD = new int[N * N];
			
			int idx = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					AB[idx] = A[i] + B[j];
					CD[idx++] = C[i] + D[j];
				}
			}
			
			Arrays.sort(CD);
			
			long ans = 0;
			for(int n : AB) {
				ans += (find_ub(-n) - find_lb(-n));
			}
			
			System.out.println(ans);
			
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int find_lb(int key) {
		int start = 0;
		int end = CD.length;
		while(start < end) {
			int mid = (start + end) / 2;
			if(key <= CD[mid]) {
				end = mid;
			}
			else {
				start = mid + 1;
			}
		}
		return start;
	}
	
	public static int find_ub(int key) {
		int start = 0;
		int end = CD.length;
		while(start < end) {
			int mid = (start + end) / 2;
			if(key >= CD[mid]) {
				start = mid + 1;
			}
			else {
				end = mid;
			}
		}
		return start;
	}
}
