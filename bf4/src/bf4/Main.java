package bf4;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static char[][] pic;
	static boolean[][] check;
	static int N, M;
	static int max_size;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			max_size = Math.min(N, M) / 2;
			pic = new char[N][M];
			check = new boolean[N][M];
			
			for(int i = 0; i < N; i++) {
				String input = br.readLine();
				for(int j = 0; j < M; j++) {
					pic[i][j] = input.charAt(j);
					if(pic[i][j] == '*') {
						check[i][j] = true;
					}
				}
			}
			
			int n = 0;
			for(int i = 0; i <= N - 2; i++) {
				for(int j = 0; j <= M - 2; j++) {
					if(pic[i][j] == '*') {
						int sz = check(i, j);
						if(sz <= 0) {
							continue;
						}
						else {
							n++;
							//System.out.println(i + " " + j + " " + sz);
							sb.append('\n').append(i + 1).append(' ').append(j + 1).append(' ').append(sz);
						}
					}
				}
			}
			
			sb.insert(0, n);
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(check[i][j]) {
						sb = new StringBuilder();
						sb.append(-1);
						break;
					}
				}
			}
			
			System.out.println(sb.toString());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int check(int i, int j) {
		int k = 1;
		while(k <= max_size) {
			if(i + k >= N || i - k < 0 || j + k >= M || j - k < 0)
				break;
			if(pic[i + k][j] == '*' && pic[i - k][j] == '*' && pic[i][j + k] == '*' && pic[i][j - k] == '*') {
				k++;
			}
			else {
				break;
			}
		}
		k--;
		
		if(k != 0) {
			for(int r = i - k; r <= i + k; r++) {
				check[r][j] = false;
			}
			for(int c = j - k; c <= j + k; c++) {
				check[i][c] = false;
			}
		}
		
		return k;
	}

}
