package SWEA.no1210_Ladder1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1210_Ladder {

	static int size = 100;
	static int[][] Arr = new int[size][size];

	static int row, col;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/1210.txt"));

		Scanner sc = new Scanner(System.in);

		for (int tc = 0; tc < 10; tc++) {
			int testc = sc.nextInt();

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					Arr[i][j] = sc.nextInt();
					if (Arr[i][j] == 2) {
						row = i;
						col = j;
					}
				}
			}

			while(row != 0) {
				if( col-1 >=0 && Arr[row][col-1] == 1) {
					do {
						--col;
					}while( col-1 >=0 &&  Arr[row][col-1] == 1);
				}

				else if( col+1 < size && Arr[row][col+1] == 1) {
					do {
					   ++col;
					}while(col+1 < size && Arr[row][col+1] == 1);
				}
				
				--row;
			}
			
			System.out.printf("#%d %d%n", testc,col);
		}
	}
}
