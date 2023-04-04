import java.util.ArrayDeque;

public class Brackets {

        public static boolean isValid(String s) {
            ArrayDeque<Character> stack = new ArrayDeque<Character>();
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
            return stack.isEmpty();
        }


    public static void main(String[]args){
        System.out.println(isValid("( ( [ [ ] ] ) )"));

    }

}
