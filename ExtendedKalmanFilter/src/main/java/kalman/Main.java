package kalman;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        double[][] d = {{1, 1}, {1,1}};

        Matrix m5 = new Matrix(d);

        m5.prettyPrint();

        d[0][0] = 1283798;

        m5.prettyPrint();

        m5.setColumn(1, new double[] {123,12});


        m5.prettyPrint();

        m5.setEntry(0,0, 23);

        m5.prettyPrint();


        Matrix m6 = m5.copy();

        m6.prettyPrint();

        m5.setEntry(0,0, -12);

        m6.prettyPrint();
        m5.prettyPrint();

        System.out.println(m5.toString());

        Matrix m10 = new Matrix(12,3);
        System.out.println(m10.toString());



    }
}
