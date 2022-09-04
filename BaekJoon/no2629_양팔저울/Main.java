package BaekJoon.no2629_양팔저울;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 추
		int std = Integer.parseInt(br.readLine());
		int[] weight = new int[std];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < std; i++)
			weight[i] = Integer.parseInt(st.nextToken());

		// 구슬
		int bead = Integer.parseInt(br.readLine());
		int[] beads = new int[bead];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < bead; i++)
			beads[i] = Integer.parseInt(st.nextToken());

		Set<Integer> possible = new HashSet<>();
		possible.add(0);

		for (int i = 0; i < std; i++) {
			int size = possible.size();
			int[] temp = new int[size];

			// set 안의 값을 배열로 저장
			int idx = 0;
			for (int k : possible)
				temp[idx++] = k;

			// 추를 하나씩 늘려가며 가능한 값을 set에 저장
			for (int j = 0; j < size; j++) {
				int num1 = temp[j] + weight[i];
				int num2 = Math.abs(temp[j] - weight[i]);

				possible.add(num1);
				possible.add(num2);
			}
		}

		// 구슬의 무게가 set에 있다면 측정 가능
		for (int i : beads) {
			if (possible.contains(i))
				sb.append("Y ");
			else
				sb.append("N ");
		}

		System.out.print(sb.toString());
		br.close();
	}
}