package BaekJoon.no2751_수정렬하기2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		boolean[] visited = new boolean[2000001];
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; ++i)
			visited[Integer.parseInt(br.readLine()) + 1000000] = true;

		for (int i = 0; i < 2000001; ++i) {
			if (visited[i])
				sb.append(i - 1000000).append("\n");
		}

		System.out.print(sb);
		br.close();
	}
}
