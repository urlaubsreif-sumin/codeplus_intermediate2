package geo4;
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
			
			int res1 = ccw(a[0], a[1], b[0]) * ccw(a[0], a[1], b[1]);
			int res2 = ccw(b[0], b[1], a[0]) * ccw(b[0], b[1], a[1]);
			
			if(res1 <= 0 && res2 <= 0) {
				if(res1 == 0 && res2 == 0) {
					if(a[0].compareTo(a[1]) == 1) {
						int tx = a[0].x;
						int ty = a[0].y;
						a[0] = new Point(a[1].x, a[1].y);
						a[1] = new Point(tx, ty);
					}
					if(b[0].compareTo(b[1]) == 1) {
						int tx = b[0].x;
						int ty = b[0].y;
						b[0] = new Point(b[1].x, b[1].y);
						b[1] = new Point(tx, ty);
					}
					if(b[0].compareTo(a[1]) != 1 && a[0].compareTo(b[1]) != 1) {
						System.out.println(1);
						return;
					}
					else {
						System.out.println(0);
						return;
					}
				}
				System.out.println(1);
				return;
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

class Point implements Comparable<Point> {
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Point that) {
		if(this.x > that.x) return 1;
		else if(this.x < that.x) return -1;
		else {
			if(this.y > that.y) return 1;
			else if(this.y < that.y) return -1;
		}
		return 0;
	}
	
}

