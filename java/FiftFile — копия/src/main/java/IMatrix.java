public interface IMatrix {

    double getElem(int x, int y) throws MatrixException;

    void changeElem(int x, int y, double newElem) throws MatrixException;

    double determination () ;
}