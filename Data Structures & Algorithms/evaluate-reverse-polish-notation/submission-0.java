public class Solution {
    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
    public int evalRPN(String[] A) {
        Stack<Integer> st = new Stack<>();

        for (String s : A) {
            if (isOperator(s)) {
                int b = st.pop();
                int a = st.pop();
                int res = 0;

                switch (s) {
                    case "+":
                        res = a + b;
                        break;
                    case "-":
                        res = a - b;
                        break;
                    case "*":
                        res = a * b;
                        break;
                    case "/":
                        res = a / b;  // Integer division (truncate toward 0)
                        break;
                }
                st.push(res);
            } else {
                st.push(Integer.parseInt(s));
            }
        }

        return st.pop();

    }
}

