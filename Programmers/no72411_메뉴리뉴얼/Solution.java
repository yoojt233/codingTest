package Programmers.no72411_메뉴리뉴얼;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class Solution {
	static HashMap<String, Integer> candidate;
	static int max;

	public String[] solution(String[] orders, int[] course) {
		ArrayList<String> answer = new ArrayList<>();

		for (int m : course) {
			candidate = new HashMap<String, Integer>();
			max = 0;

			for (String s : orders) {
				char[] temp = s.toCharArray();
				Arrays.sort(temp);
				combo(m, 0, new String(temp), "");
			}

			if (max > 1) {
				for (String s : candidate.keySet()) {
					if (candidate.get(s) == max)
						answer.add(s);
				}
			}
		}

		// 정답
		Collections.sort(answer);
		String[] ans = new String[answer.size()];
		for (int i = 0; i < answer.size(); ++i)
			ans[i] = answer.get(i);

		return ans;
	}

	private static void combo(int m, int start, String s, String cur) {
		if (m == cur.length()) {
			candidate.put(cur, candidate.getOrDefault(cur, 0) + 1);
			// if(candidate.containsKey(cur))
			// candidate.put(cur, candidate.get(cur) + 1);
			// else
			// candidate.put(cur, 1);

			max = Math.max(max, candidate.get(cur));
			return;
		}

		for (int i = start; i < s.length(); ++i)
			combo(m, i + 1, s, cur + s.charAt(i));
	}
}