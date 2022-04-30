import org.junit.Test;

public class MatrixServiceTest {
    @Test
    public void test0 () throws MatrixException {
        UpTriangleMatrix upTriangleMatrix = new UpTriangleMatrix(2);
        upTriangleMatrix.changeElem(0,0,1);
        upTriangleMatrix.changeElem(0,1,2);
        upTriangleMatrix.changeElem(1,1,3);

        Matrix[] matrices = new Matrix[] {new DiagMatrix(new double[] {1,2},2), upTriangleMatrix};
        MatrixService.arrangeMatrices(matrices);

    }
}