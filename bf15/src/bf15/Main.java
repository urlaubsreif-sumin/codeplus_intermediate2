package bf15;
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
			boolean[][] check = new boolean[200][200];
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int ice1 = Integer.parseInt(st.nextToken());
				int ice2 = Integer.parseInt(st.nextToken());
				check[ice1 - 1][ice2 - 1] = true;
				check[ice2 - 1][ice1 - 1] = true;
			}
			
			int ans = 0;
			for(int i = 0; i < N; i++) {
				for(int j = i + 1; j < N; j++) {
					for(int k = j + 1; k < N; k++) {
						if(check[i][j] || check[i][k] || check[j][k])
							continue;
						ans++;
					}
				}
			}
			
			System.out.println(ans);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
