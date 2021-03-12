package bfs2;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int F, S, G, U, D;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			F = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			G = Integer.parseInt(st.nextToken());
			U = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			
			int res = bfs();
			if(res == -1) {
				System.out.println("use the stairs");
			}
			else {
				System.out.println(res);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}
	
	public static int bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] check = new int[F + 1];
		check[0] = 1;
		int res = -1;
		
		int cur = S;
		queue.add(cur);
		check[cur] = 1;
		
		while(!queue.isEmpty()) {
			cur = queue.remove();
			if(cur == G) {
				res = check[cur] - 1;
				break;
			}
			int next = cur + U;
			if(next <= F && next > 0 && check[next] == 0) {
				queue.add(next);
				check[next] = check[cur] + 1;
			}
			next = cur - D;
			if(next <= F && next > 0 && check[next] == 0) {
				queue.add(next);
				check[next] = check[cur] + 1;
			}
		}
		
		return res;
		
	}

}
