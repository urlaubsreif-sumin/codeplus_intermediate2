package string8;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static ArrayList<Node> trie = new ArrayList<>();
	static int init() {
		Node n = new Node();
		trie.add(n);
		return trie.size() - 1;
	}
	static void add(int node, String s, int idx, int str_idx) {
		if(idx == s.length()) {
			trie.get(node).valid = str_idx;
			return;
		}
		int ch = s.charAt(idx) - 'a';
		if(trie.get(node).children[ch] == -1) {
			int next = init();
			trie.get(node).children[ch] = next;
		}
		int child = trie.get(node).children[ch];
		add(child, s, idx + 1, str_idx);
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int root = init();
			int N = Integer.parseInt(br.readLine());
			String[] arr = new String[N];
			for(int i = 0; i < N; i++) {
				arr[i] = br.readLine();
				add(root, arr[i], 0, i);
			}
			Queue<Integer> queue = new LinkedList<>();
			trie.get(root).pi = root;
			queue.add(root);
			while(!queue.isEmpty()) {
				int cur = queue.remove();
				for(int i = 0; i < 26; i++) {
					int next = trie.get(cur).children[i];
					if(next == -1) continue;
					if(cur == root) {
						trie.get(next).pi = root;
					}
					else {
						int x = trie.get(cur).pi;
						while(x != root && trie.get(x).children[i] == -1) {
							x = trie.get(x).pi;
						}
						if(trie.get(x).children[i] != -1) {
							x = trie.get(x).children[i];
						}
						trie.get(next).pi = x;
					}
					int pi = trie.get(next).pi;
					trie.get(next).indexes = new ArrayList<>(trie.get(pi).indexes);
					if(trie.get(next).valid != -1) {
						trie.get(next).indexes.add(trie.get(next).valid);
					}
					queue.add(next);
				}
				
				
				
			}
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

}

class Node {
	int[] children;
	int valid;
	int pi;
	ArrayList<Integer> indexes;
	Node() {
		children = new int[26];
		Arrays.fill(children, -1);
		valid = -1;
		pi = -1;
		indexes = new ArrayList<>();
	}
}