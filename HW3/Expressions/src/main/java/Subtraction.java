public class Subtraction implements Expression{
    private Expression left;
    private Expression right;
    public Subtraction(Expression left, Expression right)
    {
        this.left = left;
        this.right = right;
    }
    @Override
    public int evaluate()
    {
        return left.evaluate() - right.evaluate();
    }
    @Override
    public String toString()
    {
        return "(" + left.toString() + " - " + left.toString() + ")";
    }
}
