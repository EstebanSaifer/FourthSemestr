import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiagMatrixTest {

    @Test(expected = MatrixException.class)
    public void test0() throws MatrixException {

        double[] diagArr = new double[9];
        DiagMatrix diagMatrix = new DiagMatrix(diagArr, 3);

        diagMatrix.changeElem(0, 0, 2);
        diagMatrix.changeElem(1, 1, 2);
        diagMatrix.changeElem(2, 2, 4);
        diagMatrix.changeElem(0, 1, 8);
    }

    @Test
    public void test1() throws MatrixException {

        double[] diagArr = new double[9];
        DiagMatrix diagMatrix = new DiagMatrix(diagArr, 3);

        diagMatrix.changeElem(0, 0, 2);
        assertEquals(2, diagMatrix.getElem(0,0), 0.0001);
    }

}