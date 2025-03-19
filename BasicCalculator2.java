import java.util.Stack;

/*
TC-O(N)  SC-O(N)
* */
public class BasicCalculator2 {
    public int calculate(String s) {
        int num=0;
        char operation = '+';
        Stack<Integer> stk=new Stack<>();

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                num=10*num+(c-'0');

            }
            if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == s.length() - 1){
                if (operation == '+') {
                    stk.push(num);
                } else if (operation == '-') {
                    stk.push(-num);
                } else if (operation == '*') {
                    stk.push(stk.pop() * num);
                } else if (operation == '/') {
                    stk.push(stk.pop() / num);
                }
                operation=c;
                num=0;
            }
        }
        int result=0;
        while(!stk.isEmpty()){
            result=result+stk.pop();
        }
        return result;
    }
}
