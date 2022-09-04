package BaekJoon.no1681_줄세우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		String L = st.nextToken();

		int cnt = 1;
		for (int i = 0; i < N; i++) {
			if (String.valueOf(cnt++).contains(L))
				i -= 1;
		}
		System.out.print(cnt - 1);
		br.close();
	}
}
