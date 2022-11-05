package Programmers.신고결과받기;

import java.util.HashMap;
import java.util.HashSet;

class Solution {
	public int[] solution(String[] id_list, String[] report, int k) {

		// Key : 신고받은 유저, Value : 신고한 유저
		HashMap<String, HashSet<String>> from = new HashMap<>();

		// Key : 신고한 유저, Value : 받은 메일
		HashMap<String, Integer> cnt = new HashMap<>();

		// init
		for (String s : id_list) {
			from.put(s, new HashSet<String>());
			cnt.put(s, 0);
		}

		// report
		for (String s : report) {
			String[] input = s.split(" ");

			HashSet<String> temp = from.get(input[1]);
			temp.add(input[0]);
			from.put(input[1], temp);
		}

		// check
		for (int i = 0; i < id_list.length; ++i) {
			HashSet<String> temp = from.get(id_list[i]);
			if (temp.size() >= k) {

				// 정지당한 유저를 신고한 유저들이 받게 되는 메일 수 +1
				for (String s : temp)
					cnt.put(s, cnt.get(s) + 1);
			}
		}

		// answer
		int[] ans = new int[id_list.length];
		for (int i = 0; i < id_list.length; ++i)
			ans[i] = cnt.get(id_list[i]);

		return ans;
	}
}