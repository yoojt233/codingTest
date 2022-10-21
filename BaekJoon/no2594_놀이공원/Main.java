package BaekJoon.no2594_놀이공원;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		ArrayList<timer> arr = new ArrayList<>();
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int op = stit(st.nextToken()) - 10;
			int ed = stit(st.nextToken()) + 10;
			arr.add(new timer(op, ed));
		}

		Collections.sort(arr);

		int ans = 0;
		int ed = 600;
		for (timer t : arr) {
			if (ed < t.op) {
				ans = Math.max(ans, t.op - ed);
				ed = t.ed;
			} else
				ed = Math.max(ed, t.ed);
		}
		ans = Math.max(ans, 1320 - ed);

		System.out.print(ans);
		br.close();
	}

	private static int stit(String str) {
		String hour = str.substring(0, 2);
		String minute = str.substring(2, 4);
		return Integer.parseInt(hour) * 60 + Integer.parseInt(minute);
	}
}

class timer implements Comparable<timer> {
	int op, ed;

	public timer(int op, int ed) {
		this.op = op;
		this.ed = ed;
	}

	public int compareTo(timer o) {
		return this.op - o.op;
	}
}