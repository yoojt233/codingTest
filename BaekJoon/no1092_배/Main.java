package BaekJoon.no1092_배;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static boolean flag = true;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		ArrayList<Integer> crane = new ArrayList<>();
		ArrayList<Integer> box = new ArrayList<>();

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
			crane.add(Integer.parseInt(st.nextToken()));

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; ++i)
			box.add(Integer.parseInt(st.nextToken()));

		Collections.sort(crane, Collections.reverseOrder());
		Collections.sort(box, Collections.reverseOrder());
		if (crane.get(0) < box.get(0)) {
			flag = false;
			System.out.print(-1);
		}

		if (flag) {
			int ans = 0;
			while (!box.isEmpty()) {
				int idx = 0;
				for (int i = 0; i < N;) {
					if (idx == box.size())
						break;

					if (crane.get(i) >= box.get(idx)) {
						box.remove(idx);
						++i;
					} else
						++idx;
				}
				++ans;
			}
			System.out.print(ans);
		}

		br.close();
	}
}
