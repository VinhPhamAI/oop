import java.util.ArrayList;

public class NumList {
    private SortAlgo sortAlgorithm;
    private ArrayList<Double> listOfNum = new ArrayList<Double>();
    public int add (double number)
    {
        listOfNum.add(number);
        return listOfNum.size();
    }
    public ArrayList<Double> getNumList()
    {
        return listOfNum;
    }
    public SortAlgo getSortAlgorithm()
    {
        return sortAlgorithm;
    }
    public void setSortAlgo(SortAlgo sortAlgorithm)
    {
        this.sortAlgorithm = sortAlgorithm;
    }
    public void setBubbleSort()
    {
        sortAlgorithm = new BubbleSort();
    }
    public void setQuickSort()
    {
        sortAlgorithm = new QuickSort();
    }
    public void setOrder()
    {
        if (listOfNum.size() < 100)
        {
            setBubbleSort();
            sortAlgorithm.sort(this);
        }
        else
        {
            setQuickSort();
            sortAlgorithm.sort(this);
        }
    }
}
