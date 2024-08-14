package string;

//Link:https://leetcode.com/problems/valid-parentheses/description/
//TimeComplexity:O(n)
//Type:Easy
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false; // Mismatched or unbalanced parentheses
            }
        }
        
        return stack.isEmpty(); // Valid if stack is empty
    }
}
