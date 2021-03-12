package bfs8;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static int w, h;
	static char[][] arr;
	static int[] order;
	static int[][] dist;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String input;
		try {
			while(!(input = br.readLine()).equals("0 0")) {
				st = new StringTokenizer(input);
				w = Integer.parseInt(st.nextToken());
				h = Integer.parseInt(st.nextToken());
				ArrayList<Pair> points = new ArrayList<>();
				arr = new char[h][w];
				int start = 0;
				int idx = 0;
				for(int i = 0; i < h; i++) {
					String s = br.readLine();
					for(int j = 0; j < w; j++) {
						arr[i][j] = s.charAt(j);
						if(arr[i][j] == '*' || arr[i][j] == 'o') {
							points.add(new Pair(i, j));
							if(arr[i][j] == 'o') {
								start = idx;
							}
							idx++;
						}
					}
				}
				if(points.size() == 1) {
					sb.append(0);
					continue;
				}
				order = new int[points.size()];
				dist = new int[points.size()][points.size()];
				for(int i = 0; i < points.size(); i++) {
					Arrays.fill(dist[i], -2);
				}
				order[0] = start;
				int k = 1;
				for(int i = 0; i < points.size(); i++) {
					if(i != start) {
						order[k++] = i;
					}
				}
				
				int min = -1;
				while(true) {
					int res = 0;
					if(arr[points.get(order[0]).i][points.get(order[0]).j] == 'o') {
						for(int i = 0; i < order.length - 1; i++) {
							int d = dist[order[i]][order[i + 1]];
							if(d == -2) {
								d = bfs(points.get(order[i]), points.get(order[i + 1]));
								dist[order[i]][order[i + 1]] = d;
							}
							
							//sb.append(order[i]).append(" ").append(d).append(" / ");
							if(d != -1) {
								res +=d;
								if(min != -1 && min < res) {
									continue;
								}
							}
							else {
								res = -1;
								break;
							}
						}
						//sb.append('\n');
						if(min == -1 || (res != -1 && min > res)) {
							min = res;
						}
					}
					else {
						break;
					}
					if(!next_permutation()) {
						break;
					}
				}
				
				if(min == 0) {
					sb.append(-1).append('\n');
				}
				else {
					sb.append(min).append('\n');
				}
				
				
			}
			
			System.out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static boolean next_permutation() {
		int idx = order.length - 1;
		while(order[idx] < order[idx - 1]) {
			idx--;
			if(idx - 1 < 0) {
				return false;
			}
		}
		for(int i = order.length - 1; i >= idx; i--) {
			if(order[i] > order[idx - 1]) {
				int temp = order[idx - 1];
				order[idx - 1] = order[i];
				order[i] = temp;
				break;
			}
			else if(i == idx) {
				return false;
			}
		}
		
		int s = idx;
		int e = order.length - 1;
		for(int i = s; i < (s + e + 1) / 2; i++) {
			int temp = order[i];
			order[i] = order[e + s - i];
			order[e + s - i] = temp;
		}
		return true;
	}
	
	public static int bfs(Pair s, Pair e) {
		Queue<Pair> queue = new LinkedList<>();
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int[][] check = new int[h][w];
		Pair cur = s;
		check[cur.i][cur.j] = 1;
		queue.add(cur);
		while(!queue.isEmpty()) {
			cur = queue.remove();
			if(cur.i == e.i && cur.j == e.j) {
				return check[cur.i][cur.j] - 1;
			}
			for(int i = 0; i < 4; i++) {
				int next_i = cur.i + dy[i];
				int next_j = cur.j + dx[i];
				if(next_i < 0 || next_j < 0 || next_i >= h || next_j >= w)
					continue;
				if(check[next_i][next_j] != 0)
					continue;
				if(arr[next_i][next_j] == 'x')
					continue;
				check[next_i][next_j] = check[cur.i][cur.j] + 1;
				queue.add(new Pair(next_i, next_j));
			}
		}
		return -1;
	}

}
class Pair {
	int i;
	int j;
	Pair(int i, int j){
		this.i = i;
		this.j = j;
	}
}
