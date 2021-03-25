package math5;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			long n = Long.parseLong(br.readLine());
			long[] arr = new long[1500000];
			arr[0] = 0;
			arr[1] = 1;
			for(int i = 2; i < 1500000; i++) {
				arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000;
			}
			System.out.println(arr[(int) (n % 1500000)]);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
