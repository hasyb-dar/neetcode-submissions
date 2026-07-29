

class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates); 

        List<List<Integer>> result = new ArrayList<>();
        calc(result, new ArrayList<>(), candidates, target, 0);

        return result;
    }

    void calc(List<List<Integer>> result, List<Integer> temp,
              int[] arr, int target, int i) {

        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (i == arr.length || target < 0) {
            return;
        }

        temp.add(arr[i]);
        calc(result, temp, arr, target - arr[i], i + 1);
        temp.remove(temp.size() - 1);

   
        int next = i;
        while (next + 1 < arr.length && arr[next] == arr[next + 1]) {
            next++; 
        }

    
        calc(result, temp, arr, target, next + 1);
    }
}