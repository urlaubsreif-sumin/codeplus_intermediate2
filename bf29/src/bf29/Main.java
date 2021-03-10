package bf29;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][][] maze = new int[5][5][5];
	static int[][][] check = new int[5][5][5];
	static int[] order = {0, 1, 2, 3, 4};
	static int[] dx = {0, 1, 0, -1, 0, 0};
	static int[] dy = {0, 0, 0, 0, 1, -1};
	static int[] dz = {-1, 0, 1, 0, 0, 0};
	static int min = -1;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		try {
			for(int n = 0; n < 5; n++) {
				for(int i = 0; i < 5; i++) {
					st = new StringTokenizer(br.readLine());
					for(int j = 0; j < 5; j++) {
						maze[n][i][j] = Integer.parseInt(st.nextToken());
					}
				}
			}
			while(true) {
				for(int first = 0; first < 4; first++) {
					if(first > 0)
						rotate(order[0]);
					for(int second = 0; second < 4; second++) {
						if(second > 0)
							rotate(order[1]);
						for(int third = 0; third < 4; third++) {
							if(third > 0)
								rotate(order[2]);
							for(int fourth = 0; fourth < 4; fourth++) {
								if(fourth > 0)
									rotate(order[3]);
								for(int fifth = 0; fifth < 4; fifth++) {
									if(fifth > 0)
										rotate(order[4]);
									bfs();
									check = new int[5][5][5];
								}
							}
						}
					}
				}
				if(!next_permutation()) {
					break;
				}
			}
			
			System.out.println(min);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void rotate(int n) {
		int[][] temp = new int[5][5];
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				temp[i][j] = maze[n][j][4 - i];
			}
		}
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				maze[n][i][j] = temp[i][j];
			}
		}
	}
	
	public static boolean next_permutation() {
		int idx = 4;
		while(order[idx] < order[idx - 1]) {
			idx--;
			if(idx < 1)
				return false;
		}
		for(int i = 4; i >= idx; i--) {
			if(order[idx - 1] < order[i]) {
				int temp = order[idx - 1];
				order[idx - 1] = order[i];
				order[i] = temp;
				break;
			}
		}
		int s = idx;
		int e = 4;
		for(int i = s; i < (s + e + 1) / 2; i++) {
			int temp = order[i];
			order[i] = order[s + e - i];
			order[s + e - i] = temp;
		}
		return true;
	}
	//cur.z"¹øÂ°" ÆÇ
	public static void bfs() {
		Queue<Pos> queue = new LinkedList<>();
		Pos init = new Pos(0, 0, 0);
		if(maze[order[0]][0][0] != 1) {
			return;
		}
		check[order[init.z]][init.y][init.x] = 1;
		queue.add(init);
		while(!queue.isEmpty()) {
			Pos cur = queue.remove();
			if(cur.x == 4 && cur.y == 4 && cur.z == 4) {
				if(min == -1 || min > check[order[cur.z]][cur.y][cur.x] - 1) {
					min = check[order[cur.z]][cur.y][cur.x] - 1;
				}
				return;
			}
			for(int i = 0; i < 6; i++) {
				int next_x = cur.x + dx[i];
				int next_y = cur.y + dy[i];
				int next_z = cur.z + dz[i];
				if(isValid(next_x, next_y, next_z)) {
					Pos next = new Pos(next_x, next_y, next_z);
					check[order[next.z]][next.y][next.x] = check[order[cur.z]][cur.y][cur.x] + 1;
					queue.add(next);
					//System.out.println("*" + next.x + " " + next.y + " " + order[next.z]);
				}
			}
		}
	}
	
	public static boolean isValid(int x, int y, int z) {
		if(x < 0 || y < 0 || z < 0)
			return false;
		if(x >= 5 || y >= 5 || z >= 5)
			return false;
		if(check[order[z]][y][x] != 0)
			return false;
		if(maze[order[z]][y][x] == 0)
			return false;
		return true;
	}

}

class Pos {
	int x, y, z;
	Pos(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
