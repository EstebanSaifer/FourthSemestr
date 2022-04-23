public interface IMatrix {

    double elem (int x, int y) throws MatrixExceptionNew;

    void changeElem(int x, int y, double newElem) throws MatrixExceptionNew;

    double determination ();
}
