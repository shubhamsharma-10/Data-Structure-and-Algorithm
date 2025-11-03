public class uniquePath {
     public static int uniquePathRecursion(int m, int n) {       // using recursion
		if(m < 0 || n < 0) {
			return 0;
		}
		
		if(m == 0 && n == 0) {
			return 1;
		}
		
		int up = uniquePathRecursion(m-1, n);
		int left = uniquePathRecursion(m, n-1);
		return up + left;
	}

    public static int uniquePathMemoization(int m, int n, int[][] dp) {  // using recursion + memoization
		if(m < 0 || n < 0) {
			return 0;
		}
		
		if(dp[m][n] != -1) {
			return dp[m][n];
		}
		if(m == 0 && n == 0) {
			return 1;
		}
		
		int up = uniquePathMemoization(m-1, n, dp);
		int left = uniquePathMemoization(m, n-1, dp);
		return dp[m][n] = up + left;
	}

    public static int uniquePathTabulation (int m, int n) {  // using tabulation
		if(m <= 0 || n <= 0) {
			return 0;
		}
		int[][] dp = new int[m][n];
		
		for(int i = 0; i < m; i++) {
			for(int k = 0; k < n; k++) {
				
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

    public static int uniquePathSpaceOptimized (int m, int n) {    //
		if(m <= 0 || n <= 0) {
			return 0;
		}
		int[] dp = new int[n];
		
		for(int i = 0; i < m; i++) {
			int[] curr = new int[n]; 
			for(int k = 0; k < n; k++) {
				
				if(i == 0 && k == 0) {
					curr[k] = 1;
					continue;
				}
				int up = dp[k];

				int left = 0;
				if(k > 0) {
					left = curr[k-1];
				}
				curr[k] = up + left;
			}
			dp = curr;
		}
		
		return dp[n-1];
	}

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        System.out.println(uniquePathRecursion(m-1, n-1));

        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(uniquePathMemoization(m-1, n-1, dp));
        System.out.println(uniquePathTabulation(m, n));
        System.out.println(uniquePathSpaceOptimized(m, n));
    }
}
