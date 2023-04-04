import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class UPNCalculator {
    Map<String, Stack<Double>> mapVars = new HashMap<String, Stack<Double>>();

    private double eval(String exprUPN) {
        Stack<Double> stack = new Stack<Double>();
        String[] tokens = exprUPN.split(" ");
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                double divisor = stack.pop();
                stack.push(stack.pop() / divisor);
            } else if (Character.isDigit(token.charAt(0))) {
                stack.push(Double.parseDouble(token));
            } else {
                if (!mapVars.containsKey(token)) {
                    System.err.println("Variable " + token + " not defined");
                    return Double.NaN;
                }
                stack.push(mapVars.get(token).peek());
            }
        }
        return stack.pop();
    }

    public String analyze(String expr) {
        String[] tokens = expr.split(" ");
        if (tokens.length == 3 && tokens[1].equals("=")) {
            double value = eval(tokens[2]);
            if (Double.isNaN(value)) {
                return "result: NaN";
            }
            mapVars.computeIfAbsent(tokens[0], k -> new Stack<Double>()).push(value);
            return "result: " + tokens[0] + "=" + value;
        } else {
            double value = eval(expr);
            if (Double.isNaN(value)) {
                return "result: NaN";
            }
            return "result: " + value;
        }
    }
}
