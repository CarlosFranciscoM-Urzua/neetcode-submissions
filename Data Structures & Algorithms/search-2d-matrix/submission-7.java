class Solution {

    /*private boolean checkPosition(int[][] matrix, int pos, int target){
        int rows = matrix.length, columns = matrix[0].length;
        int i = (pos - 1) / rows;
        int j = pos - i * rows - 1;

        return matrix[i][j] == target;
    }*/
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, columns = matrix[0].length;

        if(target < matrix[0][0]) return false;
        else if (target > matrix[rows - 1][columns - 1]) return false;

        //CHECK COLUMN FIRST
        /*int min = 0;
        int max = rows - 1;
        int middle = 0;*/


        

        /*int min = 1, max =  rows * columns;
        int middle = 0;

        while(min <= max){
            middle = min + (max - min)/2;
            if(middle <= min) middle = min + 1;
            else if(middle >= max) middle = max - 1;

            if(matrix[(min - 1) / columns][(min - 1) % columns] == target){
                return true;
            } else if(matrix[(max - 1) / columns][(max - 1) % columns] == target){
                return true;
            } else if(matrix[(middle - 1) / columns][(middle - 1) % columns] == target){
                return true;
            }else if (matrix[(middle - 1) / columns][(middle - 1) % columns] > target){
                max = middle - 1;
            } else {
                min = middle + 1;
            }
        }*/

        int min = 1, max =  rows * columns;
        int middle = 0;

        do {
            middle = min + (max - min)/2;
            if(middle <= min) middle = min + 1;
            else if(middle >= max) middle = max - 1;

            if(matrix[(min - 1) / columns][(min - 1) % columns] == target){
                return true;
            } else if(matrix[(max - 1) / columns][(max - 1) % columns] == target){
                return true;
            } else if(matrix[(middle - 1) / columns][(middle - 1) % columns] == target){
                return true;
            }else if (matrix[(middle - 1) / columns][(middle - 1) % columns] > target){
                max = middle - 1;
            } else {
                min = middle + 1;
            }
        } while(min < max);

        return false;
    }
}
