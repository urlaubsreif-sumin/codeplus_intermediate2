package heap1;
import java.io.*;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		
		try {
			int N = Integer.parseInt(br.readLine());
			for(int i = 0; i < N; i++) {
				int x = Integer.parseInt(br.readLine());
				if(x == 0) {
					if(pq.isEmpty()) {
						sb.append(0).append('\n');
					}
					else {
						sb.append(-pq.poll()).append('\n');
					}
				}
				else {
					pq.add(-x);
				}
			}
			
			System.out.println(sb.toString());
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
