public class minPath {
    public static int minTotal(int[][] triangle, int i, int j) {
		if(i == triangle.length-1) {
			return triangle[i][j];
		}
		int down = triangle[i][j] + minTotal(triangle, i+1, j);
		int diagonal = triangle[i][j] + minTotal(triangle, i+1, j+1);
		return Math.min(down, diagonal);
	}

    public static int minTotalMemo(int[][] triangle, int[][] dp, int i, int j) {
		if(i == triangle.length-1) {
			return dp[i][j] = triangle[i][j];
		}
		if(dp[i][j] != -1) {
			return dp[i][j];
		}
		int down = triangle[i][j] + minTotalMemo(triangle, dp, i+1, j);
		int diagonal = triangle[i][j] + minTotalMemo(triangle, dp, i+1, j+1);
		return dp[i][j] = Math.min(down, diagonal);
	}

    public static int minTotalTabulation(int[][] triangle) {
		int n = triangle.length;
		int[][] dp = new int[n][n];
		for(int i = 0; i < n; i++) {
			dp[n-1][i] = triangle[n-1][i];
		}
		
		for(int i = n-2; i >= 0; i--) {
			for(int k = i; k >= 0; k--) {
				int down = triangle[i][k] + dp[i+1][k];
				int diagonal = triangle[i][k] + dp[i+1][k+1];
				dp[i][k] = Math.min(down, diagonal);
			}
		}
		return dp[0][0];
	}

    public static int minTotalSpaceOpt(int[][] triangle) {
        int n = triangle.length;
        int[] front = new int[n];
        for(int i = 0; i < n; i++) {
            front[i] = triangle[n-1][i];
        }
        
        for(int i = n-2; i >= 0; i--) {
            int[] curr = new int[n];
            for(int k = i; k >= 0; k--) {
                int down = triangle[i][k] + front[k];
                int diagonal = triangle[i][k] + front[k+1];
                curr[k] = Math.min(down, diagonal);
            }
            front = curr;
        }
        return front[0];
    }

    public static void main(String[] args) {
        int[][] triangle = {
            {2},
            {3,4},
            {6,5,7},
            {4,1,8,3}
        };
        int n = triangle.length;
        System.out.println(minTotal(triangle, 0, 0));

        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(minTotalMemo(triangle, dp, 0, 0));
        System.out.println(minTotalTabulation(triangle));
        System.out.println(minTotalSpaceOpt(triangle));
    }

}
