package BaekJoon.no1034_램프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());

		// 램프들의 초기 상태
		String[] lamp = new String[row];

		// 초기 상태가 같은 행이 몇 개?
		HashMap<String, Integer> same = new HashMap<>();

		for (int i = 0; i < row; i++) {
			lamp[i] = br.readLine();
			if (same.containsKey(lamp[i])) // 이미 초기 상태가 같은 행이 존재
				same.put(lamp[i], same.get(lamp[i]) + 1);
			else // 처음 나오는 초기 상태
				same.put(lamp[i], 1);
		}

		// 시행 횟수
		int chance = Integer.parseInt(br.readLine());

		// 시행 횟수 안에 모두 램프를 킬 수 있는 행인지 판단
		List<String> possible = new ArrayList<>();
		for (int i = 0; i < row; i++) {
			int cnt = 0;
			for (int j = 0; j < col; j++) {
				if (lamp[i].charAt(j) == '0')
					cnt++;
			}

			// 꺼져 있는 램프의 갯수와 시행 횟수 비교
			if (cnt <= chance && (cnt % 2 == chance % 2))
				possible.add(lamp[i]);
		}

		// 가능한 행 중 초기 상태가 동일한 수가 많은 행을 선택
		int ans = 0;
		for (String s : possible) {
			int temp = same.get(s);
			ans = Math.max(ans, temp);
		}

		System.out.print(ans);
		br.close();
	}
}