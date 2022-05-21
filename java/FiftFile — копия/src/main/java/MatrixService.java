import java.util.Arrays;

public class MatrixService {

    public static void arrangeMatrices(Matrix[] matrixes) {
        Arrays.sort(matrixes, new ComparatorMatrix());
    }
}
