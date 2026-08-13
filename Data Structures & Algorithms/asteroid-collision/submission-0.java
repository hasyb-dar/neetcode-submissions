class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {

            boolean destroyed = false;

            while (!stack.isEmpty() && stack.peek() > 0 && a < 0) {

                int top = stack.peek();

                if (top < -a) {
                    // Stack asteroid is smaller, so it explodes
                    stack.pop();
                }
                else if (top == -a) {
                    // Both asteroids explode
                    stack.pop();
                    destroyed = true;
                    break;
                }
                else {
                    // Current asteroid is smaller, so it explodes
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(a);
            }
        }

        int[] result = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}