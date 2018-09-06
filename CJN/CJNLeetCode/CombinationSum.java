class Solution {
     public  List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length < 1)
            return res;
        Arrays.sort(candidates);

        backtrack(candidates, target, res, new ArrayList<Integer>(), 0);

        return res;
    }

    private  void backtrack(int[] candidates, int target, List<List<Integer>> result, ArrayList<Integer> preC, int start) {
        if (target == 0) {
            result.add(preC);
            return;
        }
        for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
            preC.add(candidates[i]);
            backtrack(candidates, target - candidates[i], result, new ArrayList<Integer>(preC), i);
            preC.remove(preC.size() - 1);
        }
    }
}
