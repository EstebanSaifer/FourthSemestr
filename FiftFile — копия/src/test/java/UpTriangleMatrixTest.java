import org.junit.Test;

import static org.junit.Assert.*;

public class UpTriangleMatrixTest {

    @Test
    public void test0() throws MatrixException {
        UpTriangleMatrix upTriangleMatrix = new UpTriangleMatrix(2);
        upTriangleMatrix.changeElem(0, 1, 1);
        assertEquals(1, upTriangleMatrix.getElem(0,1), 0.0001);
    }

    @Test (expected = MatrixException.class)
    public void test1() throws MatrixException {
        UpTriangleMatrix upTriangleMatrix = new UpTriangleMatrix(2);
        upTriangleMatrix.changeElem(1, 0, 1);
    }

    @Test
    public void test2() throws MatrixException{
        UpTriangleMatrix upTriangleMatrix = new UpTriangleMatrix(2);
        upTriangleMatrix.changeElem(1, 0, 0);
    }

    @Test
    public void test3() throws MatrixException {
        UpTriangleMatrix upTriangleMatrix = new UpTriangleMatrix(2);
        upTriangleMatrix.changeElem(0, 0, 1);
        upTriangleMatrix.changeElem(0, 1, 2);
        upTriangleMatrix.changeElem(1, 1, -3);

        assertEquals(upTriangleMatrix.determination(), -3, 0.0001);
    }

    @Test
    public void test4() throws MatrixException {
        UpTriangleMatrix upTriangleMatrix = new UpTriangleMatrix(1);
        upTriangleMatrix.changeElem(0, 0, 1);
        assertEquals(upTriangleMatrix.determination(), 1, 0.0001);
    }

    @Test
    public void test5() throws MatrixException {
        UpTriangleMatrix upTriangleMatrix = new UpTriangleMatrix(4);
        double k = 1;
        for (int i = 0; i < upTriangleMatrix.getN(); i++) {
            for (int j = 0; j < upTriangleMatrix.getN(); j++) {
                if (i == j) {
                    upTriangleMatrix.changeElem(i, j, 1);
                    //System.out.println(upTriangleMatrix.getElem(i , j));
                }
            }
        }

        upTriangleMatrix.determination();

        assertEquals(upTriangleMatrix.determination(), 1, 0.0001);
    }

    @Test //проверить значеие матрицы 4*4 от 1 до 16
    public void test6() throws MatrixException {
        UpTriangleMatrix upTriangleMatrix = new UpTriangleMatrix(4);
        double k = 1;
        for (int i = 0; i < upTriangleMatrix.getN(); i++) {
            for (int j = 0; j < upTriangleMatrix.getN(); j++) {
                if (i == j) {
                    upTriangleMatrix.changeElem(i, j, k);
                    k++;
                }
            }
        }
        upTriangleMatrix.determination();
        assertEquals(upTriangleMatrix.determination(), 24, 0.0001);
    }
}