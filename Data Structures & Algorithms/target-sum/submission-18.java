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
            //ways++;
            return ways + 1;
        } else if (current - evalSum(nums) == target) {
            //ways++;
            return ways + 1;
        } else {
            if (nums.length <= 1) return 0;

            int n = nums[0];
            if (n != 0){
                arr = Arrays.copyOfRange(nums, 1, nums.length);
                if( arr == null || arr.length == 0) return ways;

                ways += findWaysRec(current + n, Arrays.copyOfRange(nums, 1, nums.length), target);
                ways += findWaysRec(current - n, Arrays.copyOfRange(nums, 1, nums.length), target);
                return ways;
            } else {
                //ways += 2;
                arr = Arrays.copyOfRange(nums, 1, nums.length);
                if( arr == null || arr.length == 0) return ways;
                
                ways += findWaysRec(current, Arrays.copyOfRange(nums, 2, nums.length), target);
                ways += findWaysRec(current, Arrays.copyOfRange(nums, 2, nums.length), target);

                return ways;
            }            
        }
        //return ways;
    }

    public int findTargetSumWays(int[] nums, int target) {
        /*int otherOption = evalSum(nums) - target;
        if (otherOption < target) target = otherOption;*/

        int sumNums = evalSum(nums);
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

        if(sumNums < target) return 0;
        if(target == 0 && nums.length == nZeros) return (int)Math.pow(2, nZeros);
        return findWaysRec(0, numsWithoutZeroes, target) * (int)Math.pow(2, nZeros);
    }
}
