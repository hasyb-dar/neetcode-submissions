
class Solution {
    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        int num = 0;
        String curr = "";

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            else if (ch == '[') {
                countStack.push(num);
                stringStack.push(curr);

                num = 0;
                curr = "";
            }

            else if (ch == ']') {
                int count = countStack.pop();
                String previous = stringStack.pop();

                String temp = "";

                for (int j = 0; j < count; j++) {
                    temp += curr;
                }

                curr = previous + temp;
            }

            else {
                curr += ch;
            }
        }

        return curr;
    }
}