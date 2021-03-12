package bfs1;
import java.io.*;
import java.util.StringTokenizer;
public class Main {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			char[][] map =new char[R][C];
			for(int i = 0; i < R; i++) {
				String input = br.readLine();
				for(int j = 0; j < C; j++) {
					map[i][j] = input.charAt(j);
				}
			}
			
			int res = 1;
			
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(map[i][j] == 'W') {
						for(int k = 0; k < 4; k++) {
							int next_i = i + dy[k];
							int next_j = j + dx[k];
							if(next_i < 0 || next_j < 0 || next_i >= R || next_j >= C || map[next_i][next_j] == 'W')
								continue;
							if(map[next_i][next_j] == 'S') {
								res = 0;
								System.out.println(res);
								return;
							}
							map[next_i][next_j] = 'D';
						}
					}
				}
			}
			sb.append(res).append('\n');
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					sb.append(map[i][j]);
				}
				sb.append('\n');
			}
			
			System.out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
