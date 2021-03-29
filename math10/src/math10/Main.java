package math10;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static long min, max;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long min = Long.parseLong(st.nextToken());
			long max = Long.parseLong(st.nextToken());
			boolean[] arr = new boolean[(int) (max - min + 1)];
			int cnt = arr.length;
			for(long i = 2; i * i <= max; i++) {
				long p = (i * i - (min % (i * i))) % (i * i);
				for(long j = p; j <= (max - min); j += (i * i)) {
					if(arr[(int)j]) {
						continue;
					}
					arr[(int)j] = true;
					cnt--;
				}
			}
			
			System.out.println(cnt);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
