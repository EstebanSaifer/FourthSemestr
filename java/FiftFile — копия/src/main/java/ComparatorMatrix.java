public class ComparatorMatrix implements java.util.Comparator<Matrix> {


    @Override
    public int compare(Matrix o1, Matrix o2)
    {
        return (int) (o1.determination() - o2.determination());
    }

}
