class Solution {
    public int arrangeCoins(int n) {
        long val=n *2L;
        long sqr = (long)Math.sqrt(val);
        return ((sqr*sqr+sqr)<=val)?(int)sqr:(int)(sqr-1);
    }
}