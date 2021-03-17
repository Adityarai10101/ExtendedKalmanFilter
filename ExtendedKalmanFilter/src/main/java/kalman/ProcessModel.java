package kalman;

public abstract class ProcessModel {

    /* This group of matrices must be specified by the user. */
    //TODO public kalman.Matrix state_function = new kalman.Matrix(stateDimension(), 1);
    //TODO public kalman.Matrix state_jacobian = new kalman.Matrix(stateDimension(), stateDimension());
    //TODO public kalman.Matrix process_noise_covariance = new kalman.Matrix(stateDimension(), stateDimension());

    /* This group of matrices are updated every time step by the filter. */
    /*public kalman.Matrix state_estimate = new kalman.Matrix(stateDimension(), 1);*/
    /*public kalman.Matrix estimate_covariance = new kalman.Matrix(stateDimension(), stateDimension());*/

    /* This group is used for meaningless intermediate calculations */
    /*
    TODO change matrix definitions based on new matrix class
    public kalman.Matrix big_square_scratch = new kalman.Matrix(stateDimension(), stateDimension());
    public kalman.Matrix big_square_scratch2 = new kalman.Matrix(stateDimension(), stateDimension());
    public kalman.Matrix identity_scratch = new kalman.Matrix(stateDimension(), stateDimension());
    public kalman.Matrix state_transition = new kalman.Matrix(stateDimension(), stateDimension());
    public kalman.Matrix predicted_state_midpoint = new kalman.Matrix(stateDimension(), 1);
    public kalman.Matrix state_delta_scratch = new kalman.Matrix(stateDimension(), 1);*/
/*
    TODO change methods based on new classes

    public kalman.ProcessModel() {
        identity_scratch.set_identity_matrix();
    }

    public double[][] getState() {
        return state_estimate.data;
    }

    public double getState(int state) {
        return state_estimate.data[state][0];
    }

    public void setState(int state, double v) {
        state_estimate.data[state][0] = v;
    }

    public double[][] getCovariance() {
        return estimate_covariance.data;
    }

    public double getCovariance(int state) {
        return estimate_covariance.data[state][0];
    }

    public void setCovarianceClearRowCol(int state, double v) {
        for (int i = 0; i < estimate_covariance.data.length; i++) {
            estimate_covariance.data[state][i] = 0;
            estimate_covariance.data[i][state] = 0;
        }
        estimate_covariance.data[state][state] = v;
    }

    public abstract int stateDimension();

    public abstract void initialState(double[][] x);

    public abstract void initialStateCovariance(double[][] cov);

    public abstract void stateFunction(double[][] x, double[][] f);

    public abstract void stateFunctionJacobian(double[][] x, double[][] j);

    public abstract void processNoiseCovariance(double[][] cov);

    public void normalizeState(double[][] x) {
    }


 */
}
