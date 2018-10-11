class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
           int distance = Math.abs(target[0]) + Math.abs(target[1]);
        for (int i = 0; i < ghosts.length; i++) {
            if (Math.abs(ghosts[i][0] - target[0]) + Math.abs(ghosts[i][1] - target[1]) <= distance)
                return false;
        }
            return true;
    }
}
