package bf23;
import java.io.*;
import java.util.StringTokenizer;
public class Main {
	static Egg[] eggs;
	static int N;
	static int max = 0;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			N = Integer.parseInt(br.readLine());
			eggs = new Egg[N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			go(0, 0);
			
			System.out.println(max);
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void go(int n, int cnt) {
		if(n == N) {
			max = max > cnt ? max : cnt;
			return;
		}
		if(!eggs[n].state) {
			go(n + 1, cnt);
			return;
		}
		boolean nomore = true;
		for(int i = 0; i < N; i++) {
			if(!eggs[i].state || i == n)
				continue;
			else {
				nomore = false;
				int broken = 0;
				eggs[n].hit(eggs[i]);
				
				if(!eggs[n].state) {
					broken++;
				}
				if(!eggs[i].state) {
					broken++;
				}
				go(n + 1, cnt + broken);
				
				eggs[n].recover(eggs[i]);
			}
		}
		if(nomore)
			go(n + 1, cnt);
	}

}

class Egg {
	int w; //무게
	int s; //내구도
	boolean state = true;
	Egg(int s, int w){
		this.w = w;
		this.s = s;
	}
	public void hit(Egg that) {
		this.s -= that.w;
		that.s -= this.w;
		if(this.s <= 0) {
			state = false;
		}
		if(that.s <= 0) {
			that.state = false;
		}
	}
	public void recover(Egg that) {
		this.s += that.w;
		that.s += this.w;
		if(this.s > 0) {
			state = true;
		}
		if(that.s > 0) {
			that.state = true;
		}
	}
}