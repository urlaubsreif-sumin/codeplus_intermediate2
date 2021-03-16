package stack3;
import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Pair> stack = new Stack<>();
		long ans = 0L;
		try {
			int N = Integer.parseInt(br.readLine());
			int[] h = new int[N];
			for(int i = 0; i < N; i++) {
				h[i] = Integer.parseInt(br.readLine());
				int cnt = 1;
				while(!stack.isEmpty()) {
					if(stack.peek().h <= h[i]) {
						ans += (long)stack.peek().n;
						if(stack.peek().h == h[i]) {
							cnt += stack.peek().n;
						}
						stack.pop();
					}
					else {
						break;
					}
				}
				if(!stack.isEmpty()) {
					ans += 1L;
				}
				stack.push(new Pair(h[i], cnt));
			}
			
			
			System.out.println(ans);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

class Pair {
	int h;
	int n;
	Pair(int h, int n){
		this.h = h;
		this.n = n;
	}
}
