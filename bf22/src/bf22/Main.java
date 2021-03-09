package bf22;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char[][] arr;
	static int max = 0;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new char[N][M];
			
			for(int i = 0; i < N; i++) {
				String input = br.readLine();
				for(int j = 0; j < M; j++) {
					arr[i][j] = input.charAt(j);
				}
			}
			
			go(0, 0, 0, 1);
			
			System.out.println(max);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void go(int r, int c, int cnt, int w) {
		if(cnt == 2) {
			max = max > w ? max : w;
			return;
		}
		for(int i = r; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(i == r && j < c)
					continue;
				int sz = 0;
				for(sz = 0; ok(i, j, sz) ;sz++) {
					arr[i][j - sz] = '*';
					arr[i][j + sz] = '*';
					arr[i - sz][j] = '*';
					arr[i + sz][j] = '*';
					go(i, j, cnt + 1, w * (sz * 4 + 1));
				}
				
				for(int k = sz - 1; k >= 0; k--) {
					arr[i][j - k] = '#';
					arr[i][j + k] = '#';
					arr[i - k][j] = '#';
					arr[i + k][j] = '#';
				}
			}
		}
	}
	
	public static boolean ok(int i, int j, int sz) {
		if(i - sz < 0 || i + sz >= N || j - sz < 0 || j + sz >= M)
			return false;
		if(arr[i][j - sz] == '#' && arr[i][j + sz] == '#' && arr[i - sz][j] == '#' && arr[i + sz][j] == '#') {
			return true;
		}
		return false;
	}

}
