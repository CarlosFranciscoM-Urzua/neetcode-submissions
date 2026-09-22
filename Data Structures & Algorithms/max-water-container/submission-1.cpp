class Solution {
public:
    int maxArea(vector<int>& heights) {
        int maxArea = 0, area = 0;
        /*for (int i = 0; i < heights.size() - 1; i++){
            for (int j = i + 1; j < heights.size(); j++){
                area = (j - i) * min(heights[i], heights[j]);
                maxArea = max(maxArea, area);
            }
        }*/

        int i = 0, j = heights.size() - 1;
        while( i < j){
            area = (j - i) * min(heights[i], heights[j]);
            maxArea = max(maxArea, area);

            if(heights[i] < heights[j]){
                i++;
            } else {
                j--;
            }
        }

        return maxArea;
    }

};
