
public abstract class BinaryExpression extends Expression {
    private Expression left;
    private Expression right;
    public Expression getLeft()
    {
        return left;
    }
    public Expression getRight()
    {
        return right;
    }
    public BinaryExpression(Expression left, Expression right)
    {
        this.left = left;
        this.right = right;
    }

}

