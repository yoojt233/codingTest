package BaekJoon.no1269_대칭차집합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// a에 기준값 삽입
		HashSet<Integer> a = new HashSet<Integer>();
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens())
			a.add(Integer.parseInt(st.nextToken()));

		// a에 원소가 이미 존재하면 필요없다.
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			int cur = Integer.parseInt(st.nextToken());
			if (a.contains(cur))
				a.remove(cur);
			else
				a.add(cur);
		}

		System.out.print(a.size());
		br.close();
	}
}
