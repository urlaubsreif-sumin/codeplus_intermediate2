package bfs9;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
	static int N;
	static int[][] arr;
	static ArrayList<Pair> nodes;
	static boolean[][] near;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			nodes = new ArrayList<>();
			Pair s = new Pair(-1, -1);
			int sn = -1;
			Pair e = new Pair(-1, -1);
			int en = -1;
			
			for(int i = 0; i < N; i++) {
				String input = br.readLine();
				for(int j = 0; j < N; j++) {
					char ch = input.charAt(j);
					if(ch == '*') {
						arr[i][j] = -1;
					}
					else if(ch == '#') {
						nodes.add(new Pair(i, j));
						arr[i][j] = nodes.size();
						if(s.i == -1) {
							s = new Pair(i, j);
							sn = nodes.size() - 1;
						}
						else {
							e = new Pair(i, j);
							en = nodes.size() - 1;
						}
					}
					else if(ch == '!') {
						nodes.add(new Pair(i, j));
						arr[i][j] = nodes.size();
					}
				}
				
			}
			
			near = new boolean[nodes.size()][nodes.size()];
			
			go(s, e);
			int res = bfs(s, sn, e, en);
			
			System.out.println(res);
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void go(Pair s, Pair e) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		for(int i = 0; i < nodes.size(); i++) {
			for(int k = 0; k < 4; k++) {
				int next_i = nodes.get(i).i + dy[k];
				int next_j = nodes.get(i).j + dx[k];
				while(next_i >= 0 && next_j >= 0 && next_i < N && next_j < N) {
					if(arr[next_i][next_j] < 0)
						break;
					if(arr[next_i][next_j] > 0) {
						near[i][arr[next_i][next_j] - 1] = true;
					}
					next_i += dy[k];
					next_j += dx[k];
				}
			}
		}
	}
	
	public static int bfs(Pair s, int sn, Pair e, int en) {
		Queue<Integer> queue = new LinkedList<>();
		int[] check = new int[nodes.size()];
		Arrays.fill(check, -1);
		queue.add(sn);
		check[sn] = 0;
		while(!queue.isEmpty()) {
			int cur = queue.remove();
			for(int i = 0; i < nodes.size(); i++) {
				if(near[cur][i] && check[i] == -1) {
					check[i] = check[cur] + 1;
					queue.add(i);
				}
			}
		}
		return check[en] - 1;
	}
}

class Pair{
	int i;
	int j;
	Pair(int i, int j){
		this.i = i;
		this.j = j;
	}
}