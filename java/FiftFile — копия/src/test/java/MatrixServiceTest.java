import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MatrixServiceTest {
    @Test
    public void test0() throws MatrixException {
        UpTriangleMatrix upTriangleMatrix0 = new UpTriangleMatrix(2);

        upTriangleMatrix0.changeElem(0,0,1);
        upTriangleMatrix0.changeElem(0,1,2);
        upTriangleMatrix0.changeElem(1,1,4);

        UpTriangleMatrix upTriangleMatrix1 = new UpTriangleMatrix(2);

        upTriangleMatrix1.changeElem(0,0,0);
        upTriangleMatrix1.changeElem(0,1,0);
        upTriangleMatrix1.changeElem(1,1,0);

        Matrix[] matrices = new Matrix[] {upTriangleMatrix0, upTriangleMatrix1};

        MatrixService.arrangeMatrices(matrices);

        Matrix[] good = new Matrix[] {upTriangleMatrix1 ,upTriangleMatrix0};

        assertArrayEquals(matrices , good );
    }

    @Test
    public void test1() throws MatrixException {
        UpTriangleMatrix upTriangleMatrix0 = new UpTriangleMatrix(2);

        upTriangleMatrix0.changeElem(0,0,0);
        upTriangleMatrix0.changeElem(0,1,0);
        upTriangleMatrix0.changeElem(1,1,0);

        UpTriangleMatrix upTriangleMatrix1 = new UpTriangleMatrix(2);

        upTriangleMatrix1.changeElem(0,0,1);
        upTriangleMatrix1.changeElem(0,1,1);
        upTriangleMatrix1.changeElem(1,1,1);

        UpTriangleMatrix upTriangleMatrix2 = new UpTriangleMatrix(2);

        upTriangleMatrix1.changeElem(0,0,0);
        upTriangleMatrix1.changeElem(0,1,0);
        upTriangleMatrix1.changeElem(1,1,0);

        Matrix[] matrices = new Matrix[] {upTriangleMatrix0, upTriangleMatrix1, upTriangleMatrix2};

        MatrixService.arrangeMatrices(matrices);

        Matrix[] good = new Matrix[] {upTriangleMatrix0 ,upTriangleMatrix2, upTriangleMatrix1};

        assertArrayEquals(matrices , good );
    }

    @Test
    public void test2() throws MatrixException {
        UpTriangleMatrix upTriangleMatrix0 = new UpTriangleMatrix(2);

        upTriangleMatrix0.changeElem(0,0,2);
        upTriangleMatrix0.changeElem(0,1,2);
        upTriangleMatrix0.changeElem(1,1,2);

        UpTriangleMatrix upTriangleMatrix1 = new UpTriangleMatrix(2);

        upTriangleMatrix1.changeElem(0,0,1);
        upTriangleMatrix1.changeElem(0,1,1);
        upTriangleMatrix1.changeElem(1,1,1);

        UpTriangleMatrix upTriangleMatrix2 = new UpTriangleMatrix(2);

        upTriangleMatrix1.changeElem(0,0,0);
        upTriangleMatrix1.changeElem(0,1,0);
        upTriangleMatrix1.changeElem(1,1,0);

        Matrix[] matrices = new Matrix[] {upTriangleMatrix0, upTriangleMatrix1, upTriangleMatrix2};

        MatrixService.arrangeMatrices(matrices);

        Matrix[] good = new Matrix[] {upTriangleMatrix2 ,upTriangleMatrix1, upTriangleMatrix0};

        assertArrayEquals(matrices , good);
    }
}