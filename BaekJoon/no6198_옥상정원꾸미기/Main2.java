package BaekJoon.no6198_옥상정원꾸미기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 빌딩 수
		int[] building = new int[N];
		for (int i = 0; i < N; i++)
			building[i] = Integer.parseInt(br.readLine());

		long total = 0;
		for (int i = 0; i < N - 1; i++) {
			int cnt = 0;
			int idx = i + 1;
			while (idx < N && building[idx++] < building[i])
				cnt++;
			total += cnt;
		}

		System.out.println(total);
		br.close();
	}
}
