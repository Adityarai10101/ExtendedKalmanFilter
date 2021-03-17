package kalman;

import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This kalman.Matrix class adapts the generic commons-math3's code to make it more suitable for our specific implementation
 */
public class Matrix {

    /**
     * class logger
     */
    private static final Logger logger = LogUtils.getLogger(Matrix.class.getName());

    static
    {
        LogUtils.setLoggerLevel(logger, Level.SEVERE);
    }

    /**
     * 2d double array that stores the matrix data
     */
    private double[][] data;

    /**
     * num rows
     */
    private int rows;

    /**
     * num cols
     */
    private int cols;


    //TODO: kalman.Matrix constructor. Takes integer params rows and columns
    /**
     * Constructor #1
     * @param rows number of rows in the matrix
     * @param columns number of columns in the matrix
     */
    public Matrix(int rows, int columns)
    {

    }

    //TODO: public void set_matrix(). Takes 2D array and sets matrix.

    //TODO: public void set_identity_matrix(). Turns the current data into an identity matrix

    //TODO: public void copy_matrix(matrix source, matrix destination). deep copy the matrix

    //TODO: pretty_print() // pretty-print ze matrix

    //TODO: add_matrix(a, b, c). c = a + b

    //TODO: subtract_matrix(a, b, c). Same idea.

    //TODO: multiply_matrix(a, b, c). Same idea.

    //TODO: subtract_from_identity_matrix(kalman.Matrix a)

    //TODO: convert all these functions below

//
//    /* Multiply matrix a by b-transpose and put the result in c. */
//    /*
//     * This is multiplying a by b-tranpose so it is like multiply_matrix but
//     * references to b reverse rows and cols.
//     */
//    public static void multiply_by_transpose_matrix(kalman.Matrix a, kalman.Matrix b, kalman.Matrix c) {
//        assert (a.cols == b.cols);
//        assert (a.rows == c.rows);
//        assert (b.rows == c.cols);
//        for (int i = 0; i < c.rows; ++i) {
//            for (int j = 0; j < c.cols; ++j) {
//                /*
//                 * Calculate element c.data[i][j] via a dot product of one row
//                 * of a with one row of b
//                 */
//                c.data[i][j] = 0.0;
//                for (int k = 0; k < a.cols; ++k) {
//                    c.data[i][j] += a.data[i][k] * b.data[j][k];
//                }
//            }
//        }
//    }
//


//    /* Transpose input and put the result in output. */
//    public static void transpose_matrix(kalman.Matrix input, kalman.Matrix output) {
//        assert (input.rows == output.cols);
//        assert (input.cols == output.rows);
//        for (int i = 0; i < input.rows; ++i) {
//            for (int j = 0; j < input.cols; ++j) {
//                output.data[j][i] = input.data[i][j];
//            }
//        }
//    }
//
//    /* Whether two matrices are approximately equal. */
//    public static boolean equal_matrix(kalman.Matrix a, kalman.Matrix b, double tolerance) {
//        assert (a.rows == b.rows);
//        assert (a.cols == b.cols);
//        for (int i = 0; i < a.rows; ++i) {
//            for (int j = 0; j < a.cols; ++j) {
//                if (Math.abs(a.data[i][j] - b.data[i][j]) > tolerance) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    /* Multiply a matrix by a scalar. */
//    public void scale_matrix(double scalar) {
//        assert (scalar != 0.0);
//        for (int i = 0; i < rows; ++i) {
//            for (int j = 0; j < cols; ++j) {
//                data[i][j] *= scalar;
//            }
//        }
//    }
//
//    /*
//     * Swap rows r1 and r2 of a matrix. This is one of the three
//     * "elementary row operations".
//     */
//    public void swap_rows(int r1, int r2) {
//        assert (r1 != r2);
//        double[] tmp = data[r1];
//        data[r1] = data[r2];
//        data[r2] = tmp;
//    }
//
//    /*
//     * Multiply row r of a matrix by a scalar. This is one of the three
//     * "elementary row operations".
//     */
//    public void scale_row(int r, double scalar) {
//        assert (scalar != 0.0);
//        for (int i = 0; i < cols; ++i) {
//            data[r][i] *= scalar;
//        }
//    }
//
//    /*
//     * Add a multiple of row r2 to row r1. Also known as a "shear" operation.
//     * This is one of the three "elementary row operations".
//     */
//    /* Add scalar * row r2 to row r1. */
//    public void shear_row(int r1, int r2, double scalar) {
//        assert (r1 != r2);
//        for (int i = 0; i < cols; ++i) {
//            data[r1][i] += scalar * data[r2][i];
//        }
//    }
//
//    /*
//     * Invert a square matrix. Returns whether the matrix is invertible. input
//     * is mutated as well by this routine.
//     */
//
//    /*
//     * Uses Gauss-Jordan elimination.
//     *
//     * The elimination procedure works by applying elementary row operations to
//     * our input matrix until the input matrix is reduced to the identity
//     * matrix. Simultaneously, we apply the same elementary row operations to a
//     * separate identity matrix to produce the inverse matrix. If this makes no
//     * sense, read wikipedia on Gauss-Jordan elimination.
//     *
//     * This is not the fastest way to invert matrices, so this is quite possibly
//     * the bottleneck.
//     */
//    public static boolean destructive_invert_matrix(kalman.Matrix input, kalman.Matrix output) {
//        assert (input.rows == input.cols);
//        assert (input.rows == output.rows);
//        assert (input.rows == output.cols);
//
//        output.set_identity_matrix();
//
//        /*
//         * Convert input to the identity matrix via elementary row operations.
//         * The ith pass through this loop turns the element at i,i to a 1 and
//         * turns all other elements in column i to a 0.
//         */
//        for (int i = 0; i < input.rows; ++i) {
//            if (input.data[i][i] == 0.0) {
//                /* We must swap rows to get a nonzero diagonal element. */
//                int r;
//                for (r = i + 1; r < input.rows; ++r) {
//                    if (input.data[r][i] != 0.0) {
//                        break;
//                    }
//                }
//                if (r == input.rows) {
//                    /*
//                     * Every remaining element in this column is zero, so this
//                     * matrix cannot be inverted.
//                     */
//                    return false;
//                }
//                input.swap_rows(i, r);
//                output.swap_rows(i, r);
//            }
//
//            /*
//             * Scale this row to ensure a 1 along the diagonal. We might need to
//             * worry about overflow from a huge scalar here.
//             */
//            double scalar = 1.0 / input.data[i][i];
//            input.scale_row(i, scalar);
//            output.scale_row(i, scalar);
//
//            /* Zero out the other elements in this column. */
//            for (int j = 0; j < input.rows; ++j) {
//                if (i == j) {
//                    continue;
//                }
//                double shear_needed = -input.data[j][i];
//                input.shear_row(j, i, shear_needed);
//                output.shear_row(j, i, shear_needed);
//            }
//        }
//
//        return true;
//    }
//
//    public void zero_matrix() {
//        for (int i = 0; i < rows; ++i) {
//            for (int j = 0; j < cols; ++j) {
//                data[i][j] = 0.0;
//            }
//        }
//    }
//
//    public static void add_scaled_matrix(kalman.Matrix a, double s, kalman.Matrix b, kalman.Matrix c) {
//        assert (a.rows == b.rows);
//        assert (a.rows == c.rows);
//        assert (a.cols == b.cols);
//        assert (a.cols == c.cols);
//        for (int i = 0; i < a.rows; ++i) {
//            for (int j = 0; j < a.cols; ++j) {
//                c.data[i][j] = a.data[i][j] + s * b.data[i][j];
//            }
//        }
//    }
}


