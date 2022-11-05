package Programmers.두큐합같게만들기;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int[] queue1, int[] queue2) {
		long[] total = new long[2]; // 각 Queue에 있는 숫자들의 합

		Queue<Integer>[] q = new Queue[2];
		for (int i = 0; i < 2; ++i)
			q[i] = new LinkedList<>();

		// 배열 queue1의 값들을 Queue에 삽입
		for (int i : queue1) {
			total[0] += i;
			q[0].offer(i);
		}

		// 배열 queue2의 값들을 Queue에 삽입
		for (int i : queue2) {
			total[1] += i;
			q[1].offer(i);
		}

		// 모든 숫자들의 합이 홀수라면 애초에 불가능
		if ((total[0] + total[1]) % 2 != 0)
			return -1;

		int ans = 0;
		while (total[0] != total[1]) {

			// 최대 확인 횟수
			if (ans > queue1.length * 4)
				return -1;

			// 1번 큐의 총합이 더 크다면 queue1 -> queue2
			// 2번 큐의 총합이 더 크다면 queue2 -> queue1
			if (total[0] > total[1]) {
				int temp = q[0].poll();
				q[1].offer(temp);
				total[1] += temp;
				total[0] -= temp;
			} else {
				int temp = q[1].poll();
				q[0].offer(temp);
				total[0] += temp;
				total[1] -= temp;
			}

			// 이동 횟수 증가
			++ans;
		}

		return ans;
	}
}