import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    @Test (expected = MatrixExceptionNew.class)
    public void test0 () throws MatrixExceptionNew {
        Matrix matrix = new Matrix(3);
        assertEquals(matrix.elem(0,8), 1, 0.0001);
    }

    @Test (expected = MatrixExceptionNew.class)
    public void test1 () throws MatrixExceptionNew {
        Matrix matrix = new Matrix(3);

        matrix.changeElem(10,0,8);
    }

    @Test
    public void test2() throws MatrixExceptionNew {
        Matrix matrix = new Matrix(3);

        matrix.changeElem(0,0,1);
        matrix.changeElem(1,0,2);
        matrix.changeElem(2,0,3);

        matrix.changeElem(0,1,1);
        matrix.changeElem(1,1,1);
        matrix.changeElem(2,1,1);

        matrix.changeElem(0,2,3);
        matrix.changeElem(1,2,2);
        matrix.changeElem(2,2,1);

        System.out.println(matrix.elem(0,0));
        System.out.println(matrix.elem(1,0));
        System.out.println(matrix.elem(2,0));

        System.out.println(matrix.elem(0,1));
        System.out.println(matrix.elem(1,1));
        System.out.println(matrix.elem(2,1));

        System.out.println(matrix.elem(0,2));
        System.out.println(matrix.elem(1,2));
        System.out.println(matrix.elem(2,2));

        assertEquals(matrix.determination(), 0, 0.0001);
    }

    @Test
    public void test3 () throws MatrixExceptionNew {
        Matrix matrix = new Matrix(3);
        double[] myArr = new double[] {1,0,0, 0,2,0, 0,0,4};

        //assertEquals(matrix.determination(myArr), 8, 0.0001);
    }

    @Test
    public void test4 () throws MatrixExceptionNew {
        Matrix matrix = new Matrix(3);
        double[] myArr = new double[] {1,0,0, 0,2,0, 0,0,4};
        double[] myArr0 = new double[] {0,0,0, 0,2,0, 0,0,4};

//        assertEquals(matrix.determination(myArr), 8, 0.0001);
//        assertEquals(matrix.determination(myArr0), 0, 0.0001);
    }
}