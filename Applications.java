/**
 * Applications that use the stack and queue classes.
 */
public class Applications
{
    /**
     * Reverses the given queue.
     *
     * @param queue the queue to reverse
     * @param <E> the type of elements stored in the queue
     */
    public static <E> void reverse(MyQueueLL<E> queue)
    {
        MyStack<E> stack = new MyStack<E>(queue.size());
        while (queue.isEmpty() == false)
        {
            stack.push(queue.dequeue());
        }
        while (stack.isEmpty() == false)
        {
            queue.enqueue(stack.pop());
        }
    }

    /**
     * Checks the validity of {} [] () <> pairs in the given code.
     *
     * @param code the code to check
     * @return true if every pair is opened and closed in the right order, false otherwise
     */
    public static boolean checkSyntax(String code)
    {
        String openers = "{[(<";
        String closers = "}])>";
        // the stack can never hold more openers than there are characters
        MyStack<String> stack = new MyStack<String>(code.length());
        boolean valid = true;
        for (int i = 0; i < code.length() && valid; i++)
        {
            String symbol = code.substring(i, i + 1);
            if (openers.indexOf(symbol) != -1)
            {
                stack.push(symbol);
            }
            else if (closers.indexOf(symbol) != -1)
            {
                if (stack.isEmpty())
                {
                    valid = false;
                }
                else
                {
                    String opener = stack.pop();
                    // an opener and its closer sit at the same position in their strings
                    if (openers.indexOf(opener) != closers.indexOf(symbol))
                    {
                        valid = false;
                    }
                }
            }
        }
        return valid && stack.isEmpty();
    }

    /**
     * Evaluates a postfix expression for the operators + - * /.
     * Numbers and operators must be separated by spaces.
     *
     * @param expression the postfix expression, such as "3 4 + 2 *"
     * @return the value of the expression
     */
    public static double evalPostfix(String expression)
    {
        String digits = "0123456789";
        String[] tokens = expression.split(" ");
        // the stack can never hold more numbers than there are tokens
        MyStack<Double> stack = new MyStack<Double>(tokens.length);
        for (int i = 0; i < tokens.length; i++)
        {
            String token = tokens[i];
            if (token.length() > 0)
            {
                if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))
                {
                    // the second number comes off first
                    double right = stack.pop();
                    double left = stack.pop();
                    if (token.equals("+"))
                    {
                        stack.push(left + right);
                    }
                    else if (token.equals("-"))
                    {
                        stack.push(left - right);
                    }
                    else if (token.equals("*"))
                    {
                        stack.push(left * right);
                    }
                    else
                    {
                        stack.push(left / right);
                    }
                }
                else
                {
                    // build the number one digit at a time as if there were no point, then divide at the end
                    int start = 0;
                    if (token.substring(0, 1).equals("-"))
                    {
                        start = 1;
                    }
                    double value = 0;
                    double divisor = 1;
                    boolean afterPoint = false;
                    for (int j = start; j < token.length(); j++)
                    {
                        String symbol = token.substring(j, j + 1);
                        if (symbol.equals("."))
                        {
                            afterPoint = true;
                        }
                        else
                        {
                            value = value * 10 + digits.indexOf(symbol);
                            if (afterPoint)
                            {
                                divisor = divisor * 10;
                            }
                        }
                    }
                    value = value / divisor;
                    if (start == 1)
                    {
                        value = -value;
                    }
                    stack.push(value);
                }
            }
        }
        return stack.pop();
    }
}
