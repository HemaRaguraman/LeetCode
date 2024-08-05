class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0; // Pointer for the next position to place a non-val element
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i; // i is the length of the array without the val elements
    }
}