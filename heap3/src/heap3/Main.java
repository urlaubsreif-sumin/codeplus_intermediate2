package heap3;
import java.io.*;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> maxheap = new PriorityQueue<>();
		PriorityQueue<Integer> minheap = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		try {
			int N = Integer.parseInt(br.readLine());
			while(N --> 0) {
				int x = Integer.parseInt(br.readLine());
				if(maxheap.isEmpty() && minheap.isEmpty()) {
					maxheap.add(-x);
				}
				else if(maxheap.size() > minheap.size()) {
					if(-maxheap.peek() > x) {
						minheap.add(-maxheap.poll());
						maxheap.add(-x);
					}
					else {
						minheap.add(x);
					}
				}
				else if(maxheap.size() <= minheap.size()) {
					if(minheap.peek() < x) {
						maxheap.add(-minheap.poll());
						minheap.add(x);						
					}
					else {
						maxheap.add(-x);
					}
				}
				
				sb.append(-maxheap.peek()).append('\n');
				
			}
			
			System.out.print(sb.toString());
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
