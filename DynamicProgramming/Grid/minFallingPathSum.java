public class minFallingPathSum {
    public static int minFallingPathSum(int [][]matrix, int i, int k) {     // using recursion
		if(i < 0 || k < 0 || k >= matrix[i].length) {
			return Integer.MAX_VALUE;
		}
		if(i == 0) {
			return matrix[i][k];
		}
		
		int up = minFallingPathSum(matrix, i-1, k);
		int leftDiagnol = minFallingPathSum(matrix, i-1, k-1);
		int rightDiagnol = minFallingPathSum(matrix, i-1, k+1);
		return matrix[i][k] + Math.min(up, Math.min(leftDiagnol, rightDiagnol));
	}

    public static int minFallingPathSumMemo(int [][]matrix, int[][] dp, int i, int k) {    // using recursion + memoization
		if(i < 0 || k < 0 || k >= matrix[i].length) {
			return Integer.MAX_VALUE;
		}
		
		if(dp[i][k] != -1) {
			return dp[i][k];
		}
		
		if(i == 0) {
			return matrix[i][k];
		}
		
		int up = minFallingPathSumMemo(matrix, dp, i-1, k);
		int leftDiagnol = minFallingPathSumMemo(matrix, dp, i-1, k-1);
		int rightDiagnol = minFallingPathSumMemo(matrix, dp, i-1, k+1);
		return dp[i][k] = matrix[i][k] + Math.min(up, Math.min(leftDiagnol, rightDiagnol));
	}

    public static int minFallingPathSumTabulation(int [][]matrix) {     // tabulation
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        
        for(int k = 0; k < m; k++) {
            dp[0][k] = matrix[0][k];
        }
        
        for(int i = 1; i < n; i++) {
            for(int k = 0; k < m; k++) {
                int up = dp[i-1][k];
                int leftDiagnol = Integer.MAX_VALUE;
                if(k-1 >= 0) {
                    leftDiagnol = dp[i-1][k-1];
                }
                int rightDiagnol = Integer.MAX_VALUE;
                if(k+1 < m) {
                    rightDiagnol = dp[i-1][k+1];
                }
                dp[i][k] = matrix[i][k] + Math.min(up, Math.min(leftDiagnol, rightDiagnol));
            }
        }
        
        int minPathSum = Integer.MAX_VALUE;
        for(int k = 0; k < m; k++) {
            minPathSum = Math.min(minPathSum, dp[n-1][k]);
        }
        return minPathSum;
    }

    public static int minFallingPathSumSpaceOpt(int [][]matrix) {    //  space optimization
        int n = matrix.length;
        int m = matrix[0].length;
        int[] front = new int[m];
        
        for(int k = 0; k < m; k++) {
            front[k] = matrix[0][k];
        }
        
        for(int i = 1; i < n; i++) {
            int[] curr = new int[m];
            for(int k = 0; k < m; k++) {
                int up = front[k];
                int leftDiagnol = Integer.MAX_VALUE;
                if(k-1 >= 0) {
                    leftDiagnol = front[k-1];
                }
                int rightDiagnol = Integer.MAX_VALUE;
                if(k+1 < m) {
                    rightDiagnol = front[k+1];
                }
                curr[k] = matrix[i][k] + Math.min(up, Math.min(leftDiagnol, rightDiagnol));
            }
            front = curr;
        }
        
        int minPathSum = Integer.MAX_VALUE;
        for(int k = 0; k < m; k++) {
            minPathSum = Math.min(minPathSum, front[k]);
        }
        return minPathSum;
    }

    public static void main(String[] args) {
        int [][] matrix = {									// Ans: 6
					{1, 2, 10, 4}, 
					{100, 3, 2, 1}, 
					{1, 1, 20, 2}, 
					{1, 2, 2, 1}
				};
		int[][] matrix = {									// Ans: -1
					{1, 4, 3, 1}, 
					{2, 3, -1, -1}, 
					{1, 1, -1, 8}
				};
		int [][] matrix = {									// Ans: 7			
					{4, 3, 4}, 
					{4, 5, 1}, 
					{4, 6, 2}, 
					{4, 1, 4}
				};

        int n = matrix.length;
		int a = matrix[0].length;
		int min = Integer.MAX_VALUE;
		int[][] dp = new int[n][a];
        for(int i = 0; i < n; i++){
            for(int k = 0; k < a; k++){
                dp[i][k] = -1;
            }
        }

		for(int k = 0; k < matrix[0].length; k++) {
			min = Math.min(min, minFallingPathSum(matrix, n-1, k));
			min = Math.min(min,  minFallingPathSumMemo(matrix, dp, n-1, k));
			System.out.println(min);
		}

        System.out.println(minFallingPathSumTabulation(matrix));
        System.out.println(minFallingPathSumSpaceOpt(matrix));
    }
}
