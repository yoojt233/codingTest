package BaekJoon.no1620_나는야포켓몬마스터이다솜;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 포켓몬 개체 수
		int M = Integer.parseInt(st.nextToken()); // 내가 검색할 수

		HashMap<String, Integer> poket = new HashMap<>();
		HashMap<Integer, String> monster = new HashMap<>();
		int idx = 1;

		// 도감 등록
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			poket.put(str, idx);
			monster.put(idx++, str);
		}

		// 도감 검색
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (isString(str))
				sb.append(poket.get(str)).append("\n");
			else
				sb.append(monster.get(Integer.parseInt(str))).append("\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static boolean isString(String str) {
		try {
			Integer.parseInt(str);
			return false;
		} catch (Exception e) {

			// NumberFormatException 발생 시 String이다.
			return true;
		}
	}
}
