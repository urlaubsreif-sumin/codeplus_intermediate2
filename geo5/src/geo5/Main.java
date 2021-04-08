package geo5;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		try {
			int N = Integer.parseInt(br.readLine());
			Point[] geo = new Point[N + 1];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				geo[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			geo[N] = new Point(geo[0].x, geo[0].y);
			
			Point[] pos = new Point[3];
			for(int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine());
				pos[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			Point out = new Point(1, Integer.MAX_VALUE);
			
			for(int i = 0; i < 3; i++) {
				Line l1 = new Line(out, pos[i]);
				int cnt = 0;
				for(int j = 0; j < N; j++) {
					Line l2 = new Line(geo[j], geo[j + 1]);
					int res = l1.cross(l2);
					if(res == 1) {
						cnt++;
					}
					else if(res == 0) {
						cnt = 1;
						break;
					}
				}
				if(cnt % 2 == 0) {
					System.out.println(0);
				}
				else {
					System.out.println(1);
				}
			}
			
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
class Line {
	Point first, second;
	Line(Point a, Point b){
		if(a.compareTo(b) == 1) {
			second = a;
			first = b;
		}
		else {
			first = a;
			second = b;
		}
	}
	
	public int cross(Line l2) {
		int res = ccw(this.first, this.second, l2.first) * ccw(this.first, this.second, l2.second);
		int res2 = ccw(l2.first, l2.second, this.first) * ccw(l2.first, l2.second, this.second);
		if(res < 0 && res2 < 0) {
			return 1;
		}
		if(res2 == 0) {
			if(this.second.x >= l2.first.x && this.second.x <= l2.second.x
					&& this.second.y >= l2.first.y && this.second.y <= l2.second.y) {
				return 0;
			}
		}
		return -1;
	}
	
	public int ccw(Point a, Point b, Point c) {
		long ans = (long)a.x * (long)b.y + (long)b.x * (long)c.y + (long)c.x * (long)a.y;
		ans = ans - ((long)a.x * (long)c.y + (long)c.x * (long)b.y + (long)b.x * (long)a.y);
		if(ans < 0) return -1;
		else if(ans > 0) return 1;
		else return 0;
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