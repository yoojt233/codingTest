package BaekJoon.no14425_문자열집합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ans = 0;

		HashSet<String> set = new HashSet<String>(N);
		for (int i = 0; i < N; i++)
			set.add(br.readLine());

		for (int i = 0; i < M; i++) {
			if (set.contains(br.readLine()))
				ans++;
		}

		System.out.print(ans);
		br.close();
	}
}
