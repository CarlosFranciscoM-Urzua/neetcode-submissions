class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> triplets;
        set<vector<int>> set_triplets;
        //vector<int> v;

        /*set<int> set_nums;
        for (int n : nums){
            set_nums.insert(n);
        }

        nums.assign(set_nums.begin(), set_nums.end());*/

        for(int i = 0; i < nums.size()-2; i++){
            for(int j = i + 1; j < nums.size() - 1; j++){
                int target = 0 - nums[i] - nums[j];
                if(std::find(nums.begin() + j + 1, nums.end(), target) != nums.end()) {
                    //set_triplets.insert(vector<int>{});
                    vector<int> v{nums[i], nums[j], target};
                    sort(v.begin(), v.end());
                    set_triplets.insert(v);
                    
                }
            }
        }

        triplets.assign(set_triplets.begin(), set_triplets.end());
        return triplets;
    }
};
