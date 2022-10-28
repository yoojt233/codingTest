package BaekJoon.no25757_임스와함께하는미니게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < N; ++i)
			set.add(br.readLine());

		System.out.print(set.size() / play(st.nextToken()));
		br.close();
	}

	private static int play(String game) {
		switch (game) {
		case "Y":
			return 1;
		case "F":
			return 2;
		default:
			return 3;
		}
	}
}
