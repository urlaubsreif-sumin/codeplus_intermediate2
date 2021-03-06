package bf17;
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
			
			boolean[][] rel = new boolean[N][N];
			int[] friend = new int[N];
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int p1 = Integer.parseInt(st.nextToken()) - 1;
				int p2 = Integer.parseInt(st.nextToken()) - 1;
				rel[p1][p2] = true;
				rel[p2][p1] = true;
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(rel[i][j]) {
						friend[i]++;
					}
				}
			}
			
			int min = -1;
			for(int i = 0; i < N; i++) {
				for(int j = i + 1; j < N; j++) {
					if(!rel[i][j]) continue;
					for(int k = j + 1; k < N; k++) {
						if(!rel[j][k] || !rel[i][k]) continue;
						int res = friend[i] + friend[j] + friend[k] - 6;
						if(min == -1 || min > res) {
							min = res;
						}
					}
				}
			}
			
			System.out.println(min);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
