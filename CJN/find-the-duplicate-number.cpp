class Solution {
public:
   int findDuplicate(vector<int>& nums) {
        int temp = 0;
        for(auto it = nums.begin();it!=nums.end();it++){
             temp = *it;
            for(auto mit = it+1;mit!=nums.end();mit++){
                if (temp == *mit) return temp;
            }
        }
        return 0;
    }
};
