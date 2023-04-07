public class Numeral extends Expression{
    private final int value;
    public Numeral (int value)
    {
        this.value = value;
    }
    @Override
    public int evaluate()
    {
        return value;
    }
    @Override
    public String toString()
    {
        return String.valueOf(value);
    }
}
