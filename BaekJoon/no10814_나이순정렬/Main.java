package BaekJoon.no10814_나이순정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		person[] people = new person[N];
		String[] input;
		for (int i = 0; i < N; ++i) {
			input = br.readLine().split(" ");
			people[i] = new person(input[0], input[1]);
		}

		Arrays.sort(people);
		for (person p : people)
			sb.append(p.toString() + "\n");
		
		System.out.print(sb);
		br.close();
	}
}

class person implements Comparable<person> {
	int age;
	String name;

	public person(String age, String name) {
		this.age = Integer.parseInt(age);
		this.name = name;
	}

	@Override
	public int compareTo(person o) {
		return this.age - o.age;
	}

	@Override
	public String toString() {
		return age + " " + name;
	}
}