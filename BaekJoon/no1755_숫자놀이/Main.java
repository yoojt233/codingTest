package BaekJoon.no1755_숫자놀이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] first = { 8, 5, 4, 9, 1, 7, 6, 3, 2, 0 }; // 사전 순으로 정렬했을 때의 순서
		int[] num = new int[99]; // 1 ~ 99 까지 사전 순으로 넣을 것

		int idx = 0;

		// 십의 자리를 정하고
		for (int i = 0; i < 9; i++) {
			num[idx++] = first[i]; // 한 자리 수가 최우선

			// 일의 자리를 정한다
			for (int j = 0; j < 10; j++) {
				int x = first[i] * 10 + first[j];
				num[idx++] = x;
			}
		}

		int start = Integer.parseInt(st.nextToken()); // 시작 숫자
		int end = Integer.parseInt(st.nextToken()); // 마지막 숫자
		List<Integer> sel = new ArrayList<>();

		// start 부터 end 까지 몇 번째 인덱스에 있는지 list에 담아준다.
		for (int i = start; i <= end; i++) {
			for (int j = 0; j < 99; j++) {
				if (num[j] == i) {
					sel.add(j);
					break;
				}
			}
		}

		// list를 정렬하면 사전 순
		Collections.sort(sel);

		int k = 0;
		for (int i : sel) {
			sb.append(num[i] + " ");
			k++;

			// 10개 마다 줄 바꿈
			if (k == 10) {
				sb.append("\n");
				k = 0;
			}
		}

		System.out.print(sb.toString());
		br.close();
	}
}