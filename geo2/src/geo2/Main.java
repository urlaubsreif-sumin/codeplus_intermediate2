package geo2;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static Point[] arr;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		try {
			int N = Integer.parseInt(br.readLine());
			arr = new Point[N + 1];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			arr[N] = new Point(arr[0].x, arr[0].y);
			
			long area = 0;
			for(int i = 0; i < N; i++) {
				area += ((long)arr[i].x * (long)arr[i + 1].y);
				area -= ((long)arr[i + 1].x * (long)arr[i].y);
			}
			
			area = Math.abs(area);
			System.out.print(area / 2L + ".");
			if(area % 2 == 0) {
				System.out.println("0");
			}
			else {
				System.out.println("5");
			}
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}

class Point {
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}