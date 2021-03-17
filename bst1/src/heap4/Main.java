package heap4;
import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		TreeSet<String> ts = new TreeSet<>();
		StringBuilder sb = new StringBuilder();
		
		try {
			int n = Integer.parseInt(br.readLine());
			while(n --> 0) {
				st = new StringTokenizer(br.readLine());
				String input = st.nextToken();
				String op = st.nextToken();
				
				if(op.equals("enter")) {
					ts.add(input);
				}
				else if(op.equals("leave")) {
					ts.remove(input);
				}
			}
			
			while(!ts.isEmpty()) {
				sb.append(ts.pollLast()).append('\n');
			}
			
			System.out.println(sb.toString());
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
