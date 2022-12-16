package BaekJoon.no2217_로프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Integer> rope = new ArrayList<>(N);
		for (int i = 0; i < N; ++i)
			rope.add(Integer.parseInt(br.readLine()));

		Collections.sort(rope);
		int ans = Integer.MIN_VALUE;
		for (int i : rope)
			ans = Math.max(ans, i * N--);

		System.out.print(ans);
		br.close();
	}
}
