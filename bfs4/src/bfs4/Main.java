package bfs4;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			boolean[][] check = bfs(A, B, C);
			for(int b = check[0].length - 1; b >= 0; b--) {
				if(check[0][b]) {
					sb.append(C - b).append(' ');
				}
			}
			
			System.out.println(sb.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean[][] bfs(int A, int B, int C) {
		int total = C;
		boolean[][] check = new boolean[A + 1][B + 1];
		Queue<Integer> queue = new LinkedList<>();
		int cur_a = 0;
		int cur_b = 0;
		int cur_c = total;
		check[cur_a][cur_b] = true;
		queue.add(cur_a);
		queue.add(cur_b);
		while(!queue.isEmpty()) {
			cur_a = queue.remove();
			cur_b = queue.remove();
			cur_c = total - cur_a - cur_b;
			
			//C -> A
			int next_a = Math.min(cur_a + cur_c, A);
			int next_b = cur_b;
			int next_c = Math.max(cur_a + cur_c - A, 0);
			if(!check[next_a][next_b]) {
				check[next_a][next_b] = true;
				queue.add(next_a);
				queue.add(next_b);
			}
			
			//C -> B
			next_a = cur_a;
			next_b = Math.min(cur_b + cur_c, B);
			next_c = Math.max(cur_b + cur_c - B, 0);
			if(!check[next_a][next_b]) {
				check[next_a][next_b] = true;
				queue.add(next_a);
				queue.add(next_b);
			}
			
			//B -> A
			next_a = Math.min(cur_a + cur_b, A);
			next_b = Math.max(cur_a + cur_b - A, 0);
			next_c = cur_c;
			if(!check[next_a][next_b]) {
				check[next_a][next_b] = true;
				queue.add(next_a);
				queue.add(next_b);
			}
			
			//B -> C
			next_a = cur_a;
			next_b = Math.max(cur_b + cur_c - C, 0);
			next_c = Math.min(cur_b + cur_c, C);
			if(!check[next_a][next_b]) {
				check[next_a][next_b] = true;
				queue.add(next_a);
				queue.add(next_b);
			}
			
			//A -> B
			next_a = Math.max(cur_a + cur_b - B, 0);
			next_b = Math.min(cur_b + cur_a, B);
			next_c = cur_c;
			if(!check[next_a][next_b]) {
				check[next_a][next_b] = true;
				queue.add(next_a);
				queue.add(next_b);
			}
			
			//A -> C
			next_a = Math.max(cur_a + cur_c - C, 0);
			next_b = cur_b;
			next_c = Math.min(cur_a + cur_c, C);
			if(!check[next_a][next_b]) {
				check[next_a][next_b] = true;
				queue.add(next_a);
				queue.add(next_b);
			}
		}
		return check;
		
	}

}
