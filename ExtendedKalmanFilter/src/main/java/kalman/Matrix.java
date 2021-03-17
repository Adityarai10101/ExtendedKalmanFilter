package kalman;

import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.linear.MatrixDimensionMismatchException;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.MatrixUtils;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This kalman.Matrix class adapts the generic commons-math3's code to make it more suitable for our specific implementation
 *
 * NOTES:
 * bc I am bad at linear algebra:
 * https://www.khanacademy.org/math/precalculus/x9e81a4f98389efdf:matrices/x9e81a4f98389efdf:properties-of-matrix-multiplication/v/identity-matrix-dimensions
 */
public class Matrix {


    //#################################################################################################################
    //#################################################################################################################
    //#################################################################################################################
    //
    //  This section is for setup (static setup, class members)
    //
    //#################################################################################################################

    /**
     * class logger
     */
    private static final Logger logger = LogUtils.getLogger(Matrix.class.getName());

    static
    {
        LogUtils.setLoggerLevel(logger, Level.FINE);
    }

    /**
     * 2d double array that stores the matrix data
     * matrix[row index][column index]
     */
    private RealMatrix matrix;


    //#################################################################################################################
    //#################################################################################################################
    //#################################################################################################################
    //
    //  This section is for class constructors
    //
    //#################################################################################################################
    /**
     * Constructor #1: creates a matrix of O's
     * @param r number of rows in the matrix
     * @param c number of columns in the matrix
     */
    public Matrix(int r, int c)
    {
        try {
            //implicitly initiated to zeroes
            //per language spec...should be pretty robust
            this.matrix = new Array2DRowRealMatrix( new double[r][c] );

            logger.log(Level.INFO, (matrix.getRowDimension() + "x" + matrix.getColumnDimension() + " matrix created. C1"));
        }
        catch (OutOfMemoryError e)
        {
            logger.log(Level.SEVERE, (r + "x" + c + " matrix out of memory. C1"));
        }

    }

    /**
     * Constructor #2: creates a matrix from array of doubles (deep copy)
     * @param arr array[row][column]
     */
    public Matrix(double[][] arr)
    {
        try {
            this.matrix = new Array2DRowRealMatrix( arr );
            logger.log(Level.INFO, (matrix.getRowDimension() + "x" + matrix.getColumnDimension() + " matrix created. C2"));
        }
        catch (OutOfMemoryError e)
        {
            logger.log(Level.SEVERE, (arr.length + "x" + arr[0].length + " matrix out of memory. C2"));
        }
    }


    //#################################################################################################################
    //#################################################################################################################
    //#################################################################################################################
    //
    //  This section is for matrix special functions (identity matrices)
    //
    //#################################################################################################################
    /**
     * Calculates identity matrix for data
     * @return identity matrix
     */
    private RealMatrix calculateIdentityMatrix()
    {
        //if a matrix has dimensions axb, then the identity matrix will always be axa

        RealMatrix newMatrix = MatrixUtils.createRealIdentityMatrix(matrix.getRowDimension());

        logger.log(Level.FINE, "convertIdentityMatrix(): " + matrix.getRowDimension() + "x" + matrix.getColumnDimension() + "->"
                                   + newMatrix.getRowDimension() + "x" + newMatrix.getColumnDimension() );
        return newMatrix;
    }


    /**
     * Turns current matrix into identity matrix
     */
    public void setIdentityMatrix() {
        matrix = calculateIdentityMatrix();
        logger.log(Level.FINE, "setIdentityMatrix()");
    }

    /**
     * gets identity matrix from current matrix
     * @return RealMatrix identity matrix
     */
    public Matrix getIdentityMatrix() {

        RealMatrix w = calculateIdentityMatrix();

        logger.log(Level.FINE, "getIdentityMatrix()");

        return new Matrix(w.getData());
    }



    //#################################################################################################################
    //#################################################################################################################
    //#################################################################################################################
    //
    //  This section is for matrix operations (add, subtract, multiply) + special operations (tbd)
    //
    //#################################################################################################################
    //TODO: add_matrix(a, b, c). c = a + b

    //TODO: subtract_matrix(a, b, c). Same idea.

    //TODO: multiply_matrix(a, b, c). Same idea.

    //TODO: subtract_from_identity_matrix(kalman.Matrix a)






    //#################################################################################################################
    //#################################################################################################################
    //#################################################################################################################
    //
    //  This section is to for changing the matrix data (row, column, or entry)
    //
    //#################################################################################################################

    /**
     * sets a column of the matrix to new values
     * @param column column index
     * @param data new data (same length as column)
     */
    public void setColumn(int column, double[] data)
    {
        try {
            logger.log(Level.FINE, "setColumn() called: col = " + column);
            matrix.setColumn(column, data);
        }
        catch( OutOfRangeException e)
        {
            logger.log(Level.SEVERE, "Out of Range index occurred: " + column + " >= " + matrix.getColumnDimension());
        }
        catch( MatrixDimensionMismatchException e)
        {
            logger.log(Level.SEVERE, "new row size " + data.length + " > " + matrix.getColumnDimension());
        }
    }

    /**
     * sets a row of the matrix to new values
     * @param row row index
     * @param data new data (same length as column)
     */
    public void setRow(int row, double[] data)
    {
        try {
            logger.log(Level.FINE, "setRow(): row = " + row);
            matrix.setRow(row, data);
        }
        catch( OutOfRangeException e)
        {
            logger.log(Level.SEVERE, "Out of Range index occurred: " + row + " >= " + matrix.getRowDimension());
        }
        catch( MatrixDimensionMismatchException e)
        {
            logger.log(Level.SEVERE, "new row size " + data.length + " > " + matrix.getRowDimension());
        }
    }

    /**
     * Sets the entry in the specified row and column
     * @param row row index
     * @param column column index
     * @param data new data
     */
    public void setEntry(int row, int column, double data)
    {
        try {
            logger.log(Level.FINE, "setEntry(): index" + "(" + row + ", " + column + ") = "  + data);
            matrix.setEntry(row, column, data);
        }
        catch ( OutOfRangeException e)
        {
            logger.log(Level.SEVERE, "Out of Range index occurred: " + "(" + row + ", " + column + ") called on "
                    + matrix.getRowDimension() + "x" + matrix.getColumnDimension() + " matrix");
        }

    }

    //#################################################################################################################
    //#################################################################################################################
    //#################################################################################################################
    //
    //  This section is for helper functions (basic sets, gets, copies, pretty print, tostring)
    //
    //#################################################################################################################
    /**
     * gets matrix data
     */
    public double[][] getData()
    {
        logger.log(Level.FINE, "getData()");
        return matrix.getData();
    }

    /**
     * creates (deep) copy of Matrix
     */
    public Matrix copy()
    {
        logger.log(Level.FINE, "copy()");
        return new Matrix(matrix.getData());
    }

    /**
     * pretty-print matrix to console.
     */
    public void prettyPrint()
    {
        double[][] data = matrix.getData();

        logger.log(Level.FINE, "prettyPrint()");
        for (int i = 0; i < matrix.getRowDimension(); ++i) {
            for (int j = 0; j < matrix.getColumnDimension(); ++j) {
                if (j > 0) {
                    System.out.print(" ");
                }
                System.out.format("%6.2f", data[i][j]);
            }
            System.out.print("\n");
        }
    }

    /**
     * converts matrix data to string
     */
    @Override
    public String toString() {
        logger.log(Level.FINE, "toString()");

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for(double[] subarr : matrix.getData())
        {
            sb.append(Arrays.toString(subarr));
            sb.append(", ");
        }
        sb.replace(sb.length() -2, sb.length(),"}");
        return sb.toString();
    }


}


