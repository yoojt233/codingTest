package BaekJoon.no3077_임진왜란;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		HashMap<String, Integer> input = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
			input.put(st.nextToken(), i);

		st = new StringTokenizer(br.readLine());
		int[] response = new int[N];
		for (int i = 0; i < N; ++i)
			response[i] = input.get(st.nextToken());

		int ans = 0;
		for (int i = 0; i < N - 1; ++i) {
			int front = response[i];
			for (int j = i + 1; j < N; ++j) {
				if (front < response[j])
					++ans;
			}
		}

		System.out.printf("%d/%d", ans, N * (N - 1) / 2);
		br.close();
	}
}
