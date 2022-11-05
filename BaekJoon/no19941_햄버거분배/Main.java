package BaekJoon.no19941_햄버거분배;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		String input = br.readLine();
		HashSet<Integer> hamburger = new HashSet<>();
		ArrayList<Integer> person = new ArrayList<>();

		for (int i = 0; i < N; ++i) {
			char c = input.charAt(i);
			if (c == 'H')
				hamburger.add(i);
			else
				person.add(i);
		}

		int ans = 0;
		boolean[] ate = new boolean[N];
		for (int p : person) {
			for (int i = p - K; i <= p + K; ++i) {
				if (i < 0 || i >= N)
					continue;
				
				if (!ate[i] && hamburger.contains(i)) {
					ate[i] = true;
					++ans;
					break;
				}
			}
		}

		System.out.print(ans);
		br.close();
	}
}
