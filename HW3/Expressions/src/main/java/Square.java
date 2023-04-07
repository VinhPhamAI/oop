
public class Square extends Expression {
    private final Expression expression;
    public Square (Expression expression)
    {
        this.expression = expression;
    }
    @Override
    public int evaluate ()
    {
        int val = expression.evaluate();
        return val*val;
    }
    @Override
    public String toString()
    {
        return expression.toString() + "^2";
    }

}
