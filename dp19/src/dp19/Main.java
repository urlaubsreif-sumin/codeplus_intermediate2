package dp19;
import java.io.*;
import java.util.ArrayList;

public class Main {
	static int N;
	static int[][] d;
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine());
			char[] road = br.readLine().toCharArray();
			d = new int[N][3];
			
			arr = (ArrayList[]) new ArrayList[3];
			
			for(int i = 0; i < 3; i++) {
				arr[i] = new ArrayList<Integer>();
			}
			
			for(int i = 0; i < road.length; i++) {
				if(road[i] == 'B') {
					arr[0].add(i);
				}
				else if(road[i] == 'O') {
					arr[1].add(i);
				}
				else {
					arr[2].add(i);
				}
			}
			
			int res = go(0, 0);
			
			System.out.println(res);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static int go(int i, int j) {
		//System.out.println(i + " " + j);
		if(i == N - 1) {
			return 0;
		}
		if(d[i][j] != 0)
			return d[i][j];
		int min = -1;
		for(int next : arr[(j + 1) % 3]) {
			if(next > i) {
				int res = go(next, (j + 1) % 3);
				if(res == -1) {
					continue;
				}
				if(min == -1 || (res != -1 && min > res + (next - i) * (next - i))) {
					min = res + (next - i) * (next - i);
				}
			}
		}
		if(min == -1) {
			d[i][j] = -1;
			return -1;
		}
		else {
			d[i][j] = min;
			return d[i][j];
		}
	}
}
