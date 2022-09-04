package BaekJoon.no9461_파도반수열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static List<Long> tr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		tr = new ArrayList<Long>();
		tr.add((long) 1);
		tr.add((long) 1);
		tr.add((long) 1);
		tr.add((long) 2);
		tr.add((long) 2);

		int tc = Integer.parseInt(br.readLine());

		// 얻고자 하는 n에 대한 값이 이미 있다면 list에서 찾아내면 되지만,
		// 없다면 list의 마지막 idx부터 n까지 add 해준다.
		for (int t = 0; t < tc; t++) {
			int n = Integer.parseInt(br.readLine());
			if (n > tr.size())
				p(n);

			// list의 idx를 0으로 시작했기 때문에 n-1 값을 구해야한다.
			sb.append(tr.get(n - 1)).append("\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static void p(int n) {
		for (int i = tr.size(); i < n; i++)
			tr.add(tr.get(i - 1) + tr.get(i - 5));
	}
}
