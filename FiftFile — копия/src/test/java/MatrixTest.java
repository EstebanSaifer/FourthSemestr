import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    @Test (expected = MatrixException.class)
    public void test0 () throws MatrixException {
        Matrix matrix = new Matrix(3);

        assertEquals(matrix.getElem(0,8), 1, 0.0001);
    }

    @Test (expected = MatrixException.class)
    public void test1 () throws MatrixException {
        Matrix matrix = new Matrix(3);

        matrix.changeElem(10,0,8);
    }

    @Test
    public void test2() throws MatrixException {
        Matrix matrix = new Matrix(3);

        matrix.changeElem(0, 0, -1);
        matrix.changeElem(1, 0, 1);
        matrix.changeElem(2, 0, 1);

        matrix.changeElem(0, 1, 0);
        matrix.changeElem(1, 1, 1);
        matrix.changeElem(2, 1, 1);

        matrix.changeElem(0, 2, 0);
        matrix.changeElem(1, 2, 1);
        matrix.changeElem(2, 2, 2);

        assertEquals(matrix.determination(), -1, 0.0001);
    }

    @Test
    public void test3() throws MatrixException {
        Matrix matrix = new Matrix(3);

        matrix.changeElem(0, 0, 1);
        matrix.changeElem(1, 0, 0);
        matrix.changeElem(2, 0, 0);

        matrix.changeElem(0, 1, 0);
        matrix.changeElem(1, 1, 1);
        matrix.changeElem(2, 1, 0);

        matrix.changeElem(0, 2, 0);
        matrix.changeElem(1, 2, 0);
        matrix.changeElem(2, 2, 2);

        assertEquals(matrix.determination(), 2, 0.0001);
    }

    @Test
    public void test4() throws MatrixException {
        Matrix matrix = new Matrix(3);

        matrix.changeElem(0, 0, 0);
        matrix.changeElem(1, 0, 0);
        matrix.changeElem(2, 0, 1);

        matrix.changeElem(0, 1, 0);
        matrix.changeElem(1, 1, 1);
        matrix.changeElem(2, 1, 0);

        matrix.changeElem(0, 2, 1);
        matrix.changeElem(1, 2, 0);
        matrix.changeElem(2, 2, 0);

        assertEquals(matrix.determination(), -1, 0.0001);

        matrix.determination(); // flag работает
    }

    @Test (expected = MatrixException.class)
    public void test5 () throws MatrixException{
        Matrix matrix = new Matrix(5);

        for(int i = 0; i < matrix.getN(); i ++) {
            for ( int j = 0; j < matrix.getN(); j++) {
                matrix.changeElem(i,j,0);
            }
        }
        matrix.determination();
    }
}