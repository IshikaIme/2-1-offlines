public class Expression {

    public static int calculation(char op, int y, int x) {
        if (op == '+')
            return x + y;
        else if (op == '-')
            return x - y;
        else if (op == '*')
            return x * y;
        else if (op == '/')
            return x / y;

        return 0;
    }

    public static boolean hasprecedence(char a, char b) {
        if (b == '(' || b == ')')
            return false;
        if ((a == '*' || a == '/') && (b == '+' || b == '-'))
            return false;
        else
            return true;
    }

    public static int Expressionevaluate(String ex) throws Exception {
        char[] token = ex.toCharArray();
        Stack<Integer> operands = new Stack<Integer>();
        Stack<Character> operator = new Stack<Character>();

        int i;
        for (i = 0; i < token.length; i++) {
            if (token[i] >= '0' && token[i] <= '9') {

                StringBuffer numb = new StringBuffer();
                while (i < token.length &&
                        token[i] >= '0' &&
                        token[i] <= '9')
                    numb.append(token[i++]);

                operands.push(Integer.parseInt(numb.toString()));
                i--;
            } else if (token[i] == '(') {
                if((i>0)&&(token[i-1]>='0')&&(token[i-1]<='9'))
                {
                    throw new Exception("Invalid");
                }

                    operator.push(token[i]);
                if(token[i+1]=='-')
                    operands.push(0);
            }
            else if (token[i] == ')') {
                while (operator.peek() != '(')
                    operands.push(calculation(operator.pop(), operands.pop(), operands.pop()));
                operator.pop();
            } else if (token[i] == '+' || token[i] == '-' || token[i] == '*' || token[i] == '/') {
                while (!operator.isEmpty() && (hasprecedence(token[i], operator.peek())))
                    operands.push(calculation(operator.pop(), operands.pop(), operands.pop()));

                operator.push(token[i]);
            }

            else
                throw new Exception("Invalid");
        }

        while (!operator.isEmpty())
            operands.push(calculation(operator.pop(), operands.pop(), operands.pop()));

        return operands.pop();
    }

}



