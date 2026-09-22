#include<regex>

class Solution {
public:
    bool isPalindrome(string s) {
        // El patrón [^a-zA-Z0-9] coincide con cualquier carácter que NO sea una letra o un número
        std::regex patron("[^a-zA-Z0-9]");
    
        // Reemplaza los caracteres no alfanuméricos por una cadena vacía
        s = std::regex_replace(s, patron, "");

        int left = 0, right = s.length() - 1;
        while(left < right){
            if(tolower(s.at(left)) != tolower(s.at(right))) return false;
            left++;
            right--;
        }

        return true;

    }
};
