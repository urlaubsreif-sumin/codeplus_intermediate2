package math6;
import java.io.*;

public class Main {
	static int[][] arr;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			long n = Long.parseLong(br.readLine()) - 1;
			
			arr = new int[2][2];
			arr[0][0] = arr[0][1] = arr[1][0] = 1;
			
			int[][] res = go(n);
			int ans = res[0][0] % 1000000007;
			System.out.println(ans);
				
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int[][] go(long n) {
		if(n == 0) {
			int[][] tmp = new int[2][2];
			tmp[0][0] = tmp[1][1] = 1;
			return tmp;
		}
		else if(n == 1) {
			return arr;
		}
		else {
			if(n % 2 == 0) {
				int[][] temp = go(n / 2);
				return mult(temp, temp);
			}
			else {
				return mult(arr, go(n - 1));
			}
		}
	}
	
	public static int[][] mult (int[][] first, int[][] second){
		int[][] temp = new int[first.length][first[0].length];
		for(int i = 0; i < first.length; i++) {
			for(int j = 0; j < first[0].length; j++) {
				for(int k = 0; k < first[0].length; k++) {
					temp[i][j] = (int)(temp[i][j] + ((long)first[i][k] * (long)second[k][j] % 1000000007L) % 1000000007L);
				}
			}
		}
		return temp;
	}

}
