package SWEA.no2383_점심식사시간;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	static int N, min, cnt; // 한 변의 길이, 모두 계단을 내려가는 최소시간, 사람 수
	static boolean[] selected; // 부분 집합의 구현에서 사용할 선택 배열(선택되면 계단 1, 안되면 계단 2)
	static ArrayList<person> pList; // 사람 리스트
	static int[][] sList; // 계단 리스트

	static final int M = 1, W = 2, D = 3, C = 4; // Move Wait Down Complete

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st;

			pList = new ArrayList<person>();
			sList = new int[2][];
			min = Integer.MAX_VALUE;

			for (int i = 0, k = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++) {
					int c = Integer.parseInt(st.nextToken());
					if (c == 1) // 사람이면
						pList.add(new person(i, j));
					else if (c > 1)
						sList[k++] = new int[] { i, j, c };
				}
			}

			cnt = pList.size();
			selected = new boolean[cnt];
			divide(0);
			sb.append("#" + t + " " + min + "\n");
		}

		System.out.print(sb.toString());
		br.close();

	}

	private static void divide(int index) {
		if (index == cnt) {
			makeList();
			return;
		}

		// 부분 지합에 포함 : 계단 1에 배정
		selected[index] = true;
		divide(index + 1);

		// 부분집합에 비포함 : 계단 2에 배정
		selected[index] = false;
		divide(index + 1);
	}

	private static void makeList() {
		ArrayList<person> aList = new ArrayList<>();
		ArrayList<person> bList = new ArrayList<>();

		for (int i = 0; i < cnt; i++) {
			person p = pList.get(i);
			p.init();
			if (selected[i]) {
				p.time = Math.abs(p.r - sList[0][0]) + Math.abs(p.c - sList[0][1]);
				aList.add(p);
			} else {
				p.time = Math.abs(p.r - sList[1][0]) + Math.abs(p.c - sList[1][1]);
				bList.add(p);
			}
		}

		int res = go(aList, bList); // 두 계단리스트의 사람들이 모두 내려가는데 소요되는 시간
		if (min > res)
			min = res;
	}

	private static int go(ArrayList<person> aList, ArrayList<person> bList) {

		int timeA = 0, timeB = 0;

		if (aList.size() > 0)
			timeA = goDown(aList, sList[0][2]);

		if (bList.size() > 0)
			timeB = goDown(bList, sList[1][2]);

		return timeA > timeB ? timeA : timeB;
	}

	private static int goDown(ArrayList<person> list, int height) {
		Collections.sort(list); // 계단 입구까지 도착하는데 소요되는 시간을 빠른 순으로 정렬

		int time = list.get(0).time; // 첫 번째 사람의 계단입구 도착 시간부터 처리
		int size = list.size();
		int ingCnt = 0, cCnt = 0; // 내려가고 있는 사람 수, 다 내려간 사람 수
		while (true) {

			// 매 시간마다 사람들을 하나씩 꺼내 상태를 처리
			for (int i = 0; i < size; i++) {
				person p = list.get(i);

				if (p.status == C)
					continue;

				if (p.time == time) {
					p.status = W;
				} else if (p.status == W && ingCnt < 3) {
					p.status = D;
					p.downCnt = 1; // 계단 수 1부터 출발
					ingCnt++; // 내려가고 있는 사람 수 증가
				} else if (p.status == D) {
					if (p.downCnt < height)
						p.downCnt++;
					else {
						p.status = C;
						cCnt++;
						ingCnt--;
					}
				}
			}

			if (cCnt == size)
				break;

			time++;
		}

		return time;
	}

	static class person implements Comparable<person> {

		// 행 위치, 열 위치, 내려가고 있는 계단 수, 현상태, 입구까지 도착 시간
		int r, c, downCnt, status, time;

		public person(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public void init() {
			time = downCnt = 0;
			status = M;
		}

		@Override
		public int compareTo(person o) {
			return this.time - o.time; // 입구까지 소요되는 시간 오름차순 정렬
		}
	}
}
