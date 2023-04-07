public class Addition extends BinaryExpression {
    private Expression left;
    private Expression right;
    public Addition (Expression left, Expression right)
    {
        super(left, right);
    }
    @Override
    public int evaluate()
    {
        return getLeft().evaluate() + getRight().evaluate();
    }
    @Override
    public String toString ()
    {
        return "(" + getLeft().toString() + " + " + getRight().toString() + ")";
    }
}
