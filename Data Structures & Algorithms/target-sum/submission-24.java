class Solution {

    private int evalSum(int[] nums){
        int sum = 0;
        for (int n : nums) sum += n;
        return sum;
    }

    private int findWaysRec(int current, int[] nums, int target){
        int ways = 0;
        int[] arr;

        if (nums == null || nums.length == 0) return 0;
        if (current + evalSum(nums) == target) {
            return ways + 1;
        } else if (current - evalSum(nums) == target) {
            return ways + 1;
        } else {
            if (nums.length <= 1) return 0;

            int n = nums[0];
            arr = Arrays.copyOfRange(nums, 1, nums.length);
            if( arr == null || arr.length == 0) return ways;

            ways += findWaysRec(current + n, Arrays.copyOfRange(nums, 1, nums.length), target);
            ways += findWaysRec(current - n, Arrays.copyOfRange(nums, 1, nums.length), target);
            return ways;
            /*if (n != 0){
                arr = Arrays.copyOfRange(nums, 1, nums.length);
                if( arr == null || arr.length == 0) return ways;

                ways += findWaysRec(current + n, Arrays.copyOfRange(nums, 1, nums.length), target);
                ways += findWaysRec(current - n, Arrays.copyOfRange(nums, 1, nums.length), target);
                return ways;
            } else {
                arr = Arrays.copyOfRange(nums, 1, nums.length);
                if( arr == null || arr.length == 0) return ways;
                
                ways += findWaysRec(current, Arrays.copyOfRange(nums, 2, nums.length), target);
                ways += findWaysRec(current, Arrays.copyOfRange(nums, 2, nums.length), target);

                return ways;
            }  */          
        }
        //return ways;
    }

    private int combination(int n, int r) {
        if (r < 0 || r > n) return 0;
        if (r == 0 || r == n) return 1;
        
        // Optimización usando simetría
        if (r > n - r) {
            r = n - r;
        }

        int result = 1;
        for (int i = 1; i <= r; i++) {
            result *= (n - r + i);
            result /= i;
        }
        return result;
    }


    public int findTargetSumWays(int[] nums, int target) {
        int sumNums = evalSum(nums);
        if(sumNums < target) return 0;

        //DEAL WITH ZEROES
        int nZeros = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0)nZeros++;
        }
        
        int[] numsWithoutZeroes = new int[nums.length - nZeros];
        int last = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                numsWithoutZeroes[last] = nums[i];
                last++;
            }
        }

        if(target == 0 && nums.length == nZeros) return (int)Math.pow(2, nZeros);

        //ALL NON-ZERO NUMBERS ARE EQUAL
        boolean allEqual = true;
        for (int n : numsWithoutZeroes) {
            if(numsWithoutZeroes[0] != n){
                allEqual = false;
                break;
            }
        }

        /*if (allEqual){
            if(target == numsWithoutZeroes[0]){
                if (numsWithoutZeroes.length % 2 == 1) {
                    int aux = combination((numsWithoutZeroes.length - 1) / 2, numsWithoutZeroes.length);
                    return aux * (int)Math.pow(2, nZeros);
                }
                else return 0;
            }

            if(target == 0){
                if (numsWithoutZeroes.length % 2 == 1) return 0;
                else {
                    int aux = combination(numsWithoutZeroes.length / 2, numsWithoutZeroes.length);
                    return aux * (int)Math.pow(2, nZeros);
                }
            }
        }*/
        
        
        return findWaysRec(0, numsWithoutZeroes, target) * (int)Math.pow(2, nZeros);
    }
}
