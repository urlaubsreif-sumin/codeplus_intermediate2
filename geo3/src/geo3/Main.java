package geo3;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Point[] a = new Point[2];
		Point[] b = new Point[2];
		
		try {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 2; i++) {
				a[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 2; i++) {
				b[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			if(ccw(a[0], a[1], b[0]) * ccw(a[0], a[1], b[1]) < 0) {
				if(ccw(b[0], b[1], a[0]) * ccw(b[0], b[1], a[1]) < 0) {
					System.out.println(1);
					return;
				}
			}
			
			System.out.println(0);
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
	
	public static int ccw(Point a, Point b, Point c) {
		long ans = (long)a.x * (long)b.y + (long)b.x * (long)c.y + (long)c.x * (long)a.y;
		ans = ans - ((long)a.x * (long)c.y + (long)c.x * (long)b.y + (long)b.x * (long)a.y);
		if(ans < 0) {
			return -1;
		}
		else if(ans > 0) {
			return 1;
		}
		else {
			return 0;
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
