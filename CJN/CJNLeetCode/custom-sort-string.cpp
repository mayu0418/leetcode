class Solution {
public:
    string customSortString(string S, string T) {
            sort(T.begin(), T.end(),[S](char a,char b){ return S.find(a)<S.find(b);});
            return T;
    }
};
