package week2;

public class Maze {
	//문제 : M x N maze에서 경로상 숫자들을 합할 때 최대값 구하기
	//규칙 :오른쪽 혹은 아래로만 이동 가능
	
	static int count = 0;

	public int max(int[][] d, int i, int j) {
		count++;
		int n = d.length;
		int[][] r = new int[n][n];
		r[0][0] = d[0][0];
		for (int k = 1; k < n; k++) {
			r[0][k] = d[0][k] + r[0][k - 1];
		}
		for (int k = 1; k < n; k++) {
			r[0][k] = d[0][k] + r[k - 1][0];
		}
		for (int k = 1; k < n; k++) {
			for (int l = 1; l < n; l++) {
				r[k][l] = d[k][l] + Math.max(r[k - 1][l], r[k][l - 1]);
			}
		}
		return r[i][j];

	}

	public int max2(int[][] d, int i, int j) {
		count++;
		if (i == 0 && j == 0) {
			return d[i][j];
		} else if (i == 0) {
			return d[i][j] + max2(d, i, j - 1);
		} else if (j == 0) {
			return d[i][j] + max2(d, i - 1, j);
		} else
			return d[i][j] + Math.max(max2(d, i - 1, j), max(d, i, j - 1));

	}

	public static void main(String[] args) {
		int[][] data = { { 1, 2, 3, 4, 5, 6, 7 }, { 1, 2, 3, 4, 5, 6, 7 }, { 1, 2, 3, 4, 5, 6, 7 },
				{ 1, 2, 3, 4, 5, 6, 7 }, { 1, 2, 3, 4, 5, 6, 7 }, { 1, 2, 3, 4, 5, 6, 7 }, { 1, 2, 3, 4, 5, 6, 7 } };
		
		Maze m = new Maze();
		int i = 6;
		int j = 6;
		System.out.println(m.max(data, i , j));
		System.out.println("최댓값:" + m.max2(data, i , j) + "count:" + count);
		
	}
}
