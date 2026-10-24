class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> numsSet = new HashSet<>();

        for (int n : nums){
            if(numsSet.contains(n)) return true;
            numsSet.add(n);
        }

        return false;
    }
}