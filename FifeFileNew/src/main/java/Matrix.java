import java.util.Arrays;
import java.util.Objects;

public class Matrix implements Comparable<Matrix>, IMatrix {

    private int N;
    private double[] arr;

    private double determinatorFinal = 1;
    private boolean flag;

    public Matrix(int N) {
        this.N = N;
        this.arr = new double[N * N];
    }

    public Matrix() {
        this.N = 0;
        this.arr = new double[0];
    }

    public int getN() {
        return N;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return N == matrix.N && Arrays.equals(arr, matrix.arr);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(N);
        result = 31 * result + Arrays.hashCode(arr);
        return result;
    }

    @Override
    public int compareTo(Matrix o) {
        if(Math.abs(determinatorFinal - determinatorFinal) < 1e7) return 0;
        return (int) (determinatorFinal - o.determinatorFinal);
    }

    @Override
    public double elem( int x, int y) throws MatrixExceptionNew{
        if(x > getN() || y > getN() || x < 0 || y < 0) throw new MatrixExceptionNew("неккоректные данные");
        return arr[x + getN() * y];
    }

    @Override
    public void changeElem( int x, int y, double newElem) throws MatrixExceptionNew{
        if(x >= getN() || y >= getN() || x < 0 || y < 0) {throw new MatrixExceptionNew("неккоректные данные");}
        arr[x + N * y] = newElem;
        flag = false;
    }

    @Override
    public double determination () {
        if(flag) {return determinatorFinal;}
        int l = 0;
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 1 + i; j < arr.length; j++) {
                while (l < N) {
                    arr[l] = i + 2;
                    l++;
                }
            }
            l = i + 1;
        }
        return determinatorFinal;
    }


//    public double determination() {
//        if(flag) return determinatorFinal;
//        for (int i = 0; i < arr.length / getN(); i++) {
//            for (int j = 0; j < arr.length / getN(); j++) {
//                if (i == j) {
//                    determinationKash =arr[i + getN() * j];
//                    determinatorFinal = determinationKash * determinatorFinal;
//                }
//            }
//        }
//        return determinatorFinal;
//    }
}
