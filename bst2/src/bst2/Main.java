package bst2;
import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		TreeSet<String> ts = new TreeSet<>();
		TreeSet<String> ans = new TreeSet<>();
		
		try {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int cnt = 0;
			
			while(n --> 0) {
				String input = br.readLine();
				ts.add(input);
			}
			
			while(m --> 0) {
				String input = br.readLine();
				if(ts.contains(input)) {
					ans.add(input);
					cnt++;
				}
			}
			
			sb.append(cnt).append('\n');
			while(!ans.isEmpty()) {
				sb.append(ans.pollFirst()).append('\n');
			}
			
			System.out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
