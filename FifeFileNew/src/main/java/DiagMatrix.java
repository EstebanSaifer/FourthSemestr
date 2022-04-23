public class DiagMatrix extends Matrix{
    public DiagMatrix (int N) {
        super(N);
    }
    public DiagMatrix () {
        super(0);
    }
    public DiagMatrix (double[] arr, int N) throws MatrixExceptionNew{
        super(N);
        for(int i = 0; i < arr.length; i++) {
            for ( int j = 0;j < arr.length; j++) {
                elem(i, i + N * j);
            }
        }
    }
}
