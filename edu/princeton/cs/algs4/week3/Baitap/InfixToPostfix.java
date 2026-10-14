package princeton.cs.algs4.week3.Baitap;

import java.util.Stack;

public class InfixToPostfix {
    static int precedence(char op){
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    static String convert(String infix){
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++){
            char c = infix.charAt(i);

            if (Character.isLetterOrDigit(c)){
                postfix.append(c);
            }

            if (Character.isWhitespace(c)) continue;

            if (c == '('){
                stack.push(c);
            }

            if (c == ')'){
                while (stack.peek() != '('){
                    postfix.append(stack.pop());
                }
                stack.pop();
            }

            if (c == '+' || c == '-' || c == '*' || c == '/'){
                while (stack.peek() != '(' && precedence(stack.peek()) >= precedence(c)){
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()){
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }
}
