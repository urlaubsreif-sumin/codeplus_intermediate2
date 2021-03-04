package bf2;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			int min = 0;
			for(int c = 0; c <= (2 * Math.max(X, Y)); c += 2) {
				//반반치킨이 지나치게 저렴해서 더 많이 사는게 이득인 경우 생각하기
				int a = Math.max(0, X - (c / 2));//음수를 곱하지 않도록 더 많이 산 경우 0으로 바꿔준다
				int b = Math.max(0, Y - (c / 2));
				
				int price = (C * c + B * b + A * a);
				if(min == 0 || price < min) {
					min = price;
				}
			}
			
			System.out.println(min);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
