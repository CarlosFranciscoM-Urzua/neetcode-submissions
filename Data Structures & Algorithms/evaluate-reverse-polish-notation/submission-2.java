class Solution {
    public int evalRPN(String[] tokens) {
        char[] operators = new char[]{'+', '-', '*', '/'};
        Stack<Integer> evalStack = new Stack<>();
        evalStack.push(0);
        int result = 0, a = 0, b = 0;

        boolean isOperator;

        for(String token : tokens){
            isOperator = false;
            for(char o : operators){
                if(token.length() == 1 && o == token.charAt(0)){
                    isOperator = true;
                    break;
                }
            }

            if(isOperator){
                b = evalStack.pop();
                a = evalStack.pop();
                result = 0;

                switch(token.charAt(0)){
                    case '+': result = a + b; break;
                    case '-': result = a - b; break;
                    case '*': result = a * b; break;
                    case '/': result = a / b; break;
                }

                evalStack.push(result);
            } else {
                int n = Integer.parseInt(token);
                evalStack.push(n);
            }
        }

        return evalStack.pop();
    }
}
