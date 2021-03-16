package stack2;
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String input;
		try {
			while(!(input = br.readLine()).equals("0")) {
				Stack<Integer> s = new Stack<>();
				st = new StringTokenizer(input);
				int n = Integer.parseInt(st.nextToken());
				int[] hist = new int[n];
				long max = 0;
				for(int i = 0; i < n; i++) {
					hist[i] = Integer.parseInt(st.nextToken());
					while(!s.isEmpty() && hist[s.peek()] > hist[i]) {
						int cur = s.pop();
						long sz = hist[cur];
						if(s.isEmpty()) {
							sz *= i;
						}
						else {
							sz *= (i - s.peek() - 1);
						}
						max = max > sz ? max : sz;
					}
					s.push(i);
				}
				
				while(!s.isEmpty()) {
					int cur = s.pop();
					long sz = hist[cur];
					if(s.isEmpty()) {
						sz *= (long)n;
					}
					else {
						sz *= (long)(n - s.peek() - 1);
					}
					max = max > sz ? max : sz;
				}
				sb.append(max).append('\n');
			}
			
			System.out.println(sb.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
