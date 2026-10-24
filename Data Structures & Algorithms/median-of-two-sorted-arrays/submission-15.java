class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2 = nums2.length;

        //ANY OF THE ARRAYS IS EMPTY
        if(n1 == 0){
            if( n2 % 2 == 1) return nums2[n2 / 2];
            else return (nums2[(n2 - 1)/ 2] + nums2[(n2 + 1)/ 2])/2.0;
        } else if (n2 == 0){
            if( n1 % 2 == 1) return nums1[n1 / 2];
            else return (nums1[(n1 - 1)/ 2] + nums1[(n1 + 1)/ 2])/2.0;
        }

        if((n1 + n2)%2 == 1) {//MEDIAN IS A ELEMENT
            int i = 0;
            int j = 0;
            int targetSum = (n1 + n2)/2;
            while(i < n1 && j < n2){
                if(nums1[i] < nums2[j]) {
                    if (i + j == targetSum) return nums1[i];
                    i++;                    
                } else {
                    if (i + j == targetSum) return nums2[j];
                    j++;
                }
            }

            while (i < n1){
                if (i + j == targetSum) return nums1[i];
                i++;
            }

            while (j < n2){
                if (i + j == targetSum) return nums2[j];
                j++;
            }

        } else {//MEDIAN IS 2 ELEMENTS
            int i = 0;
            int j = 0;
            int targetSum = (n1 + n2)/2;
            double median = 0;
            while(i < n1 && j < n2){
                if(nums1[i] < nums2[j]) {                    
                    if (i + j == targetSum - 1) {
                        median = nums1[i];
                    } else if (i + j == targetSum - 0) {
                        return (median + nums1[i])/2.0;
                    } 
                    i++;
                } else {                    
                    if (i + j == targetSum - 1) {
                        median = nums2[j];
                    } else if (i + j == targetSum - 0) {
                        return (median + nums2[j])/2.0;
                    } 
                    j++;
                }
            }
            while( i < n1){
                if (i + j == targetSum - 1) {
                    median = nums1[i];
                } else if (i + j == targetSum - 0) {
                    return (median + nums1[i])/2.0;
                } 
                i++;
            }

            while(j < n2){
                if (i + j == targetSum - 1) {
                    median = nums2[j];
                } else if (i + j == targetSum - 0) {
                    return (median + nums2[j])/2.0;
                } 
                j++;
            }
        }

        

        /*double aprox = (nums1[0] + nums1[n1-1] + nums2[0] + nums2[n2-1])/4.0;
        double median = aprox;
        

        if((n1 + n2)%2 == 1) {//MEDIAN IS A ELEMENT
            int spaceFromLimits = (n1 + n2 - 1) / 2;

            int i1 = n1/2;
            int i2 = n2/2;

            int i1 = 0, i2 = 0;
            while(i1 < n1 - 1 && nums1[i1] < aprox) i1++;
            while(i2 < n2 - 1 && nums2[i2] < aprox) i2++;

            if (i1 + i2 == spaceFromLimits) {
                if(Math.abs(aprox - nums1[i1]) < Math.abs(aprox - nums2[i2])){
                    return nums1[i1];
                } else return nums2[i2];
            }

        } else {//MEDIAN IS 2 ELEMENTS
            int spaceFromLimits = (n1 + n2 - 2) / 2;

            int i1 = 0, i2 = 0;
            while(i1 < n1 - 1 && nums1[i1] < aprox) i1++;
            while(i2 < n2 - 1 && nums2[i2] < aprox) i2++;

            if (i1 + i2 == spaceFromLimits) return (nums1[i1] + nums2[i2])/2;

            //return (nums1[i1] + nums2[i2])/2;
        }*/

        double aprox = (nums1[0] + nums1[n1-1] + nums2[0] + nums2[n2-1])/4.0;
        return aprox;
    }
}
