public class DiagMatrix extends Matrix {

    public DiagMatrix(int N) {
        super(N);
    }

    //набор элементов на диагонали
    public DiagMatrix(double[] diagArr, int N) throws MatrixException {
        super(N);
        for (int i = 0; i < Math.sqrt(diagArr.length); i++) {
                changeElem(i, i, diagArr[i]);
        }
    }

    @Override
    public void changeElem (int x, int y, double v) throws MatrixException {
        if(x != y) throw new MatrixException("Диагональная матрица!");
    }
}