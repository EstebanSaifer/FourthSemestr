
public class UpTriangleMatrix extends Matrix implements IMatrix {

    public UpTriangleMatrix(int N) {
        super(N);
    }

    @Override
    public void changeElem (int x, int y, double v) throws MatrixException {
        if(x > y && v != 0) throw new MatrixException("Диагональная матрица!");
        super.changeElem(x,y,v);
    }
}

