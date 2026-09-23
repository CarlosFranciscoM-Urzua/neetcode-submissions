class Solution {
public:
    int search(vector<int>& nums, int target) {
        if (nums.empty()) return -1; // Caso de vector vacío

        int i1 = nums.size() / 2;
        int inf = 0;
        int sup = nums.size() - 1;

        /*do{
            if (nums[i1] > target){ //TARGET ESTA EN LA MITAD SUPERIOR
                sup = i1 - 1;
                i1 = inf + (sup - inf) / 2;

                //if(sup == i1) i1--;
            }
            else if(nums[i1] < target) { //TARGET ESTA EN LA MITAD INFERIOR
                inf = i1 + 1;
                i1 = inf + (sup - inf) / 2;
                //if(inf == i1) i1++;
            } 
            else if (nums[i1]  == target) return i1;
            else if (nums[inf] == target) return inf;
            else if (nums[sup] == target) return sup;

            if(inf > sup) return -1;
        } while(nums[i1] != target && inf <= sup);*/

        while (inf <= sup) {
            // Se calcula así para evitar desbordamientos en arreglos inmensos
            int mid = inf + (sup - inf) / 2; 

            if (nums[mid] == target) {
                return mid; // ¡Encontrado!
            } 
            else if (nums[mid] < target) {
                inf = mid + 1; // Buscar en la mitad superior
            } 
            else {
                sup = mid - 1; // Buscar en la mitad inferior
            }
        }

        return -1;        
    }
};
