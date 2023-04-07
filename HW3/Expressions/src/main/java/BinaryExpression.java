
public class BinaryExpression implements Expression {
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
    @Override
    public int evaluate(){
        return 0;
    };
    @Override
    public String toString(){
        return null;
    };

}

