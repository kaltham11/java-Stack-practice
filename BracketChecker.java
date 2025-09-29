import java.util.Stack;

class BracketChecker {
    /**
     * TO-DO: Refactor this method to remove its dependency on the three helper methods
     * (isOpening, isClosing, isMatchingPair) by inlining their logic.
     */
        public static void main(String[] args) {
            BracketChecker checker = new BracketChecker();

            String expr1 = "({[]})";   // balanced
            String expr2 = "({[)]}";   // not balanced
            String expr3 = "(((())))"; // balanced
            String expr4 = "((())";    // not balanced
            System.out.println(expr1 + " -> " + checker.isBalancedRefactored(expr1)); // true
            System.out.println(expr2 + " -> " + checker.isBalancedRefactored(expr2)); // false
            System.out.println(expr3 + " -> " + checker.isBalancedRefactored(expr3)); // true
            System.out.println(expr4 + " -> " + checker.isBalancedRefactored(expr4)); // false
            System.out.println( " -> " + checker.isBalancedRefactored(")("));
        }
    public boolean isBalancedRefactored(String expr) {
        Stack<Character> stack = new Stack<>();
        for (char c : expr.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                // Your code here for handling opening brackets
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                // Your code here for handling closing brackets
                // It should check if the stack is empty and if the popped element matches.
                // If not, return false immediately.
                 if (stack.isEmpty()){
                     return false;
                 }
                    char data=stack.pop();
                    if(c == (')') && data!=('(') || c == ('}') && data!=('{')||c == (']') && data!=('[') ){
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }
}