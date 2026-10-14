package princeton.cs.algs4.week3.Bai2;

public class Solution {
    public static boolean solve(String s){
        Stack stack = new Stack(s.length());

        for (int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);

            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            else{
                if (stack.isEmpty()){
                    return false;
                }

                char open = stack.pop();

                if (c == ')' && open != '(') return false;
                if (c == '}' && open != '{') return false;
                if (c == ']' && open != '[') return false;


            }
        }
        
        return stack.isEmpty();
    }
    
}
 