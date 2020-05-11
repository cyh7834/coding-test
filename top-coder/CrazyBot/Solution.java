public class Solution {
	boolean[][] movingTable = new boolean[100][100];
	int[] movingCol = new int[]{1, -1, 0, 0};
	int[] movingRow = new int[]{0, 0, 1, -1};
	double[] eachRate = new double[4];
	
	public double solution(int n, int east, int west, int south, int north) {
		eachRate[0] = (double) east/100;
		eachRate[1] = (double) west/100;
		eachRate[2] = (double) south/100;
		eachRate[3] = (double) north/100;
		
		double result = dfs(50, 50, n);
        return result;
    }
	
	public double dfs(int currentRow, int currentCol, int n) {
		// 이미 방문했던 지역이라면 재귀를 벗어난다.
		if (movingTable[currentRow][currentCol])
			return 0;
		// 더이상 움직일 수 없다면 재귀를 벗어난다.
		else if (n < 1)
			return 1;
		
		double rate = 0.0;
		movingTable[currentRow][currentCol] = true;
		
		// 동, 서, 남, 북 별로 재귀를 수행한다.
		for (int i = 0; i < 4; i++) {
			if (eachRate[i] != 0.0)
				rate += dfs(currentRow + movingRow[i], currentCol + movingCol[i], n - 1) * eachRate[i];
		}
		movingTable[currentRow][currentCol] = false;

		return rate;
	}
}
