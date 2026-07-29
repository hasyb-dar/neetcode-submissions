/* class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {

            int l = i + 1;     // fix
            int r = n - 1;     // fix

            while (l < r) {

                int sum = nums[i] + nums[l] + nums[r];

                if (sum == 0) {

                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);

                    result.add(list);

                    l++;
                    r--;

                } 
                else if (sum < 0) {
                    l++;
                } 
                else {
                    r--;
                }
            }
        }

        // remove duplicates (your approach kept)
        Set<List<Integer>> set = new HashSet<>(result);
        result = new ArrayList<>(set);

        return result;
    }
} */


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {

            // skip duplicate i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1;
            int r = n - 1;

            while (l < r) {

                int sum = nums[i] + nums[l] + nums[r];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    l++;
                    r--;

                    // skip duplicates for l
                    while (l < r && nums[l] == nums[l - 1]) l++;

                    // skip duplicates for r
                    while (l < r && nums[r] == nums[r + 1]) r--;
                }
                else if (sum < 0) {
                    l++;
                } 
                else {
                    r--;
                }
            }
        }

        return result;
    }
}
