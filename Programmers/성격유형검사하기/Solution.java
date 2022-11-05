package Programmers.성격유형검사하기;

import java.util.HashMap;

class Solution {
	static HashMap<Character, Integer> score;

	public String solution(String[] survey, int[] choices) {
		initScore();
		for (int i = 0; i < survey.length; ++i)
			plus(survey[i].charAt(0), survey[i].charAt(1), choices[i]);

		StringBuilder sb = new StringBuilder();
		sb.append(score.get('R') >= score.get('T') ? 'R' : 'T');
		sb.append(score.get('C') >= score.get('F') ? 'C' : 'F');
		sb.append(score.get('J') >= score.get('M') ? 'J' : 'M');
		sb.append(score.get('A') >= score.get('N') ? 'A' : 'N');

		return sb.toString();
	}

	private static void plus(char a, char b, int sel) {
		switch (sel) {
		case 1:
			score.put(a, score.get(a) + 3);
			break;
		case 2:
			score.put(a, score.get(a) + 2);
			break;
		case 3:
			score.put(a, score.get(a) + 1);
			break;
		case 4:
			break;
		case 5:
			score.put(b, score.get(b) + 1);
			break;
		case 6:
			score.put(b, score.get(b) + 2);
			break;
		case 7:
			score.put(b, score.get(b) + 3);
			break;
		}
	}

	private static void initScore() {
		score = new HashMap<>();
		score.put('R', 0);
		score.put('T', 0);
		score.put('C', 0);
		score.put('F', 0);
		score.put('J', 0);
		score.put('M', 0);
		score.put('A', 0);
		score.put('N', 0);
	}
}