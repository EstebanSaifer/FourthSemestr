
public class UpTriangleMatrix extends Matrix implements IMatrix {

    public UpTriangleMatrix(int N) {
        super(N);
    }

//    public double getDetermination(double[] arr) throws MatrixException {
//        if(getFlag() != 0) return getFlag();
//        for (int i = 0; i < arr.length / getN(); i++) {
//            for (int j = 0; j < arr.length / getN(); j++) {
//                if (i == j) {
//                    if(arr[i + getN() * j] == 0) throw new MatrixException("Делить на ноль нельзя");
//                    //setDeterminationKash(arr[i + getN() * j]); //1,4,8
//                    setDeterminatorFinal(getDeterminationKash() * getDeterminatorFinal());
//                }
//            }
//        }
//        return getDeterminatorFinal();
//    }
//
//    public void setElem (double v, int i, int j) throws MatrixException {
//        if (i != j)
//            throw new MatrixException("i != j");
//
//        getArr()[i+ getN() * j] = v;
//    }
}

