package BaekJoon.no10816_숫자카드2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		HashMap<String, Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			String temp = st.nextToken();
			map.put(temp, map.getOrDefault(temp, 0) + 1);
		}

		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			String temp = st.nextToken();
			sb.append(map.getOrDefault(temp, 0) + " ");
		}

		System.out.print(sb);
		br.close();
	}
}
