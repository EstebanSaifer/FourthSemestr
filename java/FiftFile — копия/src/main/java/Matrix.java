import java.util.Arrays;
import java.util.Objects;

public class Matrix implements IMatrix {

    private int N;
    private double[] arr;
    private int y = 0 ;

    private double determinator = 1;
    private boolean flag;

    public Matrix(int N) {
        this.N = N;
        this.arr = new double[N * N];
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
    public double getElem(int x, int y) throws MatrixException {
        if (x > getN() || y > getN() || x < 0 || y < 0) throw new MatrixException("неккоректные данные");
        return arr[x + getN() * y];
    }

    @Override
    public void changeElem(int x, int y, double newElem) throws MatrixException {
        if (x >= getN() || y >= getN() || x < 0 || y < 0) {
            throw new MatrixException("неккоректные данные");
        }
        arr[x + N * y] = newElem;
        flag = false;
    }

    public int rightViewOfMatrix (double[] arr, int N) {
        // Поиск строки с максимальным знаением столбца
        for(int k = 0; k < N - 1; k++) {
            double max = arr[k + N * k];
            int index = k;
            for(int i = k + 1; i < N; i++) {
                if(Math.abs(arr[i + N * k]) > Math.abs(max)) {
                    max = arr[i + N * k];
                    index = i;
                }
            }

            if(k != index) {
                for(int j = 0; j < N; j++) {
                    double tempt = 0;
                    tempt = arr[index + N * j];
                    arr[index + N * j] = arr[k + N * j];
                    arr[k + N * j] = tempt;

                }
                y++;
            }
            if (max == 0) { y = 0;}
        }
        return y;
    }

    @Override
    public double determination() {

        if(flag) {return determinator;}
        determinator = 1;

        if (N == 1) {
            return arr[0];
        }

        if(N == 2) {
            return arr[0] * arr[3] - arr [1] * arr[2];
        }

        y = 0;
        for (int i = 0; i < N - 1 ; i++) {

                y = rightViewOfMatrix(arr,getN());

                if ( arr[i + N * i] == 0 )  {
                    determinator = 0;
                    flag = true;
                    return determinator;
                }

            for (int j = 1 + i; j < N; j++) { //проверка на каждое вычитание
                double time = -1 * arr[i + N * j] /arr[i + N * i];   //работа с норм матрицей
                if(arr[i + N * j] != 0 ) {
                    for(int k = 0; k < N; k++) {
                        arr[k + N * j] += time * arr[k + N * i];
                    }
                }
            }
        }

        flag = true;

        for (int i = 0; i < N; i++) {
            determinator *= arr[i + N * i];
        }

        if ( (y % 2) != 0 ) {
            determinator = -determinator;
        }

        return determinator;
    }
}