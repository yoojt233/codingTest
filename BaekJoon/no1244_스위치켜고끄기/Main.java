package BaekJoon.no1244_스위치켜고끄기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] swtch;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		swtch = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++)
			swtch[i] = Integer.parseInt(st.nextToken());

		int person = Integer.parseInt(br.readLine());

		for (int i = 0; i < person; i++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "1":
				boy(st.nextToken());
				break;

			case "2":
				girl(st.nextToken());
				break;
			}
		}

		for (int i = 1; i <= N; i++) {
			if (i > 20 && i % 20 == 1)
				sb.append("\n");
			sb.append(swtch[i]).append(" ");
		}
		System.out.print(sb.toString().trim());
		br.close();
	}

	private static void girl(String num) {
		int n = Integer.parseInt(num);
		int start = n, end = n;
		for (int i = 1; n - i >= 1 && n + i <= N; i++) {
			if (swtch[n - i] != swtch[n + i]) {
				start = n - i + 1;
				end = n + i - 1;
				break;
			} else {
				start = n - i;
				end = n + i;
			}
		}
		for (int i = start; i <= end; i++) {
			if (swtch[i] == 1)
				swtch[i] = 0;
			else
				swtch[i] = 1;
		}
	}

	private static void boy(String num) {
		int n = Integer.parseInt(num);
		int i = 1, temp = 0;
		while ((temp = n * i++) <= N) {
			if (swtch[temp] == 1)
				swtch[temp] = 0;
			else
				swtch[temp] = 1;
		}
	}
}
