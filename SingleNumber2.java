class Solution {
    public int[] singleNumber(int[] nums) {
        int bitmask = 0;

        for(int n : nums){
            bitmask ^= n;
        }

        //find LSB
        int lsb = bitmask & (-bitmask); //"-" gives 2's complement
        int bitmask2 = 0;
        for(int n : nums){
            if( (lsb & n) != 0){ // lsb will be coming from only one number
                bitmask2 = bitmask2 ^ n;
            }
        }

        return new int[] { bitmask2 , bitmask ^ bitmask2};
    }
}