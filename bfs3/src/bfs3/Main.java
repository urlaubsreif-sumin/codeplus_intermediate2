package bfs3;
import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static People first;
	static People second;
	static People third;
	static int w, h;
	static int[][] arr;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		try {
			int TC = Integer.parseInt(br.readLine());
			while(TC --> 0) {
				st = new StringTokenizer(br.readLine());
				h = Integer.parseInt(st.nextToken());
				w = Integer.parseInt(st.nextToken());
				boolean get_first = false;
				arr = new int[h + 2][w + 2];
				for(int i = 1; i < h + 1; i++) {
					String input = br.readLine();
					for(int j = 1; j < w + 1; j++) {
						char ch = input.charAt(j - 1);
						if(ch == '*') arr[i][j] = 1;
						else if(ch == '#') arr[i][j] = 2;
						else if(ch == '$') {
							if(!get_first) {
								first = new People(i, j);
								get_first = true;
							}
							else {
								second = new People(i, j);
							}
						}
					}
				}
				third = new People(0, 0);
				
				int[][] one = bfs(first);
				int[][] two = bfs(second);
				int[][] three = bfs(third);
				
				
				
				int min = 200;
				for(int i = 0; i < h + 2; i++) {
					for(int j = 0; j < w + 2; j++) {
						if(arr[i][j] == 1)
							continue;
						int res = one[i][j] + two[i][j] + three[i][j];
						if(arr[i][j] == 2) {
							res -= 2;
						}
						if(res < 0) {
							continue;
						}
						min = min < res ? min : res;
					}
				}
				sb.append(min).append('\n');
				
			}
			
			System.out.println(sb.toString());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int[][] bfs(People p) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		Deque<Integer> queue = new ArrayDeque<>();
		int[][] check = new int[h + 2][w + 2];
		for(int i = 0; i < h + 2; i++) {
			Arrays.fill(check[i], -1);
		}
		int cur_i = p.i;
		int cur_j = p.j;
		queue.add(cur_i);
		queue.add(cur_j);
		check[cur_i][cur_j] = 0;
		while(!queue.isEmpty()) {
			cur_i = queue.pollFirst();
			cur_j = queue.pollFirst();
			//System.out.println(cur_i + " " + cur_j);
			for(int i = 0; i < 4; i++) {
				int next_i = cur_i + dy[i];
				int next_j = cur_j + dx[i];
				if(next_i < 0 || next_j < 0 || next_i >= h + 2 || next_j >= w + 2)
					continue;
				if(check[next_i][next_j] != -1)
					continue;
				if(arr[next_i][next_j] == 1)
					continue;
				if(arr[next_i][next_j] == 2) {
					check[next_i][next_j] = check[cur_i][cur_j] + 1;
					queue.addLast(next_i);
					queue.addLast(next_j);
				}
				else if(arr[next_i][next_j] == 0) {
					check[next_i][next_j] = check[cur_i][cur_j];
					queue.addFirst(next_j);
					queue.addFirst(next_i);
				}
			}
		}
		return check;
	}
}

class People {
	int i, j;
	People(int i, int j){
		this.i = i;
		this.j = j;
	}
}