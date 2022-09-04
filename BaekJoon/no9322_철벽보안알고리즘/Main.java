package BaekJoon.no9322_철벽보안알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			int N = Integer.parseInt(br.readLine());

			int idx = 0;

			// 문자열과 idx 번호를 함께 삽입
			HashMap<String, Integer> normal = new HashMap<>();
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens())
				normal.put(st.nextToken(), idx++);

			// 문자열이 몇번 째 idx에 존재하는지 찾아서 enc 배열에 idx 값을 저장
			int[] enc = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				enc[i] = normal.get(st.nextToken());

			// enc 배열에 있는 idx 값이 문자열이 있어야할 위치
			String[] ans = new String[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				ans[enc[i]] = st.nextToken();

			// ans 배열 값들을 하나씩 꺼내서 sb에 저장
			for (String s : ans)
				sb.append(s + " ");
			sb.append("\n");
		}

		System.out.print(sb.toString());
		br.close();
	}
}
