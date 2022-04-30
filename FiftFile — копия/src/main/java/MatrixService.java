import java.util.Arrays;

public class MatrixService {

    // Напишите класс MatrixService со статическим методом arrangeMatrices, который получает
    // на вход массив матриц произвольного вида и сортирует этот массив по неубыванию определителей
    // матриц (найдите в классе Arrays подходящий метод сортировки).

    public static void arrangeMatrices(Matrix[] matrixes) {
        Arrays.sort(matrixes, new ComparatorMatrix());
    }
}
