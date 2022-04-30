import java.util.Arrays;
import java.util.Objects;

public class Matrix implements Comparable<Matrix>, IMatrix {

    // Напишите класс Matrix (квадратная матрица произвольного вида). Размерность матрицы N задается
    // при создании объекта и в дальнейшем не меняется. Матрицу хранить в виде одномерного массива
    // длины NxN. В классе сделайте конструктор по размерности, добавьте методы equals и hashCode.

    // Добавить в класс Matrix поле для хранения вычисленного значения определителя (кэш для значения
    // определителя) и флаг, который означает, что это значение действительно на данный момент. Методы,
    // изменяющие матрицу, должны сбрасывать этот флаг. При установленном флаге метод вычисления
    // определителя должен просто возвращать сохраненное значение без пересчета.

    //Напишите компаратор для матриц, который сравнивает определители матриц

    private int N;
    private double[] arr;
    private int y = 0 ;

    private double determinator = 1;
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
        if (Math.abs(determinator - determinator) < 1e7) return 0;
        return (int) (determinator - o.determinator);
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
                    y++;
                }
            }
            if (max == 0) { y = 0;}
        }
        return y;
    }

    @Override
    public double determination() throws MatrixException{

        if(flag) {return determinator;}
        determinator = 1;

        if (N == 1) {
            return arr[0];
        }

        if(N == 2) {
            return arr[0] * arr[3] - arr [1] * arr[2];
        }

        for (int i = 0; i < N - 1 ; i++) {
            for (int j = 1 + i; j < N; j++) { //проверка на каждое вычитание

                y = rightViewOfMatrix(arr,getN());

                if ( arr[i + N * i] == 0 ) throw new MatrixException("На ноль делить нельзя");
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