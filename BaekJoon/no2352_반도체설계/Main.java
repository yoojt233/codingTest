package BaekJoon.no2352_반도체설계;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<Integer> port = new ArrayList<>(); // LIS 저장

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken()); // 현재 연결할 포트

			// 첫 번째 값은 무조건 삽입
			if (port.isEmpty())
				port.add(cur);
			else {

				// port의 마지막 값보다 현재 값이 더 크다면 삽입
				if (port.get(port.size() - 1) < cur)
					port.add(cur);

				// 아니라면 현재 값이 있어야할 위치에 값을 갱신
				else {
					int where = -Collections.binarySearch(port, cur) - 1;
					port.set(where, cur);
				}
			}
		}

		System.out.print(port.size());
		br.close();
	}
}
