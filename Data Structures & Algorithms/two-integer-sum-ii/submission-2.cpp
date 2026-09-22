class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        //int index1, index2;
        vector<int> resp;

        /*
        for (int i = 0; i < numbers.size() - 1; i++){
            auto it = std::find(numbers.begin() + i + 1, numbers.end(), target -numbers[i]);
            if (it != numbers.end()){
                // Obtenemos el índice usando std::distance
                std::size_t aux = std::distance(numbers.begin(), it);
                int index2 = static_cast<int>(aux);

                resp.push_back(i + 1);
                resp.push_back(index2 + 1);
            }
        }
        */

        int left = 0, right = numbers.size() - 1, sum;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                resp.push_back(left + 1);
                resp.push_back(right + 1);
                return resp;
            }
        }


        return resp;
    }
};
