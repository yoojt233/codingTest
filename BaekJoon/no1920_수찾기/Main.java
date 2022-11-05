package BaekJoon.no1920_수찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
			set.add(Integer.parseInt(st.nextToken()));

		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
			sb.append(set.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append("\n");

		System.out.print(sb);
		br.close();
	}
}
