package bf12;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static int[] d;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			ArrayList<Store> store = new ArrayList<>();
			ArrayList<House> house = new ArrayList<>();
			
			int[][] map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						house.add(new House(i, j));
					}
					else if(map[i][j] == 2) {
						store.add(new Store(i, j));
					}
				}
			}
			
			d = new int[store.size()];
			for(int i = 0; i < M; i++) {
				d[i] = 1;
			}
			Arrays.sort(d);
			
			int[] dist = new int[house.size()];
			int min = 0;
			while(true) {
				//System.out.println();
				for(int i = 0; i < store.size(); i++) {
					//System.out.print(d[i]);
					//i번째 치킨 집에 폐업하지 않으면
					if(d[i] == 1) {
						for(int j = 0; j < house.size(); j++) {
							int val = Math.abs(house.get(j).i - store.get(i).i) + Math.abs(house.get(j).j - store.get(i).j);
							if(dist[j] == 0 || dist[j] > val) {
								dist[j] = val;
							}
						}
					}
				}
				int sum = 0;
				for(int i = 0; i < house.size(); i++) {
					sum += dist[i];
				}
				//System.out.println();
				if(min == 0 || min > sum) {
					min = sum;
				}
				
				if(!next_permutation()) {
					break;
				}
				for(int i = 0; i < dist.length; i++) {
					dist[i] = 0;
				}
			}
			
			System.out.println(min);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static boolean next_permutation() {
		int idx = d.length - 1;
		if(idx - 1 < 0)
			return false;
		while(d[idx] <= d[idx - 1]) {
			idx--;
			if(idx - 1 < 0) {
				return false;
			}
		}
		for(int i = d.length - 1; i > idx - 1; i--) {
			if(d[i] > d[idx - 1]) {
				d[i] = 0;
				d[idx - 1] = 1;
				break;
			}
		}
		int s = idx;
		int e = d.length - 1;
		for(int i = s; i < (s + e + 1) / 2; i++) {
			int temp = d[i];
			d[i] = d[e + s - i];
			d[e + s - i] = temp;
		}
		return true;
	}

}

class Store {
	int i, j;
	Store(int i, int j){
		this.i = i;
		this.j = j;
	}
}

class House {
	int i, j;
	House(int i, int j){
		this.i = i;
		this.j = j;
	}
}
