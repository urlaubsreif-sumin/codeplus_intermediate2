package dp10;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			int T = Integer.parseInt(br.readLine());
			int[] d = new int[5001];
			d[0] = 1;
			d[2] = 1;
			
			while(T --> 0) {
				int L = Integer.parseInt(br.readLine());
				if(L % 2 != 0) {
					sb.append(0).append('\n');
					continue;
				}
				for(int l = 4; l <= L; l += 2) {
					int sum = 0;
					for(int i = 2; i <= l; i += 2) {
						sum = (sum + (int)((long)d[l - i] * (long)d[i - 2] % 1000000007L)) % 1000000007;
					}
					d[l] = sum;
				}
				
				sb.append(d[L]).append('\n');
			}
			
			System.out.println(sb.toString());
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

}
