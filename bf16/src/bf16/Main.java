package bf16;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static char[][] board;
	static int N, M;
	static int blank;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		try {
			int tc = 0;
			while(true) {
				tc++;
				st = new StringTokenizer(br.readLine());
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				board = new char[N][M];
				blank = 0;
				
				for(int i = 0; i < N; i++) {
					String input = br.readLine();
					for(int j = 0; j < M; j++) {
						board[i][j] = input.charAt(j);
						if(board[i][j] == '.') {
							blank++;
						}
					}
				}
				int min = -1;
				sb.append("Case ").append(tc).append(": ");
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						if(board[i][j] == '.') {
							blank--;
							board[i][j] = 'o';
							int res = go(i, j, 0);
							board[i][j] = '.';
							blank++;
							if(min == -1 || (res != -1 && min > res)) {
								min = res;
							}
						}
					}
				}
				sb.append(min).append("\n");
				if(!br.ready())
					break;				
			}
			
			System.out.println(sb.toString());
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int go(int si, int sj, int move) {
		if(blank == 0) {
			return move;
		}
		int min = -1;
		for(int k = 0; k < 4; k++) {
			int ni = si;
			int nj = sj;
			int cnt = 0;
			int res = -1;
			while(true) {
				ni += dy[k];
				nj += dx[k];
				//범위를 벗어나거나 벽을 만나거나 이미 왔던 곳이면 다음 방향으로 이동한다.
				if(ni < 0 || ni >= N || nj < 0 || nj >= M || board[ni][nj] == '*' || board[ni][nj] == 'o') {
					ni -= dy[k];
					nj -= dx[k];
					if(cnt == 0)
						break;
					res = go(ni, nj, move + 1);
					break;
				}
				//방향대로 움직인다.
				board[ni][nj] = 'o';
				blank--;
				cnt++;				
			}
			//왔던 길 되돌리기
			while(ni != si || nj != sj) {
				board[ni][nj] = '.';
				ni -= dy[k];
				nj -= dx[k];
			}
			blank += cnt;
			if(min == -1 || (res != -1 && min > res)) {
				min = res;
			}
		}
		return min;
	}
	

}
