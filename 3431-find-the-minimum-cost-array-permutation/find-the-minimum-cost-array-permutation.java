class Solution {
    int[][] dp;
    int[][] path;
    public int[] findPermutation(int[] nums) {
        int n = nums.length;
        dp = new int[14][1 << 14];
        path = new int[14][1 << 14];
        
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }

        System.out.println(solve(0, 1, nums));

        int[] result = new int[n];
        int prv = 0, mask = 0;
        for (int j = 0; j < n; j++) {
            int p = path[prv][mask];
            result[j] = p;
            prv = p;
            mask |= (1 << prv);
        }

        return result;
    }

    public int solve(int prev, int mask, int[] nums){
        if(Integer.bitCount(mask) == nums.length){
            return 0;
        }

        if(dp[prev][mask] != -1){
            return dp[prev][mask];
        }

        int from = path[prev][mask];

        int ans = (int)1e9;
        for(int i = 1; i < nums.length; i++){
            // this bit already taken, ignore it
            if(((1 << i) & mask) > 0) continue;

            int val = Math.abs(prev - nums[i]);
            if((Integer.bitCount(mask | (1 << i) )) == nums.length){
                val += Math.abs(i - nums[0]);
            }

            val += solve(i, mask | (1 << i), nums);

            if(val < ans){
                ans = val;
                from = i;
            }
        }

        dp[prev][mask] = ans;
        path[prev][mask] = from;

        return ans;
    }
}