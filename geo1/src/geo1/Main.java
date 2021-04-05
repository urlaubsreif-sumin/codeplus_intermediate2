package geo1;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		try {
			int[][] points = new int[3][2];
			for(int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine());
				points[i][0] = Integer.parseInt(st.nextToken());
				points[i][1] = Integer.parseInt(st.nextToken());
			}
			
			System.out.println(ccw(points));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public static int ccw(int[][] points) {
		int ans = points[0][0] * points[1][1] + points[1][0] * points[2][1] + points[2][0] * points[0][1];
		ans = ans - (points[0][0] * points[2][1] + points[2][0] * points[1][1] + points[1][0] * points[0][1]);
		if(ans > 0) {
			return 1;
		}
		else if(ans == 0) {
			return 0;
		}
		else {
			return -1;
		}
	}

}
