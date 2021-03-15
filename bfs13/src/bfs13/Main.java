package bfs13;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static String[] arr;
	static String[] answer = {"", "", ""};
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		arr = new String[3];
		for(int i = 0; i < 3; i++) {
			try {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				if(n > 0) {
					arr[i] = st.nextToken();
					for(int j = 0; j < n; j++) {
						answer[arr[i].charAt(j) - 'A'] += arr[i].charAt(j);
					}
				}
				else {
					arr[i] = "";
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		int res = bfs();
		
		System.out.println(res);
	}
	
	public static int bfs() {
		Queue<List<String>> queue = new LinkedList<>();
		HashMap<List<String>, Integer> hm = new HashMap<>();
		hm.put(Collections.unmodifiableList(Arrays.asList(arr)), 0);
		queue.add(Arrays.asList(arr));
		while(!queue.isEmpty()) {
			String[] cur = queue.remove().toArray(new String[3]);
			if(hm.containsKey(Collections.unmodifiableList(Arrays.asList(answer)))) {
				return hm.get(Collections.unmodifiableList(Arrays.asList(answer)));
			}
			for(int from = 0; from < 3; from++) {
				for(int to = 0; to < 3; to++) {
					if(from == to)
						continue;
					if(cur[from].isEmpty())
						continue;
					String[] next = {cur[0], cur[1], cur[2]};
					next[to] += next[from].charAt(next[from].length() - 1);
					next[from] = next[from].substring(0, next[from].length() - 1);
					if(hm.containsKey(Collections.unmodifiableList(Arrays.asList(next))))
						continue;
					queue.add(Arrays.asList(next));
					hm.put(Collections.unmodifiableList(Arrays.asList(next)), hm.get(Arrays.asList(cur)) + 1);
				}
			}
		}
		return -1;
	}
}
