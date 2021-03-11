package bf34;
import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			int T = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int[] A = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			int m = Integer.parseInt(br.readLine());
			int[] B = new int[m];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < m; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			HashMap<Integer, Integer> first = new HashMap<>();
			HashMap<Integer, Integer> second = new HashMap<>();
			for(int i = 0; i < n; i++) {
				int sum = 0;
				for(int j = i; j < n; j++) {
					sum += A[j];
					first.put(sum, first.getOrDefault(sum, 0) + 1);
				}
				
			}
			for(int i = 0; i < m; i++) {
				int sum = 0;
				for(int j = i; j < m; j++) {
					sum += B[j];
					second.put(sum, second.getOrDefault(sum, 0) + 1);
				}
			}
			
			long ans = 0;
			for(int i : first.keySet()) {
				ans += ((long)first.get(i) * (long)second.getOrDefault(T - i, 0));
			}
			
			System.out.println(ans);
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
