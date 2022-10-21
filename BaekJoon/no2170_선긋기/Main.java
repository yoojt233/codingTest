package BaekJoon.no2170_선긋기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		ArrayList<line> lines = new ArrayList<>();
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			lines.add(new line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		Collections.sort(lines);
		int ans = 0;
		int l = Integer.MIN_VALUE;
		int r = Integer.MIN_VALUE;
		for (line cur : lines) {
			if (r < cur.left) {
				ans += (r - l);
				l = cur.left;
				r = cur.right;
			} else
				r = Math.max(r, cur.right);
		}
		ans += (r - l);

		System.out.print(ans);
		br.close();
	}
}

class line implements Comparable<line> {
	int left, right;

	public line(int left, int right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public int compareTo(line o) {
		if (this.left != o.left)
			return this.left - o.left;
		return this.right - o.right;
	}
}