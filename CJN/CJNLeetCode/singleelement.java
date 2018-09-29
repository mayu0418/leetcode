class Solution {
    public int singleNonDuplicate(int[] nums) {
            for(int i = 0; i < nums.length; i+=2){
        if(nums[i] != nums[i+1])
            return nums[i];
        if(nums[nums.length-1-i] != nums[nums.length-2-i])
            return nums[nums.length-1-i];
    }
    
    return nums[0];
}
    }
