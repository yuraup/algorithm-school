package week2;

public class Maze2 {
	//문제 : M x N maze에서 경로상 숫자들을 합할 때 최대값 구하기
	//규칙 :오른쪽 혹은 아래로만 이동 가능
	//연습 
	static int count = 0;

	int [][] data;
	
	public Maze2 (int[][] in){
		data = in;
	}
	
	public int findMax (int i, int j) {
		count ++;
		if (i == 0 && j == 0) {
			return data[i][j];
		}
		if (i == 0) {
			return data[i][j] + findMax(i, j-1);
		}
		if (j == 0) {
			return data[i][j] + findMax(i-1, j);
		}
		return data[i][j] + Math.max(findMax(i, j - 1), Math.max(findMax(i - 1, j), findMax(i - 1, j)));
	}
	
	public int getCount() {
		return count;
	}

	public static void main(String[] args) {
		int[][] data = { { 1, 2, 3, 4, 5, 6, 7 }, { 1, 2, 3, 4, 5, 6, 7 }, { 1, 2, 3, 4, 5, 6, 7 },
				{ 1, 2, 3, 4, 5, 6, 7 }, { 1, 2, 3, 4, 5, 6, 7 }, { 1, 2, 3, 4, 5, 6, 7 }, { 1, 2, 3, 4, 5, 6, 7 } };
	
		Maze2 maze = new Maze2(data);
		
		System.out.println("최댓값은:" + maze.findMax(data.length -1, data.length -1));
		System.out.println("count: " + maze.getCount());
	}
}
