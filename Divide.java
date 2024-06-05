//TC :  O(log n)
//Approach: keep multiplying by 2 (shifting the bits to left ) to find how many shifts required to reach dividend.

class Solution {
    public int divide(int dividend, int divisor) {
        //edge cases
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(divisor == 0) return Integer.MAX_VALUE;

        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        int result = 0;

        while( ldividend >= ldivisor){
            int shifts = 0;

            while(ldividend >= (ldivisor << shifts)){
                shifts++;
            }

            shifts--; // we surpassed the dividend so we need to go one step back
            result += 1 << shifts; // required multiplication by 2 steps 

            ldividend = ldividend - (ldivisor << shifts); // repeat for remainder of dividend.
        }

        if(dividend > 0 && divisor > 0 ) return result;
        if(dividend < 0 && divisor < 0 ) return result;
        return -result;
    }
}