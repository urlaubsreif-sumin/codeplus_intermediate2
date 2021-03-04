package bf3;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			boolean[] check = new boolean[1001];
			int ans = 0;
			for(int a = 0; a <= N; a++) {
				for(int b = 0; b <= N; b++) {
					for(int c = 0; c <= N; c++) {
						int d = N - a - b - c;
						if(d < 0)
							continue;
						
						int num = a * 1 + b * 5 + c * 10 + d * 50;
						if(check[num]) {
							continue;
						}
						check[num] = true;
						ans++;
					}
				}
			}
			
			System.out.println(ans);
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

}
