package bf10;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static ArrayList<CCTV> cctv = new ArrayList<>();
	static boolean[][] check;
	static boolean[][] init_chk;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			check = new boolean[N][M];
			init_chk = new boolean[N][M];
			int total = N * M;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] != 0) {
						total--;
						check[i][j] = true;
						init_chk[i][j] = true;
					}
					if(map[i][j] > 0 && map[i][j] < 6) {
						cctv.add(new CCTV(i, j, map[i][j]));
					}
				}
			}
			int max = 0;
			for(int i = 0; i < (1 << cctv.size() * 2); i++) {
				int[] dirs = gen(i);
				int res = 0;
				for(int j = 0; j < cctv.size(); j++) {
					res += go(cctv.get(j).i, cctv.get(j).j, dirs[j]);
				}
				max = max > res ? max : res;
				
				init();
			}
			///
			
			System.out.println(total - max);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int[] gen(int bin) {
		int[] res = new int[cctv.size()];
		for(int i = 0; i < cctv.size(); i++) {
			res[i] = bin & 3;
			bin >>= 2;
		}
		return res;
	}
	
	public static void init() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				check[i][j] = init_chk[i][j];
			}
		}
	}
	
	public static int go(int i, int j, int dir) {
		int res = 0;
		switch(map[i][j]) {
		case 1:
			res = scan(dir, i, j);
			break;
			
		case 2:
			res += scan(dir, i, j);
			res += scan(3 - dir, i, j);
			break;
			
		case 3:
			res += scan(dir, i, j);
			if(dir == 0) {
				res += scan(2, i, j);
			}
			else if(dir == 1) {
				res += scan(0, i, j);
			}
			else if(dir == 2) {
				res += scan(3, i, j);
			}
			else if(dir == 3) {
				res += scan(1, i, j);
			}
			break;
			
		case 4:
			res += scan(dir, i, j);
			res += scan((dir + 1) % 4, i, j);
			res += scan((dir + 2) % 4, i, j);
			break;
			
		case 5:
			for(int d = 0; d < 4; d++) {
				res += scan(d, i, j);
			}
			break;
		}
		return res;
	}
	
	public static int scan(int dir, int i, int j) {
		//0:╩С / 1:аб / 2:©Л / 3:го
		int[] dx = {0, -1, 1, 0};
		int[] dy = {-1, 0, 0, 1};
		int cur_i = i;
		int cur_j = j;
		int res = 0;
		
		while(cur_i >= 0 && cur_i < N && cur_j >= 0 && cur_j < M) {
			if(!check[cur_i][cur_j]) {
				res++;
				check[cur_i][cur_j] = true;
			}
			else if(map[cur_i][cur_j] == 6) {
				break;
			}
			cur_i += dy[dir];
			cur_j += dx[dir];
		}
		return res;		
	}
}

class CCTV {
	int i, j;
	int num;
	int dir;
	CCTV(int i, int j, int num){
		this.i = i;
		this.j = j;
		this.num = num;
		this.dir = 0;
	}
}