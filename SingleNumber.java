class Solution {
    public int singleNumber(int[] nums) {
        int bitmask = 0;

        for(int n : nums){
            bitmask ^= n;
        }

        return bitmask;
    }
}