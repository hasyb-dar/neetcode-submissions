class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();
        for(int i=0; i<n; i++){
            if(stack.isEmpty() || cars[i][1]>stack.peek()){
                stack.push(cars[i][1]);
            }
        }
        return stack.size();
    }
}
