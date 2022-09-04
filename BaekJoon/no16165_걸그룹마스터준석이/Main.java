package BaekJoon.no16165_걸그룹마스터준석이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// Key : 그룹, Value : 멤버
		HashMap<String, String[]> group = new HashMap<>();

		// Key : 멤버, Value : 그룹
		HashMap<String, String> belong = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			int max = Integer.parseInt(br.readLine());

			// 멤버를 배열로 저장
			String[] member = new String[max];
			for (int j = 0; j < max; j++) {
				member[j] = br.readLine();
				belong.put(member[j], name); // 멤버 별 그룹 HashMap
			}

			Arrays.sort(member); // 정렬
			group.put(name, member); // 그룹 별 멤버 HashMap
		}

		for (int i = 0; i < M; i++) {
			String target = br.readLine(); // 0 : 그룹 1 : 멤버
			int sep = Integer.parseInt(br.readLine()); // 0 or 1

			if (sep == 0) {
				for (String s : group.get(target))
					sb.append(s).append("\n");
			} else {
				sb.append(belong.get(target)).append("\n");
			}
		}

		System.out.print(sb.toString());
		br.close();
	}
}
