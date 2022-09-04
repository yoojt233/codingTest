package BaekJoon.no5430_AC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테케 수
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			Deque<Character> cmd = new ArrayDeque<Character>();
			String temp = br.readLine();
			boolean flag = true, reverse = true;

			// 명령어 삽입(R이 연속 두 번이면 그대로 진행이므로 앞의 R을 지우고 넘긴다.)
			for (int i = 0; i < temp.length(); i++) {
				char c = temp.charAt(i);
				if (cmd.isEmpty() || c == 'D')
					cmd.add(c);
				else if (cmd.getLast() != 'R')
					cmd.add(c);
				else
					cmd.removeLast();
			}

			int n = Integer.parseInt(br.readLine());
			temp = br.readLine();
			Deque<Integer> nums = new ArrayDeque<>();

			// 첫 "[" 마지막 "]" 제거 후 ","를 기준으로 split
			String[] num = temp.substring(1, temp.length() - 1).split(",");
			for (int i = 0; i < n; i++)
				nums.add(Integer.parseInt(num[i]));

			// 실행
			while (!cmd.isEmpty()) {
				char c = cmd.pop();
				if (c == 'R') // R이면 뽑는 방향 변경
					reverse = !reverse;
				else {
					if (nums.isEmpty()) { // 오류
						flag = false;
						break;
					} else {
						if (reverse) // 앞에서 제거
							nums.removeFirst();
						else // 뒤에서 제거
							nums.removeLast();
					}
				}
			}

			// 출력
			if (!flag)
				sb.append("error\n");
			else {
				sb.append("[");

				if (reverse) { // 앞에서 부터 출력
					for (int i : nums)
						sb.append(i + ",");
				} else { // 뒤에서 부터 출력
					List<Integer> list = new ArrayList<>();
					for (int i : nums)
						list.add(i);
					Collections.reverse(list);
					for (int i : list)
						sb.append(i + ",");
				}

				// 마지막이 ,로 끝나면 삭제
				if (sb.charAt(sb.length() - 1) == ',')
					sb.deleteCharAt(sb.length() - 1);

				sb.append("]\n");
			}
		}

		System.out.print(sb.toString());
		br.close();
	}
}
