public class uniquePathII {
    public static int uniquePathRecursion(int[][] obstacleGrid, int m, int n) {
		if(m < 0 || n < 0) {
			return 0;
		}
		if(obstacleGrid[m][n] == 1) {
			return 0;
		}
		if(m == 0 && n == 0) {
			return 1;
		}
		int up = uniquePathRecursion(obstacleGrid, m-1, n);
		int left = uniquePathRecursion(obstacleGrid, m, n-1);

		return up + left;
	}

    public static int uniquePath(int[][] obstacleGrid, int m, int n, int[][] dp) {
		if(m < 0 || n < 0) {
			return 0;
		}
		if(dp[m][n] != -1) {
			return dp[m][n];
		}
		if(obstacleGrid[m][n] == 1) {
			return 0;
		}
		if(m == 0 && n == 0) {
			return 1;
		}
		int up = uniquePath(obstacleGrid, m-1, n, dp);
		int left = uniquePath(obstacleGrid, m, n-1, dp);
		
		return dp[m][n] = up + left;		
	}

    public static int uniquePathTabulation(int[][] obstacleGrid, int m, int n) {
		int[][] dp = new int [m][n];
			for(int i = 0; i < m; i++) {
				for(int k = 0; k < n; k++) {
					
					if(obstacleGrid[i][k] == 1) {
						dp[i][k] = 0;
						continue;
					}
					if(i == 0 && k == 0) {
						dp[i][k] = 1;
						continue;
					}
					int up = 0;
					if(i > 0) {
						up = dp[i-1][k];
					}
					int left = 0;
					if(k > 0) {
						left = dp[i][k-1];
					}
					dp[i][k] = up + left;
			}
		}
		return dp[m-1][n-1];
	}

    
}
