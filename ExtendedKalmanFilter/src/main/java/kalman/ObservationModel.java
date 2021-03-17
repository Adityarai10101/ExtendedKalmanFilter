package kalman;

public abstract class ObservationModel {


    /* This group of matrices must be specified by the user. */
    /* H_k */
    /*public kalman.Matrix observation_model = new kalman.Matrix(observationDimension(), stateDimension());*/
    /* R_k */
    /*public kalman.Matrix observation_noise_covariance = new kalman.Matrix(observationDimension(), observationDimension());*/

    /* The observation is modified by the user every time step. */
    /* z_k */
    /*public kalman.Matrix observation = new kalman.Matrix(observationDimension(), 1);*/

    /* This group of matrices are updated every time step by the filter. */
    /* y-tilde_k */
    /*public kalman.Matrix innovation = new kalman.Matrix(observationDimension(), 1);*/
    /* S_k */
    /*public kalman.Matrix innovation_covariance = new kalman.Matrix(observationDimension(), observationDimension());*/
    /* S_k^-1 */
    /*public kalman.Matrix inverse_innovation_covariance = new kalman.Matrix(observationDimension(), observationDimension());*/
    /* K_k */
    /*public kalman.Matrix optimal_gain = new kalman.Matrix(stateDimension(), observationDimension());*/

    /* This group is used for meaningless intermediate calculations */
    /*public kalman.Matrix vertical_scratch = new kalman.Matrix(stateDimension(), observationDimension());*/

    /*public abstract int observationDimension();*/

    /*public abstract int stateDimension();*/

    /*public abstract void observationMeasurement(double[][] y);*/

    /*public abstract void observationModel(double[][] x, double[][] h);*/

    /*public abstract void observationModelJacobian(double[][] x, double[][] j);*/

    /*public abstract void observationNoiseCovariance(double[][] cov);*/

    /*public void normalizeInnovation(double[][] i) {
        // TODO Auto-generated method stub

    }*/



}
